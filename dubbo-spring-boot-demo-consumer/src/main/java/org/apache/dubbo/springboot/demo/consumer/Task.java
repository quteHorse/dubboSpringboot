package org.apache.dubbo.springboot.demo.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.springboot.demo.DemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author nantian
 * @date 2023-02-22 15:46
 */
@Component
public class Task implements CommandLineRunner {
    @DubboReference
    public DemoService demoService;
    @Override
    public void run(String... args) throws Exception {
           String result = demoService.sayHello("world");
           System.out.println("Receive result ======>"+result);
           new Thread(()->{
               while(true){
                   try {
                       Thread.sleep(1000);
                       System.out.println(new Date()+"Receive result ===>"+demoService.sayHello("world"));
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                       Thread.currentThread().interrupt();
                   }
               }
           }).start();
    }
}
