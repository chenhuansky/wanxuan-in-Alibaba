package com.example.demo;

import java.util.List;

import javax.annotation.PostConstruct;

import com.example.demo.service.ExampleOneService;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yewanxuan
 */
@SpringBootApplication
public class Application1 implements CommandLineRunner {

    {
        System.out.println("Application1:            Static Part start");
    }


    public Application1 () {
        System.out.println("Application1:           construct new");
    }
    @Autowired
    @Qualifier("exampleOneService")
    private MessageService messageService;

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private List<MessageService> messageServiceList;

    private MessageService selfPrivate;

    @Override
    public void run(String... strings) {
        System.out.println("messageService:         " + messageService.getMessage());
        System.out.println("messageServiceList:     " + messageServiceList.toString());
        System.out.println("selfPrivate:            " + selfPrivate.toString());
        MessageService messageService = appContext.getAutowireCapableBeanFactory().getBean(ExampleOneService.class);
        Class classs = MessageService.class;

        System.out.println(messageService.getMessage());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application1.class, args);
        System.out.println("=========================================");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        MessageService messageService = (MessageService)applicationContext.getAutowireCapableBeanFactory().getBean("exampleThreeAgainService");
        System.out.println(messageService.getMessage());
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        selfPrivate = (MessageService)appContext.getAutowireCapableBeanFactory().getBean("exampleOneService");
    }
}
