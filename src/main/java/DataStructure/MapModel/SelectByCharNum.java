package DataStructure.MapModel;

import java.util.*;

public class SelectByCharNum {
    public static void main(String[] args) {
        String str="aabvsffdsdasfasfas";
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        List<Map.Entry> list=new ArrayList<>(map.entrySet());
        Collections.sort(list,(o1, o2) -> {return (int)o1.getValue()-(int)o2.getValue();});
        list.forEach(entry -> {
            System.out.println(entry.getKey()+" :"+entry.getValue());
        });
    }
}
