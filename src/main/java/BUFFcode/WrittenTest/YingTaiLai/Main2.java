package BUFFcode.WrittenTest.YingTaiLai;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> lists=new LinkedList<>();
        lists.add(1);
        int size=0;
        for (int i = 1; i < 15; i++) {
            size=lists.size();
            for (int j = 0; j < size; j++) {
                lists.set(j,lists.get(j)+1);
                if(lists.get(j)>=5){

                }else if(lists.get(j)==2||lists.get(j)==4){
                    lists.add(1);
                }
            }
        }
        int count=0;
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i)<=4) count++;
        }
        System.out.println(count);
    }
}
