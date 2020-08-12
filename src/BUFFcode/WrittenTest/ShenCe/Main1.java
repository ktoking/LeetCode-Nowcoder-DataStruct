package BUFFcode.WrittenTest.ShenCe;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        List<Integer> remove=new ArrayList<>();
        int n = scanner.nextInt();
        while (scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        for (int j = 0 ,i=0; i < n; i++) {
            remove.add(list.remove(j));
        }
        Collections.reverse(remove);
        list.addAll(remove);
        for (Integer integer : list) {
            System.out.printf("%d ",integer);
        }
    }


}
