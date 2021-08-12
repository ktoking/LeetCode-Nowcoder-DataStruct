package DesignPattern.CommandPattern;

import org.springframework.stereotype.Component;


// 具体测试规则
@Component("validatePluginOne")
public class ValidatePluginOne extends  ValidatePlugin{
    @Override
    public void validate() {
        System.out.println("validatePluginOne 规则校验");
    }
}
