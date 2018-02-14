import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    @Test
    public void TestFlik() {
        int a = 10000;
        int b = 10000;
        assertTrue(Flik.isSameNumber(a, b));
    }
}
