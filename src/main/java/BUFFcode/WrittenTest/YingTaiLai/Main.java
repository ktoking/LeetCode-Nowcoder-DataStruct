package BUFFcode.WrittenTest.YingTaiLai;

import java.util.*;

public class Main {
   static List<List<Character>> lists=new ArrayList();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        for (int i = 0; i < M; i++) {
            sb.append("b");
        }
        get(sb.toString().toCharArray(),0,new ArrayList<>(),K);
        List<Character> characters = lists.get(lists.size() - 1);
        StringBuilder sb1=new StringBuilder();
        for (Character character : characters) {
            sb1.append(character);
        }
        System.out.println(sb1.toString());
    }

    public  static void get (char[] chars, int index, List<Character> list,int k){
        if(lists.size()==k+1) return;
        lists.add(new ArrayList<>(list));
        Set<Character> set=new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            set.add(chars[i]);
            list.add(chars[i]);
            get(chars,i+1,list,k);
            list.remove(list.size()-1);
        }
    }
}
