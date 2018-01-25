import com.oocl.dataprovider.ExternalFile;
import com.oocl.dataprovider.ExternalFileLoader;
import com.oocl.entity.Person;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by weiro on 2018/1/17.
 */
@RunWith(DataProviderRunner.class)
public class DataProviderExternelFileMixTest {

    @Test
    @UseDataProvider(value = "loadFromExternalFile", location = ExternalFileLoader.class)
    @ExternalFile(format = ExternalFile.Format.JSON, value = "com/oocl/dataprovider/persons.json", clazz=Person.class, isArray=true)
    public void should_return_array_when_is_array_is_true(List<Person> person) {
        // Expect:
        assertEquals(person.get(0).getName(), "zhangsan");
        assertEquals(person.get(0).getAge(), 18);
    }

    @Test
    @UseDataProvider(value = "loadFromExternalFile", location = ExternalFileLoader.class)
    @ExternalFile(format = ExternalFile.Format.JSON, value = "com/oocl/dataprovider/person.json", clazz = Person.class)
    public void should_return_object_when_is_array_is_false(Person person) {
        // Expect:
        Assert.assertEquals(person.getName(), "zhangsan");
        Assert.assertEquals(person.getAge(), 18);
    }

}
