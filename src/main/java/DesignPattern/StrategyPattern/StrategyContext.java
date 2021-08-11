package DesignPattern.StrategyPattern;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Component
public class StrategyContext {

    @Resource
    private List<TypeStrategy> strategies;

    public TypeStrategy getStrategyByType(Integer type){
        Optional<TypeStrategy> strategy = strategies.stream().filter(strategies -> {
            return strategies.getType().equals(type);
        }).findFirst();
        if(!strategy.isPresent()){
            throw new IllegalArgumentException("not find Strategy by type");
        }
        return strategy.get();
    }
}
