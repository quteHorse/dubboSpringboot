package org.apache.dubbo.springboot.demo.provider;



import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.springboot.demo.DemoService;

/**
 * @author nantian
 * @date 2023-02-22 14:52
 */
@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "hello,"+name;
    }
}
