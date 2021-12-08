package DesignPattern.StrategyPattern;

import DesignPattern.CommandPattern.TestValidatePlugin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Component
public class Factory {
    @Resource
    private List<AbstractAnmal> abstractAnmals;

    public AbstractAnmal getStrategyByType(Integer type){
        Optional<AbstractAnmal> strategy = abstractAnmals.stream().filter(strategies -> {
            return strategies.getType().equals(type);
        }).findFirst();
        if(!strategy.isPresent()){
            throw new IllegalArgumentException("not find Strategy by type");
        }
        return strategy.get();
    }

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Factory factory = (Factory) applicationContext.getBean("factory");

        AbstractAnmal strategyByType = factory.getStrategyByType(2);
        strategyByType.say();

    }
}
