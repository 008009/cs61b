package byog.Core;

import byog.TileEngine.TETile;

import java.util.Random;

public class Room {
    int height;
    int width;
    Point center;

    public Room(int height, int width, Point center) {
        this.height = height;
        this.width = width;
        this.center = center;
    }

    public static Room generateRoom(Random rand, int gameWidth, int gameHeight) {
        int roomHeight = RandomUtils.uniform(rand,2,gameWidth/4) ;
        int roomWidth = RandomUtils.uniform(rand, 2,gameHeight/4);

        int CenterX = RandomUtils.uniform(rand, roomWidth/2 + 1, gameWidth - roomWidth/2);
        int CenterY = RandomUtils.uniform(rand, roomHeight/2 + 1, gameHeight - roomHeight/2);

        Point newCenter = new Point(CenterX, CenterY);
        Room myRoom = new Room(roomHeight, roomWidth, newCenter);
        return myRoom;
    }

    public static boolean roomIntersect(int worldWidth, int worldHeight, Room r1, Room r2) {
        Point BotLeft = new Point(r1.center.x - r1.width / 2, r1.center.y - r1.height / 2);
        Point TopLeft = new Point(r1.center.x - r1.width/2, r1.center.y + r1.height/2);
        Point BotRight = new Point(r1.center.x + r1.width/2, r1.center.y - r1.height/2);
        boolean[][] world = new boolean[worldWidth + 1][worldHeight + 1];
        for (int i = BotLeft.x; i <= BotRight.x; i++) {
            for (int j = BotLeft.y; j <= TopLeft.y; j++) {
                world[i][j] = true;
            }
        }
        Point r2BotLeft = new Point(r2.center.x - r2.width / 2, r2.center.y - r2.height / 2);
        Point r2BotRight = new Point(r2.center.x + r2.width/2, r2.center.y - r2.height/2);
        Point r2TopLeft = new Point(r2.center.x - r2.width/2, r2.center.y + r2.height/2);
        for (int p = r2BotLeft.x; p <= r2BotRight.x; p++) {
            for (int q = r2BotLeft.y; q <= r2TopLeft.y; q++) {
                if (world[p][q]) {
                    return false;
                }
            }
        }
        return true;
    }
}



