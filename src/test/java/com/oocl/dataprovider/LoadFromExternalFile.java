package com.oocl.dataprovider;

import com.alibaba.fastjson.JSON;
import com.oocl.entity.Person;
import com.tngtech.java.junit.dataprovider.DataProvider;
import org.apache.commons.io.FileUtils;
import org.junit.runners.model.FrameworkMethod;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by weiro on 2018/1/17.
 */
public class LoadFromExternalFile {

    @DataProvider
    public static Object[][] loadFromExternalFile(FrameworkMethod testMethod) throws IOException {
        ExternalFile externalFile = testMethod.getAnnotation(ExternalFile.class);
        String testDataFile = externalFile.value();
        File file = new File(LoadFromExternalFile.class.getResource("/").getPath() + testDataFile);
        String content = FileUtils.readFileToString(file, "utf8");
        if(externalFile.isArray()){
            return new Object[][]{{JSON.parseArray(content, externalFile.clazz())}};
        }else{
            return new Object[][]{{JSON.parseObject(content, externalFile.clazz())}};
        }
    }
}
