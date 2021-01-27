package com.example.demo.dataproxy;

import com.example.demo.model.Simple;
import org.apache.poi.ss.usermodel.Workbook;
import xyz.erupt.annotation.fun.DataProxy;

import java.util.Collection;
import java.util.Map;

public class EruptTestDataProxy implements DataProxy<Simple> {
    @Override
    public void beforeAdd(Simple simple) {

    }

    @Override
    public void afterAdd(Simple simple) {
        System.out.println(simple);
    }

    @Override
    public void beforeUpdate(Simple simple) {

    }

    @Override
    public void afterUpdate(Simple simple) {

    }

    @Override
    public void beforeDelete(Simple simple) {

    }

    @Override
    public void afterDelete(Simple simple) {

    }

    @Override
    public String beforeFetch() {
        return null;
    }

    @Override
    public void afterFetch(Collection<Map<String, Object>> list) {

    }

    @Override
    public void addBehavior(Simple simple) {

    }

    @Override
    public void editBehavior(Simple simple) {

    }

    @Override
    public void excelExport(Workbook wb) {

    }

    @Override
    public void excelImport(Simple simple) {

    }
}

