package com.example.demo.dataproxy;

import com.example.demo.model.Region;
import com.example.demo.model.RegionLink;
import org.apache.poi.ss.usermodel.Workbook;
import xyz.erupt.annotation.fun.DataProxy;

import java.util.Collection;
import java.util.Map;

public class EruptRegionDataProxy implements DataProxy<RegionLink> {
    @Override
    public void beforeAdd(RegionLink regionLink) {

    }

    @Override
    public void afterAdd(RegionLink regionLink) {

    }

    @Override
    public void beforeUpdate(RegionLink regionLink) {

    }

    @Override
    public void afterUpdate(RegionLink regionLink) {

    }

    @Override
    public void beforeDelete(RegionLink regionLink) {

    }

    @Override
    public void afterDelete(RegionLink regionLink) {

    }

    @Override
    public String beforeFetch() {
        return null;
    }

    @Override
    public void afterFetch(Collection<Map<String, Object>> list) {

    }

    @Override
    public void addBehavior(RegionLink regionLink) {

    }

    @Override
    public void editBehavior(RegionLink regionLink) {

    }

    @Override
    public void excelExport(Workbook wb) {

    }

    @Override
    public void excelImport(RegionLink regionLink) {

    }
}
