package DesignPattern.TemplatePattern;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author kaiyi.wang
 * @ClassName MealHandler.java
 * @Description 模版模式用函数式接口生成
 * @createTime 2024/05/08
 */
public class MealHandler {

    private void process(Consumer<String> consumer, Supplier<String> supplier) {
        String name = supplier.get();
        getMenu(supplier.get());
        consumer.accept(supplier.get());

        if(name.equals("BBQ")){
            additional();
        }

        payBill(supplier.get());
    };

    private void getMenu(String name) {
        System.out.println("拿到菜单:" + name);
    };

    private void payBill(String name) {
        System.out.println("付钱:" + name);
    };

    private void additional() {
        System.out.println("再加一份!");
    };

    private void eatHotpot() {
        process(a -> System.out.println("吃了:" + a), () -> "火锅");
    }

    private void eatBBQ() {
        process(a -> System.out.println("吃了:" + a), () -> "BBQ");
    }

    public static void main(String[] args) {
        MealHandler mealHandler = new MealHandler();
        mealHandler.eatHotpot();
        System.out.println();
        mealHandler.eatBBQ();
    }
}
