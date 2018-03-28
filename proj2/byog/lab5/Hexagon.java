package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;


public class Hexagon {
    /**
     * Computes the width of row i for a size s hexagon.
     * 0th row is the bottom line
     * @return the width of the ith row
     */
    public static int hexWidth(int row, int size) {
        if(row >= size * 2 ) {
            throw new java.util.NoSuchElementException("the row should now exceed two times of the size");
        }
        if(row - size < 0) {
            return row * 2 + size;
        }
        else if(row == size || row == size - 1) {
            return 3 * size - 2;
        }
        else{
            return (2 * size - 1 - row) * 2 + size;
        }
    }

    public static int findXoffset(int row, int size) {
        return ((3 * size - 2) - hexWidth(row, size)) / 2;
    }


    public void addHexgon(int size) {
        TETile[][] world = new TETile[3*size-2][size*2];
        TERenderer ter = new TERenderer();
        ter.initialize(world.length, world[0].length);

        if(size < 2) {
            throw new java.util.NoSuchElementException("The size can not less than 2");
        }
        for(int i = 0; i <  size * 2; i++) {
            int width = hexWidth(i, size);
            int xOffset = findXoffset(i, size);
            for(int x = 0; x < world.length; x ++) {
                if(x < xOffset || (x >= xOffset + width)) {
                    world[x][i] = Tileset.NOTHING;
                }else{
                    world[x][i] = Tileset.a;
                }

            }
        }
        ter.renderFrame(world);
    }

    public static void main(String[] args) {
        Hexagon test = new Hexagon();
        test.addHexgon(2)g;
    }
}
