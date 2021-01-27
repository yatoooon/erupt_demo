package com.example.demo.handler;

import org.springframework.stereotype.Component;
import xyz.erupt.annotation.fun.ChoiceFetchHandler;
import xyz.erupt.annotation.fun.VLModel;

import java.util.ArrayList;
import java.util.List;

@Component  //如果你想使用依赖注入相关功能，直接加入 @Service, @Component 等相关注解即可
public class FetchHandlerImpl implements ChoiceFetchHandler {

    @Override
    public List<VLModel> fetch(String[] params) {
        List<VLModel> list = new ArrayList<>();
        for (String param : params) {
            list.add(new VLModel(param, param));
        }
        list.add(new VLModel("a", "A"));
        list.add(new VLModel("b", "B"));
        list.add(new VLModel("c", "C"));
        list.add(new VLModel("d", "D"));
        return list;
    }

}

