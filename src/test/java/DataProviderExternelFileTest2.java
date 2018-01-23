import com.oocl.dataprovider.ExternalFile;
import com.oocl.dataprovider.LoadFromExternalFile;
import com.oocl.entity.Person;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class DataProviderExternelFileTest2 {
  @Test
  @UseDataProvider(value = "loadFromExternalFile", location = LoadFromExternalFile.class)
  @ExternalFile(format = ExternalFile.Format.JSON, value = "com/oocl/dataprovider/person.json", clazz = Person.class)
  public void should_return_object_when_is_array_is_false(Person person) {
    // Expect:
    Assert.assertEquals(person.getName(), "zhangsan");
    Assert.assertEquals(person.getAge(), 18);
  }
}