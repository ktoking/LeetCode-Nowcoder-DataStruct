package BUFFcode.WrittenTest.JiBiTe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long A = scanner.nextInt();
        long B = scanner.nextInt();
        long C = scanner.nextInt();
        long N = scanner.nextInt();
        long xa = scanner.nextInt();
        long ya = scanner.nextInt();
        long xb = scanner.nextInt();
        long yb = scanner.nextInt();
        long xc = scanner.nextInt();
        long yc = scanner.nextInt();

        for (long i = 0; i < N; i++) {
            long a=A;
            long b=B;
            long c=C;
           B+=a*xa;
           C+=a*ya;
           A+=b*xb;
           C+=b*yb;
           A+=c*xc;
           B+=c*yc;
           A=A%1000000007;
           B=B%1000000007;
           C=C%1000000007;
        }
        System.out.println(A+" "+B+" "+C);
    }
}
