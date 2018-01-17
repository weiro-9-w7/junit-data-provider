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
        /*String testDataFile = testMethod.getAnnotation(ExternalFile.class).value();
        // Load the data from the external file here ...
        return new Object[][] { { testDataFile } };*/
        String testDataFile = testMethod.getAnnotation(ExternalFile.class).value();
        File file = new File(LoadFromExternalFile.class.getResource("/").getPath() + testDataFile);
        String content = FileUtils.readFileToString(file, "utf8");
        List<Person> persons = JSON.parseArray(content, Person.class);
        return new Object[][]{{persons}};
    }
}
