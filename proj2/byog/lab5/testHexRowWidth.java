package byog.lab5;

import org.junit.*;


public class testHexRowWidth {
    @Test
    public void testHexRowWidth() {
        Assert.assertEquals(3, Hexagon.hexWidth(5, 3));
        Assert.assertEquals(5, Hexagon.hexWidth(4, 3));
        Assert.assertEquals(7, Hexagon.hexWidth(3, 3));
        Assert.assertEquals(7, Hexagon.hexWidth(2, 3));
        Assert.assertEquals(5, Hexagon.hexWidth(1, 3));
        Assert.assertEquals(3, Hexagon.hexWidth(0, 3));
        Assert.assertEquals(2, Hexagon.hexWidth(0, 2));
        Assert.assertEquals(4, Hexagon.hexWidth(1, 2));
        Assert.assertEquals(4, Hexagon.hexWidth(2, 2));
        Assert.assertEquals(2, Hexagon.hexWidth(3, 2));
    }

}
