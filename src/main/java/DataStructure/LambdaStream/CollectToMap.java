package DataStructure.LambdaStream;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectToMap {

    @Data
    @Builder
    static class ObiectMap{
        private String key;
        private String value;
    }
    @Data
    @Builder
    static class NumObj{
        private String key;
        private Integer value;
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


        System.out.println("map6: get specialString");
        // 又来一个新需求 我们需要将相同key的value集合起来(对象list<Obiect>或者list<string>),并按照指定字符串进行内部排序 例如aa > bb > cc (指定字符) 其他的排在后边
        List<String> specialString = Lists.newArrayList( "name=cc","sex=dd","name=bb","name=aa", "sex=aa","name=ww");

        Map<String,Integer> keyMap=new HashMap(){{
           put("aa",1);
           put("bb",2);
           put("cc",3);
        }};
        Map<String, List<String>> collect5 = specialString.stream().map(e -> { //封装成对象
            String[] split = e.split("\\=", 2);
            return ObiectMap.builder().key(split[0]).value(split[1]).build();
        }).collect(Collectors.groupingBy(ObiectMap::getKey, Collectors.mapping(ObiectMap::getValue, toSortedList((o1, o2) -> { //groupingBy 可以有三个重载方法 三个参数分别是 1.分类器(通过什么方式分类) 2.封装类(默认hashmap 可以传一些其他Collector) 3.收集dowStream (默认tolist)
            if (keyMap.get(o1) == null) { //Collectors.mapping 返回是一个Collector 里面可以指定通过特定值收集  toSortedList我们自定义一个收集器
                return 1;
            } else if (keyMap.get(o2) == null) {
                return -1;
            } else if (keyMap.get(o1) == null && keyMap.get(o2) == null) {
                return 0;
            }
            return keyMap.get(o1).compareTo(keyMap.get(o2));
        }))));

        collect5.forEach((k,v)->{
            System.out.printf(k+" ");
            System.out.println(v);
            System.out.printf(" ");
            System.out.println();
        });

        System.out.println("map7: get specialString sort first");
        Map<String, List<String>> collect6 = specialString.stream().map(e -> { //封装成对象
            String[] split = e.split("\\=", 2);
            return ObiectMap.builder().key(split[0]).value(split[1]).build();
        }).sorted((o1,o2)->{
            if (keyMap.get(o1.getValue()) == null) {
                return 1;
            } else if (keyMap.get(o2.getValue()) == null) {
                return -1;
            } else if (keyMap.get(o1.getValue()) == null && keyMap.get(o2.getValue()) == null) {
                return 0;
            }
            return keyMap.get(o1.getValue()).compareTo(keyMap.get(o2.getValue()));
        }).collect(Collectors.groupingBy(ObiectMap::getKey,LinkedHashMap::new,Collectors.mapping(ObiectMap::getValue,Collectors.toList())));

        collect6.forEach((k,v)->{
            System.out.printf(k+" ");
            System.out.println(v);
            System.out.printf(" ");
            System.out.println();
        });

        System.out.println("map8: get sorted max element");
        List<String> numStr = Lists.newArrayList("aa=1", "bb=10", "cc=1111", "aa=66","cc=22","dd=101");
        Map<String, Integer> collect8 = numStr.stream().map(e -> {
            String[] split = e.split("=");
            return NumObj.builder().key(split[0]).value(Integer.parseInt(split[1])).build(); //老样子先转换成对象
        }).collect(Collectors.groupingBy(NumObj::getKey // 然后通过groupingBy使用对象的KEY去分类 reducing(a,b,c)规约函数流由一个个元素组成，归约就是将一个个元素“折叠”成一个值，如求和、求最值、求平均值都是归约操作。
                , Collectors.collectingAndThen(Collectors.reducing(0, NumObj::getValue, (c1, c2) -> { //collectingAndThen(a,b) 包装一层,不然外边拿到的是Optional类对象,
                     return c1>c2?c1:c2;
                }), e -> e)));
        collect8.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
//        (() -> new TreeMap().descendingMap())
        System.out.println("map9: get another sorted max element");
        Map<String, Integer> collect9 = numStr.stream().map(e -> {
            String[] split = e.split("=");
            return NumObj.builder().key(split[0]).value(Integer.parseInt(split[1])).build();
        }).collect(Collectors.groupingBy(NumObj::getKey,(() -> new TreeMap().descendingMap()),Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(NumObj::getValue)), e -> e.get().getValue())));
        collect9.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }

    //收集器 通过传入一个Comparator 接口 来实现一个TreeSet 我们先收集成treemap 然后进行将应用于下游Collector的最终结果
    public static <T> Collector<T, ?, List<T>> toSortedList(Comparator<? super T> c) {
        return Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(c)), ArrayList::new);
    }
}
