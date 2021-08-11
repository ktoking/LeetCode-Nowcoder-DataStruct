package JUC;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUCTest {

    private static JUCTest jucTest=new JUCTest();


    public JUCTest() {
    }

    public static JUCTest getInstance(){
        return jucTest;
    }

    //    /**
//     * 懒汉模式
//     */
//    public JUCTest() {
//    }
//
//    public static JUCTest getInstance(){
//        if(jucTest==null){
//            return new JUCTest();
//        }
//        return jucTest;
//    }
    /**
     * ArrayList 在java.util.ConcurrentModificationException 多线程会报错
     * 1.new Vector()
     * 2.Collections.synchronizedList(new ArrayList<>());
     * 3.new CopyOnWriteArrayList();
     */

    public static void main(String[] args) {

        Set set=Collections.synchronizedSet(new HashSet<>());
        Lock lock=new ReentrantLock();
        lock.lock();
//        List arrayList=Collections.synchronizedList(new ArrayList<>());
//        List arrayList=new CopyOnWriteArrayList();
//        for (int i = 0; i <3 ; i++) {
//            new Thread(()->{
//                arrayList.add(UUID.randomUUID().toString().substring(0,8));
//                System.out.println(arrayList);
//            },"t1").start();
//        }
        Map<String,String> map=new HashMap();
        for (int i = 0; i < 10; i++) {
            map.put(""+i,UUID.randomUUID().toString().substring(0,8));
        }


    }
}
