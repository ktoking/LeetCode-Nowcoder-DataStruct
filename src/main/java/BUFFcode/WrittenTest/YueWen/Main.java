package BUFFcode.WrittenTest.YueWen;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nextInt = Integer.parseInt(scanner.nextLine());
        String[] str=new String[nextInt];
        for (int i = 0; i < nextInt; i++) {
            String s = scanner.nextLine();
            str[i]=s;
        }
        Arrays.sort(str,((o1, o2) -> {
            return  Integer.parseInt(o1.substring(o1.lastIndexOf(',')+1,o1.length()))-
                    Integer.parseInt(o2.substring(o2.lastIndexOf(',')+1,o2.length()));
        }));
        Arrays.stream(str).forEach(e->{
            System.out.println(e);
        });
    }
}
