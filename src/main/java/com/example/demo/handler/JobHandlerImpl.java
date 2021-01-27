package com.example.demo.handler;

import org.springframework.stereotype.Service;
import xyz.erupt.job.handler.EruptJobHandler;

@Service
public class JobHandlerImpl implements EruptJobHandler {

    /**
     * @param code 任务编码
     * @param param 任务参数
     */
    @Override
    public String exec(String code, String param) throws Exception {
        System.out.println("hello erupt");
        return "110";
    }

}

