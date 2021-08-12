package DesignPattern.CommandPattern;

import com.google.common.collect.Lists;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

// 具体执行器，把需要执行的规则添加到 validatePlugins 中
@Component("testValidatePlugin")
public class TestValidatePlugin extends ValidatePluginExecute implements ApplicationContextAware, InitializingBean {

    protected ApplicationContext applicationContext;

    private List<ValidatePlugin> validatePlugins;

    @Override
    public void afterPropertiesSet() {
        // 添加规则
        validatePlugins = Lists.newArrayList();
        validatePlugins.add((ValidatePlugin) this.applicationContext.getBean("validatePluginOne"));

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    protected List<ValidatePlugin> getValidatePlugins() {
        return this.validatePlugins;
    }

    // 测试demo
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestValidatePlugin testValidatePlugin = (TestValidatePlugin) applicationContext.getBean("testValidatePlugin");
        testValidatePlugin.execute();
    }
}
