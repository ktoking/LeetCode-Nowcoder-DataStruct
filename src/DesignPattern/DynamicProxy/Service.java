package DesignPattern.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理，实现接口
 */
public interface Service {
    public void Say();
}

/**
 * 接口实现类
 */
class ServiceImpl implements Service{

    @Override
    public void Say() {
        System.out.println("Hello world!");
    }
}

/**
 * 织入类，自定义在方法的调用前后要做的事情
 * InvocationHandler实现这个接口里的invoke方法
 */
class WaveInvocation implements InvocationHandler{

    private Object object;

    public WaveInvocation(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置通知");
        Object invoke = method.invoke(object, args);
        System.out.println("后置通知");
        return invoke;
    }
}

/**
 * 首先父类的引用指向子类的对象，创建一个被代理类的实例
 * 创建handler实例传入被代理类对象
 * 实现Proxy.newProxyInstance方法，传入被代理类实例的类加载器，接口，和刚才的handler，生成新的代理类对象，直接调用方法即可
 *
 */
class Main{
    public static void main(String[] args) {
        Service service=new ServiceImpl();
        WaveInvocation handler=new WaveInvocation(service);

        Service servicePro = (Service)Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), handler);
        servicePro.Say();

    }
}
