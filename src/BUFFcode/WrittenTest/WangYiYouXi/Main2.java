package BUFFcode.WrittenTest.WangYiYouXi;

public class Main2 {
    /**
     * 找出数组中只重复一次的数字
     * @param args
     */
    public static void main(String[] args) {
        int[] arr=new int[]{2,2,3,3,4,5,6,6,5};
        int rt=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            rt^=arr[i];
        }
        System.out.println(rt);
    }
}
