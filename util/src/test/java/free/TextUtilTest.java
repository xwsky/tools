package free;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Date 2017/10/11 16:51
 * Description:
 */
public class TextUtilTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TextUtil() throws Exception{
        TxtUtil textUtil = new TxtUtil();
        Assert.assertNotNull(textUtil);
    }

    @Test
    public void isEmpty() {

        final List<String> myMockList1 = mock(List.class);

        when(myMockList1.get(0)).thenReturn("Hello, I am James");

        System.out.println("myMockList1.get(0) = " + myMockList1.get(0));
        System.out.println("myMockList1.get(2) = " + myMockList1.get(2));
        Boolean b = TxtUtil.isEmpty("");
        Assert.assertTrue(b);
        b = TxtUtil.isEmpty("   ");
        Assert.assertTrue(b);
        b = TxtUtil.isEmpty(null);
        Assert.assertTrue(b);
        b = TxtUtil.isEmpty("null");
        Assert.assertFalse(b);
    }

    @Test
    public void isNotEmpty() {
        Boolean b = TxtUtil.isNotEmpty("");
        Assert.assertFalse(b);
        b = TxtUtil.isNotEmpty("   ");
        Assert.assertFalse(b);
        b = TxtUtil.isNotEmpty(null);
        Assert.assertFalse(b);
        b = TxtUtil.isNotEmpty("null");
        Assert.assertTrue(b);
    }

    @Test
    public void getExceptionDetails() {
        String ex = TxtUtil.getExceptionDetails(new Exception());
        System.out.println("daying  ======"+ex);
        Assert.assertNotNull(ex);
    }

}