package BUFFcode.WrittenTest.YueWenTest;

import java.util.*;

public class StrDemo {

    public static char find(String str){
        Map<Character,Integer> map=new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else {
                map.put(str.charAt(i),0);
            }
        }
        int count=0;
        Character c=null;
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==0){
                count++;
                c=entry.getKey();
                break;
            }
        }

        if(count==0) throw new RuntimeException();
        else {
            return c;
        }
    }

    /**
     * 这个方法比较巧妙,使用了String的indexOf lastIndexOf方法,首先判断第一步字符串肯定包含了26个字母,那我们就判断它是否在这26个字母当中
     * for循环a-z字母 记录当前第一个出现的字母的下标,和最后一次出现字母的下标,判断两个下标是否相同,相同则出现了一次(不为-1),拿到这个下标与上一次记录的值比较
     * 选出最小的下标记录给result 若没查到则抛出异常
     * @param s
     * @return
     */
    public static char find2(String s){
        int start;
        int end;
        int result = s.length();
        for(char ch='a';ch<='z';ch++) {
            start = s.indexOf(ch);
            end = s.lastIndexOf(ch);
            if(start == end && start != -1) {
                result = Math.min(result,start);
            }
        }
        if(result == s.length()) {
            throw new RuntimeException();
        }
        return s.charAt(result);

    }

    public static void main(String[] args) {
         char hellohehe = StrDemo.find2("hellldasohehe");
        System.out.println(hellohehe);
    }
}
