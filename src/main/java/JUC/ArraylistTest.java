package JUC;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArraylistTest {


    /**
     * List不能在遍历的时候修改结构,并发修改异常
     * @param args
     */
    public static void main(String[] args) {

       HashMap hashMap=new HashMap();

        List list=new ArrayList();
//        List list=new Vector();
//        List list= Collections.synchronizedList(new ArrayList<>());
//        List list= new CopyOnWriteArrayList();


        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
