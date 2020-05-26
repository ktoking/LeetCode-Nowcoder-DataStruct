package JUC;

class Tickets{
     private int ticketsnum;

    public Tickets(int ticketsnum) {
        this.ticketsnum = ticketsnum;
    }

    public  void sell(){
        System.out.println(Thread.currentThread().getName()+"当前线程卖出去票还剩: "+--ticketsnum);
    }


}
public class SellTickets {

    public static void main(String[] args) {
        Tickets tickets=new Tickets(40);

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                tickets.sell();
            }

        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                tickets.sell();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                tickets.sell();
            }
        },"C").start();

    }



}

