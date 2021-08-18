package DesignPattern.TemplatePattern;

public abstract class AbstractMeal {

    public final String getMenu(){
        return "拿到菜单";
    }

    protected abstract void eat();

    protected abstract void payTheBill();

    public void process(){
        String menu = getMenu();
        System.out.println(menu);
        eat();
        payTheBill();
    }

    public static void main(String[] args) {
        AbstractMeal hotpot=new HotPot();
        AbstractMeal barbecue = new Barbecue();

        hotpot.process();
        System.out.println();

        barbecue.process();
    }
}
