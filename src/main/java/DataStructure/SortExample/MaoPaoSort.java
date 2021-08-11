package DataStructure.SortExample;

import java.util.Arrays;

public class MaoPaoSort {
    public static void main(String[] args) {
        int[] arr={1,3,6,3,2,2,1,4};
        maopao(arr);
        Arrays.stream(arr).forEach(value -> System.out.println(value));
    }

    public static void maopao(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
