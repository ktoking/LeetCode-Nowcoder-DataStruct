package DataStructure.LambdaStream;

import com.google.common.collect.Lists;

import java.util.*;


public class MapReduce {

    public static void main(String[] args) {
        List<String> strings = Lists.newArrayList("name=kk", "sex=1", "tel=1111", "email=xx@qq.com");
        Map<String, String> reduce = strings.stream().map(e -> {
            String[] split = e.split("\\=", 2); // 正则划分为单map
            return Collections.singletonMap(split[0], split[1]);
        }).reduce(new HashMap<String, String>(), (accMap, singleMap) -> { // reduce(a,(b,c))-> a 为初始值 b为累加值 c为当前值 操作返回当前值与累加值后的结果 将多个单KV的Map组合成一个Map
            accMap.putAll(singleMap);
            return accMap;
        });

        reduce.forEach((k,v)->{
            System.out.println(k+" = "+v);
        });
    }
}
