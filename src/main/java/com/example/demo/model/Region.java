package com.example.demo.model;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.jpa.model.BaseModel;
import xyz.erupt.annotation.sub_erupt.Tree;
import xyz.erupt.upms.model.base.HyperModel;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "demo_region")
@Erupt(
        name = "树",
        tree = @Tree(pid = "pid.id")
)
public class Region extends HyperModel {

    @EruptField(views = @View(title = "名称"),
            edit = @Edit(title = "名称"))
    private String name;

    @EruptField(views = @View(title = "层级"),
            edit = @Edit(title = "层级"))
    private Integer levels;

    @ManyToOne
    @EruptField(
            edit = @Edit(
                    title = "上级树节点",
                    type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(pid = "pid.id")
            )
    )
    @JoinColumn(name = "pid")
    private Region pid;
}
