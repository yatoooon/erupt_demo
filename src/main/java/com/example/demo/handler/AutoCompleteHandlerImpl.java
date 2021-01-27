package com.example.demo.handler;

import xyz.erupt.annotation.fun.AutoCompleteHandler;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteHandlerImpl implements AutoCompleteHandler {

    /**
     * @param val   前端输入值
     * @param param 注解回传参数
     */
    @Override
    public List<Object> completeHandler(String val, String[] param) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(val + " -> " + (char) (i + 64));
        }
        return list;
    }

}
