package BUFFcode.WrittenTest.BeiKe;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int nextInt = scanner.nextInt();
        List<Integer> list=new ArrayList();
        for (int i = 0; i < nextInt; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
           if(N==1||M==1){
               list.add(get(N*M));
           }else {
               list.add(N*M%2==0?2:get(Math.max(N,M)-1
               ));
           }
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
            }
            public static int get(int num){
                for (int i = 2; i < num; i++) {
                    if(num%i==0){
                return i;
            }
        }
        return num;
    }

}
