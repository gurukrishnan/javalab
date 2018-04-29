package generics;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Guru Krishnan on 4/29/2018.
 */
public class TypeErasureTest {
    @Test
    public void testTypeErasure() {
        TypeErasure te = new TypeErasure();
        Assert.assertTrue(te.erasureCheck(), "Type erasure test failed");
    }
}
