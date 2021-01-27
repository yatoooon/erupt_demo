package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.erupt.core.annotation.EruptRecordOperate;
import xyz.erupt.core.annotation.EruptRouter;
import xyz.erupt.core.constant.EruptRestPath;

@RestController
@RequestMapping(EruptRestPath.ERUPT_API + "/test") //必须为 EruptRestPath.ERUPT_API 权限校验才会生效
public class TestController {

    @RequestMapping("/abc")
    @EruptRecordOperate(desc = "登录可调用") //记录操作日志，可不定义
    @EruptRouter(verifyType = EruptRouter.VerifyType.LOGIN, authIndex = 0) //配置接口登录后可用
    public void test(String param) {
        //TODO
    }

    @RequestMapping("/def")
    //请求用户，必须有类型值为：def 的菜单的权限才可调用该接口
    // authIndex 表示请求地址中第几位作为菜单校验的依据，位数通过 '/' 拆分
    @EruptRouter(verifyType = EruptRouter.VerifyType.MENU, authIndex = 1) //配置接口有菜单权限可用
    public void test2(String param) {
        //TODO
    }


    @RequestMapping("/xyz") //普通接口
    public void test3(String param) {
        //TODO
    }

}

