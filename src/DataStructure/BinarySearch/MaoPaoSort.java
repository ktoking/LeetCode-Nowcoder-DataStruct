package DataStructure.BinarySearch;

public class MaoPaoSort {
    public static void main(String[] args) {
        int arr[]={2,3,1,5,4,3,1,3};
        printf(arr);
        maoPao(arr);
        System.out.println();
        printf(arr);
    }
    public static void maoPao(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr.length-i-1 ; j++) {
                if(arr[j]<arr[j+1]){
                    arr[j+1]=arr[j+1]+arr[j];
                    arr[j]=arr[j+1]-arr[j];
                    arr[j+1]=arr[j+1]-arr[j];
                }
            }
        }
    }
    public static void printf(int[] arr){
        for (int i : arr) {
            System.out.printf("%d ",i);
        }
    }
}
