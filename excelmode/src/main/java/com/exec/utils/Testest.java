package com.exec.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Testest {
    @Test
    public void test1() {
        //类不确定 随便怎么传都行
        //List<District> districts = districtService.queryByParentCodes(Arrays.asList("110100"));
        //存放地址&文件名
        District d = new District();
        d.setName("刘坤雨");
        d.setCode("200");
        d.setFullName("午夜鬼");
        d.setParentCode("18530291380");
        List<District> list = new ArrayList<>();
        list.add(d);
        String fileName = "D:\\ceshi\\" + MyCsvFileUtil.buildCsvFileFileName(list);
        //创建表格行标题
        String tableNames = MyCsvFileUtil.buildCsvFileTableNames(list);
        //创建文件
        MyCsvFileUtil.writeFile(fileName, tableNames);
        //写入数据
        String contentBody = MyCsvFileUtil.buildCsvFileBodyMap(list);
        //调用方法生成
        MyCsvFileUtil.writeFile(fileName, contentBody);
    }
}