package com.oocl.dataprovider;

import com.alibaba.fastjson.JSON;
import com.tngtech.java.junit.dataprovider.DataProvider;
import org.apache.commons.io.FileUtils;
import org.junit.runners.model.FrameworkMethod;

import java.io.File;
import java.io.IOException;

/**
 * Created by weiro on 2018/1/17.
 */
public class ExternalFileLoader {

    @DataProvider
    public static Object[][] loadFromExternalFile(FrameworkMethod testMethod) throws IOException {
        ExternalFile externalFile = testMethod.getAnnotation(ExternalFile.class);
        String testDataFile = externalFile.value();
        File file = new File(ExternalFileLoader.class.getResource("/").getPath() + testDataFile);
        String content = FileUtils.readFileToString(file, "utf8");
        if(externalFile.isArray()){
            return new Object[][]{{JSON.parseArray(content, externalFile.clazz())}};
        }else{
            return new Object[][]{{JSON.parseObject(content, externalFile.clazz())}};
        }
    }
}
