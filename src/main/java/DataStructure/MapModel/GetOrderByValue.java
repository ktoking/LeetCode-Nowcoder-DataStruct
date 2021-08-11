package DataStructure.MapModel;

import java.util.*;

public class GetOrderByValue {
    /**
     * map根据value排序
     * @param args
     */
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("aaa",2);
        map.put("bbb",6);
        map.put("ccc",3);
        map.put("ddd",1);
        map.put("eee",2);
        map.put("fff",5);
        List<Map.Entry> list=new ArrayList<>(map.entrySet());
        Collections.sort(list,(o1, o2) -> {return (int)o1.getValue()-(int)o2.getValue();});
        list.forEach(s -> {
            System.out.println(s.getKey()+" :"+s.getValue());
        });
    }


}
