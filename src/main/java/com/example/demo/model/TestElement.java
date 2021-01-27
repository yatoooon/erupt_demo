package com.example.demo.model;

import com.example.demo.handler.AutoCompleteHandlerImpl;
import com.example.demo.handler.FetchHandlerImpl;
import com.example.demo.handler.TagsFetchHandlerImpl;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;
import xyz.erupt.upms.handler.DictChoiceFetchHandler;
import xyz.erupt.upms.handler.SqlChoiceFetchHandler;
import xyz.erupt.upms.model.base.HyperModel;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static xyz.erupt.annotation.sub_field.sub_edit.HtmlEditorType.Type.CKEDITOR;
import static xyz.erupt.annotation.sub_field.sub_edit.HtmlEditorType.Type.UEDITOR;

@Erupt(name = "测试组件")
@Table(name = "demo_element")
@Entity
public class TestElement extends HyperModel {
    //Auto自动推测
    @EruptField(
            views = @View(title = "文本输入"),
            edit = @Edit(title = "文本输入") //相当于 type = EditType.INPUT
    )
    private String input;
    @EruptField(
            views = @View(title = "布尔选择"),
            edit = @Edit(title = "布尔选择") //相当于 type = EditType.BOOLEAN
    )
    private Boolean bool;
    //INPUT 输入框
    @EruptField(
            views = @View(title = "密码输入"),
            edit = @Edit(title = "密码输入", inputType = @InputType(type = "password"))
    )
    private String password;
    //NUMBER 数字输入框
    @EruptField(
            views = @View(title = "数字输入"),
            edit = @Edit(title = "数字输入", numberType = @NumberType)
    )
    private Integer number;
    //SLIDER 数字滑块
    @EruptField(
            views = @View(title = "数字滑块"),
            edit = @Edit(title = "数字滑块",
                    type = EditType.SLIDER,
                    sliderType = @SliderType(max = 100))
    )
    private Integer slider;
    //时间日期
    @EruptField(
            views = @View(title = "时间日期"),
            edit = @Edit(title = "时间日期", type = EditType.DATE, dateType = @DateType(type = DateType.Type.DATE_TIME))
    )
    private Date dateTime;
    //布尔选择器
    @EruptField(
            views = @View(title = "任务状态"),
            edit = @Edit(title = "任务状态",
                    boolType = @BoolType(trueText = "成功", falseText = "失败"))
    )
    private Boolean status;
    //choice选择器
    @EruptField(
            views = @View(title = "选择器"),
            edit = @Edit(title = "选择器",
                    type = EditType.CHOICE,
                    choiceType = @ChoiceType(
                            fetchHandler = FetchHandlerImpl.class,
                            fetchHandlerParams = {"α", "β", "γ"} //该值可被FetchHandlerImpl → fetch方法params参数获取到

                    ))
    )
    private String choice;
    @EruptField(
            edit = @Edit(
                    search = @Search,
                    title = "通过SQL获取下拉列表",
                    type = EditType.CHOICE,
                    choiceType = @ChoiceType(
                            fetchHandler = SqlChoiceFetchHandler.class,
                            fetchHandlerParams = "select id,name from e_upms_menu"
                    ))
    )
    private String choice_sql;
    @EruptField(
            views = @View(title = "字典项"),
            edit = @Edit(
                    title = "字典项",
                    type = EditType.CHOICE,
                    choiceType = @ChoiceType(
                            fetchHandler = DictChoiceFetchHandler.class,
                            fetchHandlerParams = "001"
                    ))
    )
    private Long dict;
    //TAGS 标签选择器
    @EruptField(
            views = @View(title = "标签选择器"),
            edit = @Edit(title = "选择器",
                    type = EditType.TAGS,
                    tagsType = @TagsType(
                            fetchHandlerParams = {"α", "β", "γ"},
                            fetchHandler = TagsFetchHandlerImpl.class
                    ))
    )
    private String tags;
    //输入框自动完成
    @EruptField(
            views = @View(title = "自动完成"),
            edit = @Edit(title = "自动完成",
                    type = EditType.AUTO_COMPLETE,
                    autoCompleteType = @AutoCompleteType(handler = AutoCompleteHandlerImpl.class))
    )
    private String autoComplete;
    //多行文本框
    @Lob
    @EruptField(
            views = @View(title = "多行文本框"),
            edit = @Edit(title = "多行文本框", type = EditType.TEXTAREA)
    )
    private String textarea;
    //富文本
    @Lob  //富文本编辑器所产生的文本量较大，所以设置为长字符串类型在数据库中存储
    @EruptField(
            views = @View(title = "富文本"),
            edit = @Edit(title = "内容(UEditor)",
                    type = EditType.HTML_EDITOR,
                    htmlEditorType = @HtmlEditorType(UEDITOR)))
    private String content;
    //分割线
    @Transient //由于该字段不需要持久化，所以使用该注解修饰
    @EruptField(
            edit = @Edit(title = "分割线", type = EditType.DIVIDE)
    )
    private String divide;
    //代码编辑器
    @Lob
    @EruptField(
            views = @View(title = "代码编辑器"),
            edit = @Edit(title = "代码编辑器",
                    type = EditType.CODE_EDITOR,
                    codeEditType = @CodeEditorType(language = "java"))
    )
    private String code;
    //文件上传
    @EruptField(
            views = @View(title = "文件上传"),
            edit = @Edit(title = "文件上传", type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType)
    )
    private String attachment;
    //地图选择
    @EruptField(
            views = @View(title = "地图"),
            edit = @Edit(title = "地图", type = EditType.MAP)
    )
    private String map;
    //隐藏组件
    @EruptField(
            edit = @Edit(
                    title = "隐藏",
                    type = EditType.HIDDEN,
                    inputType = @InputType(type = "text")
            )
    )
    private String hide_input;
    //空组件
    @EruptField(
            edit = @Edit(
                    title = "空",
                    type = EditType.EMPTY,
                    inputType = @InputType(type = "text")
            )
    )
    private String empty_input;


    /*------------------------------复杂组件------------------------------------------------*/

    //表格引用
    @ManyToOne //多对一
    @EruptField(
            views = @View(title = "多对一表格", column = "name"),
            edit = @Edit(title = "多对一表格", type = EditType.REFERENCE_TABLE,
                    referenceTableType = @ReferenceTableType(id = "id", label = "name")
            )
    )
    private TestTable testTable; //Table对象定义如下👇
    //多选树
    @ManyToMany  //多对多
    @JoinTable(
            name = "e_table_tree", //中间表表名，如下为中间表的定义，详见hibernate ManyToMany
            joinColumns = @JoinColumn(name = "table_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tree_id", referencedColumnName = "id"))
    @EruptField(
            edit = @Edit(
                    title = "多选树",
                    type = EditType.TAB_TREE
            )
    )
    private Set<TestTree> treeSet;
    //复选框
    @ManyToMany  //多对多
    @JoinTable(
            name = "e_table_tag", //中间表表名，如下为中间表的定义，详见hibernate ManyToMany
            joinColumns = @JoinColumn(name = "table_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    @EruptField(
            edit = @Edit(
                    title = "复选框",
                    type = EditType.CHECKBOX,
                    checkboxType = @CheckboxType
            )
    )
    private Set<TestTag> tagSet; //Tag对象定义如下
    //多选表格
    @ManyToMany //多对多
    @JoinTable(name = "e_this_table", //定义多对多中间表
            joinColumns = @JoinColumn(name = "this_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "table_id", referencedColumnName = "id"))
    @EruptField(
            edit = @Edit(
                    title = "多对多，关联多条数据",
                    type = EditType.TAB_TABLE_REFER,
                    referenceTableType = @ReferenceTableType(label = "name")
            )
    )
    private Set<TestTable> tables; //Table对象定义如下
    //一对多新增
    @OneToMany(cascade = CascadeType.ALL) //一对多，且开启级联
    @JoinColumn(name = "this_id")
    @OrderBy //排序
    @EruptField(
            edit = @Edit(title = "添加多条表格数据", type = EditType.TAB_TABLE_ADD)
    )
    private Set<TestTable> tableSet; //Table对象定义如下👇

}
