package DesignPattern.MediatorPattern;

import org.apache.tomcat.jni.Time;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class CenterStation implements Station{

    @Resource
    private List<Train> trainList;

    @Override
    public void doEvent(Train targetTrain) {
        for (Train train : trainList) {
            if(train==targetTrain){
                // 本身自己处理其他事情
                System.out.println("火车发车了!");
                continue;
            }
            // 通知其他火车消息
            train.sendMessage();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 获取中心调度车站
        CenterStation centerStation = (CenterStation) applicationContext.getBean("centerStation");

        // 拿到具体火车
        TrainOne trainOne=(TrainOne) applicationContext.getBean("trainOne");
        TrainTwo trainTwo=(TrainTwo) applicationContext.getBean("trainTwo");
        TrainThree trainThree=(TrainThree) applicationContext.getBean("trainThree");

        // 一号火车发车
        centerStation.doEvent(trainOne);

        System.out.println();

        // 一号火车发车
        centerStation.doEvent(trainTwo);

        System.out.println();

        // 一号火车发车
        centerStation.doEvent(trainThree);
    }
}
