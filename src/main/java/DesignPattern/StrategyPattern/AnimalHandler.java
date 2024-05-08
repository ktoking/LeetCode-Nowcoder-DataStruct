package DesignPattern.StrategyPattern;

import com.baomidou.mybatisplus.extension.api.R;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author kaiyi.wang
 * @ClassName animalHandler.java
 * @Description 策略模式函数式写法
 * @createTime 2024/05/08
 */
public class AnimalHandler {
    private static Map<String,Consumer<Object>> map;
    static {
        map=new HashMap<>();
        map.put("cat",(a)-> System.out.println("miao"));
        map.put("dog",(a)-> System.out.println("wang"));
    }

    public static void main(String[] args) {
        map.get("cat").accept(null);
    }
}
