package com.example.demo.model;

import com.example.demo.dataproxy.EruptTestDataProxy;
import com.example.demo.handler.OperationHandlerImpl;
import org.hibernate.annotations.GenericGenerator;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.expr.ExprBool;
import xyz.erupt.annotation.fun.FilterHandler;
import xyz.erupt.annotation.fun.PowerHandler;
import xyz.erupt.annotation.fun.PowerObject;
import xyz.erupt.annotation.sub_erupt.*;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.jpa.model.BaseModel;
import xyz.erupt.upms.handler.ViaMenuCtrl;
import xyz.erupt.upms.model.base.HyperModel;

import javax.persistence.*;
import java.util.Date;

/*
 *  @Erupt注解修饰在类上，@EruptField注解修饰在字段上
 *  其他注解均为Jpa注解
 */
@Erupt(name = "测试用例",              //功能名称
        desc = "Erupt Framework",    //描述
        authVerify = true,          //是否开启权限验证
        orderBy = "id desc", //排序表达式
        //动态控制查询条件
//        filter = @Filter(value = "name",
//                params = {""},
//                conditionHandler = Simple.class),
        //树形结构展示
        tree = @Tree(id = "id", label = "name", pid = "parent.id"),
        //动态控制权限
        power = @Power(add = true,
                delete = true,
                edit = true,
                query = true,
                importable = true,
                export = true,
                powerHandler = Simple.class),
        //数据钻取
        drills = {
                @Drill(code = "drill",
                        title = "数据钻取",
                        //最终生成的表达式为：EruptTest.id = DrillErupt.eruptTest.id
                        link = @Link(linkErupt = DrillErupt.class,  /*关联表*/
                                joinColumn = "simple.id"))  /*关联表达式*/},
        //左树右表
        linkTree = @LinkTree(field = "parent") /*field 的值为类中支持树组件字段*/,
        //自定义按钮
        rowOperation = {
                @RowOperation(
                        title = "单行操作",
                        code = "SINGLE",
                        mode = RowOperation.Mode.SINGLE,
                        operationHandler = OperationHandlerImpl.class),
                @RowOperation(
                        title = "多行操作",
                        code = "MULTI",
                        operationHandler = OperationHandlerImpl.class),
                @RowOperation(
                        title = "按钮操作",
                        code = "BUTTON",
                        operationHandler = OperationHandlerImpl.class,
                        mode = RowOperation.Mode.BUTTON,
                        tip = "不依赖任何数据即可执行"),
                @RowOperation(
                        code = "btn",
                        title = "使用菜单控制按钮权限",
                        operationHandler = OperationHandlerImpl.class,
                        show = @ExprBool(
                                exprHandler = ViaMenuCtrl.class, //通过菜单控制按钮显示隐藏实现类
                                params = "testBtn"  //权限标识
                        )
                )
        },
        //操作行为代理
        dataProxy = {EruptTestDataProxy.class})
@Table(name = "demo_simple")
@Entity
public class Simple extends HyperModel implements PowerHandler, FilterHandler {

    @EruptField(
            sort = 100, //数值越小越靠前
            views = @View(title = "名称" ,desc = "名称描述",type = ViewType.AUTO),
            edit = @Edit(title = "名称")
    )
    private String name;
    //文本输入
    @EruptField(
            sort = 80,
            views = @View(title = "文本"),
            edit = @Edit(title = "文本")
    )
    private String input;

    //数值输入
    @EruptField(
            views = @View(title = "数值"),
            edit = @Edit(title = "数值")
    )
    private Integer number;

    //布尔选择
    @EruptField(
            views = @View(title = "布尔"),
            edit = @Edit(title = "布尔")
    )
    private Boolean bool;

    //时间选择
    @EruptField(
            views = @View(title = "时间"),
            edit = @Edit(title = "时间")
    )
    private Date date;


    //树形结构展示
    @ManyToOne
    @EruptField(
            edit = @Edit(
                    title = "上级树节点",
                    type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(pid = "parent.id")
            )
    )
    private Simple parent;

    //动态控制权限
    @Override
    public void handler(PowerObject power) {
        power.setExport(!power.isExport());
    }

    //动态控制查询条件
    @Override
    public String filter(String condition, String[] params) {
        return condition + " = '" + params[0] + "'";
    }

    @Override
    public String toString() {
        return "Simple{" +
                "name='" + name + '\'' +
                ", input='" + input + '\'' +
                ", number=" + number +
                ", bool=" + bool +
                ", date=" + date +
                ", parent=" + parent +
                '}';
    }
}
