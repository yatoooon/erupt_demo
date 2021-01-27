package com.example.demo.model;

import com.example.demo.dataproxy.EruptRegionDataProxy;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Filter;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.jpa.model.BaseModel;
import xyz.erupt.upms.model.base.HyperModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Erupt(name = "test", dataProxy = EruptRegionDataProxy.class)
@Table(name = "demo_region_link")
@Entity
public class RegionLink extends HyperModel {

    @ManyToOne
    @EruptField(
            views = @View(title = "省份", column = "name"),
            edit = @Edit(title = "省份", type = EditType.REFERENCE_TREE,
                    filter = @Filter("Region.levels = 1"))
    )
    private Region province;

    @ManyToOne
    @EruptField(
            views = @View(title = "市", column = "name"),
            edit = @Edit(title = "市", type = EditType.REFERENCE_TREE,
                    filter = @Filter("Region.levels = 2"),
                    referenceTreeType = @ReferenceTreeType(dependField = "province", dependColumn = "pid.id")
            )
    )
    private Region city;

    @ManyToOne
    @EruptField(
            views = @View(title = "区", column = "name"),
            edit = @Edit(title = "区", type = EditType.REFERENCE_TREE,
                    filter = @Filter("Region.levels = 3"),
                    referenceTreeType = @ReferenceTreeType(dependField = "city", dependColumn = "pid.id")
            )
    )
    private Region area;

    @ManyToOne
    @EruptField(
            views = @View(title = "街道", column = "name"),
            edit = @Edit(title = "街道", type = EditType.REFERENCE_TREE,
                    filter = @Filter("Region.levels = 4"),
                    referenceTreeType = @ReferenceTreeType(dependField = "area", dependColumn = "pid.id")
            )
    )
    private Region street;

    @ManyToOne
    @EruptField(
            views = @View(title = "社区", column = "name"),
            edit = @Edit(title = "社区", type = EditType.REFERENCE_TREE,
                    filter = @Filter("Region.levels = 5"),
                    referenceTreeType = @ReferenceTreeType(dependField = "street", dependColumn = "pid.id")
            )
    )
    private Region community;
}
