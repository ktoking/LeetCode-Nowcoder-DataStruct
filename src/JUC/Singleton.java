package JUC;

import java.util.ArrayList;
import java.util.List;

public class Singleton {

    private Singleton() {
    }
    private static volatile  Singleton singleton;
    public static Singleton getSingleton(){
        if (singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


    public static void main(String[] args) {
        List list=new ArrayList<>();
        for (int i = 0; i <10; i++) {
            Singleton singleton=Singleton.getSingleton();
            list.add(singleton);
        }

        System.out.println(list.get(1).equals(list.get(2)));
    }
}
