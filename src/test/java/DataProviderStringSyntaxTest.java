import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by weiro on 2018/1/17.
 */
@RunWith(DataProviderRunner.class)
public class DataProviderStringSyntaxTest {

  @Test
  @DataProvider(value = {
      "               |  0",
      "a              |  1",
      "abc            |  3",
      "veryLongString | 14",
  }, splitBy = "\\|", trimValues = true)
  // @formatter:on
  public void testStringLength2(String str, int expectedLength) {
    // Expect:
    assertEquals(expectedLength, str.length());
  }

  @Test
  @DataProvider({"null", ""})
  public void testIsEmptyString2(String str) {
    // When:
    boolean isEmpty = (str == null) ? true : str.isEmpty();

    // Then:
    assertTrue(isEmpty);
  }
}
