package JUC;

/**
 * 测试ThreadLocal
 */
class Mysou{
    ThreadLocal threadLocal=new ThreadLocal();
    public void getIncr(){
        threadLocal.set(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName()+": "+threadLocal.get());
    }
}
public class ThreadLocalDemo {

    public static void main(String[] args) {
        Mysou mysou=new Mysou();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                mysou.getIncr();
            },""+i).start();
        }
    }
}
