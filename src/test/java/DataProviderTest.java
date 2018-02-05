import static org.junit.Assert.assertEquals;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class DataProviderTest {

  @DataProvider
  public static Object[][] dataProviderAdd() {
    // @formatter:off
    return new Object[][]{{0, 0, 0}, {1, 1, 2},
    /* ... */
    };
    // @formatter:on
  }

  @Test
  @UseDataProvider("dataProviderAdd")
  public void testAdd(int a, int b, int expected) {
    // Given:

    // When:
    int result =
        a + b + a + b + a + b + a + b + a + b + a + b + a + b + a + b + a + b + a + b + a + b + a
            + b + a + b + a + b + a + b + a + b + a + b + a + b + a + b;

    // Then:
    assertEquals(expected, result);
  }
}
