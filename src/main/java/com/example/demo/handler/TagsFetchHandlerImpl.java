package com.example.demo.handler;

import xyz.erupt.annotation.fun.TagsFetchHandler;

import java.util.ArrayList;
import java.util.List;

public class TagsFetchHandlerImpl implements TagsFetchHandler {

    /**
     * @param param 注解回传参数
     */
    @Override
    public List<String> fetchTags(String[] params) {
        List<String> list = new ArrayList<>();
        for (String param : params) {
            list.add(param);
        }
        list.add("A");
        list.add("B");
        list.add("C");
        return list;
    }

}
