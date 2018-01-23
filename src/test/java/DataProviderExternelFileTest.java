import com.oocl.dataprovider.ExternalFile;
import com.oocl.dataprovider.LoadFromExternalFile;
import com.oocl.entity.Person;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by weiro on 2018/1/17.
 */
@RunWith(DataProviderRunner.class)
public class DataProviderExternelFileTest {

    @Test
    @UseDataProvider(value = "loadFromExternalFile", location = LoadFromExternalFile.class)
    @ExternalFile(format = ExternalFile.Format.JSON, value = "com/oocl/dataprovider/persons.json", clazz=Person.class, isArray=true)
    public void should_return_array_when_is_array_is_true(List<Person> person) {
        // Expect:
        assertEquals(person.get(0).getName(), "zhangsan");
        assertEquals(person.get(0).getAge(), 18);
    }


}
