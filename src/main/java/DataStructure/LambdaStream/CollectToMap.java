package DataStructure.LambdaStream;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectToMap {

    @Data
    @Builder
    static class ObiectMap{
        private String key;
        private String value;
    }

    public static void main(String[] args) {

        List<String> strings = Lists.newArrayList("name=kk", "sex=1", "tel=1111", "email=xx@qq.com","name=ww","name=yy");

        System.out.println("map1: ");
        Map<String, List<String>> collect1 = strings.stream().map(e -> { //封装成对象
            String[] split = e.split("\\=", 2);
            return ObiectMap.builder().key(split[0]).value(split[1]).build();
        }).collect(Collectors.toMap(ObiectMap::getKey,v->Lists.newArrayList(v.getValue()), (List<String> newList, List<String> oldList) -> { // Collectors.toMap(a,b,(n1,n2)) -> a代表Map的key (这里直接用方法引用拿到key) b代表value (n1,n2)代表key相同时value的处理办法,直接合并List
            oldList.addAll(newList);
            return oldList;
        }));
        collect1.forEach((k,v)->{
            System.out.printf(k+" { ");
            String vList = v.stream().collect(Collectors.joining(",")); //加上逗号,最后一个不加
            System.out.printf(vList);
            System.out.printf(" }");
            System.out.println();
        });
        System.out.println();

        System.out.println("map2: ");
        Map<String, List<String>> collect2 = strings.stream().map(e -> {
            String[] split = e.split("\\=", 2);
            return ObiectMap.builder().key(split[0]).value(split[1]).build();
        }).collect(Collectors.groupingBy(ObiectMap::getKey, Collectors.mapping(ObiectMap::getValue, Collectors.toList()))); //Collectors.groupingBy(a,b) a还是通过key来分组 ,b将value收集起来做list value
        collect2.forEach((k,v)->{
            System.out.printf(k+" { ");
            String vList = v.stream().collect(Collectors.joining(",")); //加上逗号,最后一个不加
            System.out.printf(vList);
            System.out.printf(" }");
            System.out.println();
        });
        System.out.println();

        System.out.println("map3: get name List with Multimap");
        List<ObiectMap> collect3 = strings.stream().map(e -> {
            String[] split = e.split("\\=", 2);
            return ObiectMap.builder().key(split[0]).value(split[1]).build();
        }).collect(Collectors.toList());
        Multimap<String, String> multiMap = ArrayListMultimap.create();  //使用Guava的Multimap来存 value直接是collection,可以随意转换
        collect3.forEach(c -> multiMap.put(c.getKey(), c.getValue()));
        System.out.println(multiMap.get("name").stream().collect(Collectors.joining(",")));
        System.out.println();

        System.out.println("map4: get name with count");
        Map<String, Long> collect4 = strings.stream().map(e -> {
            String[] split = e.split("\\=", 2);
            return ObiectMap.builder().key(split[0]).value(split[1]).build();
        }).collect(Collectors.groupingBy(ObiectMap::getKey, Collectors.counting())); // 拿到数量
        collect4.forEach((k,v)->{
            System.out.printf(k+" { ");
            System.out.printf("%d",v);
            System.out.printf(" }");
            System.out.println();
        });
        System.out.println();
    }
}
