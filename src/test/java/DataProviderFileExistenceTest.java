import static org.junit.Assert.assertEquals;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import java.io.File;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by weiro on 2018/1/17.
 */
@RunWith(DataProviderRunner.class)
public class DataProviderFileExistenceTest {

  @DataProvider
  public static String[] dataProviderFileExistence() {
    // @formatter:off
    return new String[]{
        "src,             true",
        "src/main,        true",
        "src/main/java/,  true",
        "src/test/java/,  true",
        "test,            false",
    };
    // @formatter:on
  }

  @Test
  @UseDataProvider("dataProviderFileExistence")
  public void testFileExistence(File file, boolean expected) {
    // Expect:
    assertEquals(expected, file.exists());
  }
}
