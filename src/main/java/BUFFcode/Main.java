package BUFFcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main{

    public static void main(String[] args){
//       Main.testFilter();
       Main.testMap();
    }


    public static void testFilter(){
        List list= Arrays.asList(3,4,2,5,7,3,4);
        list.stream().sorted().filter(e ->
                (Integer)e > 3
        ).filter(e->(Integer)e<6).limit(2).distinct().forEach(System.out::println);
    }

    public static void testMap(){
        List<String> list= Arrays.asList("aaa","bbb","ccc");
       list.stream().map((str)->str.toUpperCase()).forEach(System.out::println);
    }
}