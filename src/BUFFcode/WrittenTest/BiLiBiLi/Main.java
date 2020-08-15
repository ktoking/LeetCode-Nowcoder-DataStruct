package BUFFcode.WrittenTest.BiLiBiLi;

import java.util.Random;

/**
 * [7,2,1,10]
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     *
     * @param arr int整型一维数组
     * @return bool布尔型
     * 71
     */
    public boolean Game24Points (int[] arr) {
        // write code here
//        return new Random().nextBoolean();
        int left[]=new int[12];
        int right[]=new int[12];

        left[0]=arr[0]+arr[1];
        left[1]=arr[0]+arr[2];
        left[2]=arr[0]+arr[3];
        left[3]=arr[0]-arr[1];
        left[4]=arr[0]-arr[2];
        left[5]=arr[0]-arr[3];
        left[6]=arr[0]*arr[1];
        left[7]=arr[0]*arr[2];
        left[8]=arr[0]*arr[3];
        left[9]=arr[0]/arr[1];
        left[10]=arr[0]/arr[2];
        left[11]=arr[0]/arr[3];

        right[0]=arr[2]+arr[3];
        right[1]=arr[1]+arr[3];
        right[2]=arr[1]+arr[2];
        right[3]=arr[2]-arr[3];
        right[4]=arr[1]-arr[3];
        right[5]=arr[1]-arr[2];
        right[6]=arr[2]*arr[3];
        right[7]=arr[1]*arr[3];
        right[8]=arr[1]*arr[2];
        right[9]=arr[2]/arr[3];
        right[10]=arr[1]/arr[3];
        right[11]=arr[1]/arr[2];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(left[i]+right[j]==24|| left[i]-right[j]==24||left[i]*right[j]==24||left[i]/right[j]==24) return true;
            }
        }
        return false;
    }

}
