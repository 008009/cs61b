package byog.Core;

import byog.SaveDemo.World;
import java.lang.*;
import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import byog.lab5.Hexagon;
import edu.princeton.cs.introcs.StdDraw;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.awt.*;
import java.util.Iterator;
import java.util.*;

public class Game {
    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 30;
    private long seed;


    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     */
    public void playWithKeyboard() {
        //StdDraw.enableDoubleBuffering();
        drawBeginningMenu(ter);
        while(true) {
            if(StdDraw.hasNextKeyTyped()) {
                char input = StdDraw.nextKeyTyped();
                input = Character.toLowerCase(input);
                analyze(input);
            }
        }
    }

    private void analyze(char input) {
        if(input == 'n') {
            drawWorld(ter);

            System.out.println("The world has been drawn");
        }else if(input == 'l') {
            // load the existing game
            System.out.println("load game");
        }else if(input == 'q'){
            System.exit(0);
        }
    }

    private void drawBeginningMenu(TERenderer ter) {
        ter.initialize(WIDTH,HEIGHT);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(40,28,"CS61B: Escaping the DARKNESS!!!");
        StdDraw.text(40, 20, "New Game (N)");
        StdDraw.text(40, 18, "Load Game (L)");
        StdDraw.text(40, 16, "Quit (Q)");
        StdDraw.show();
    }

    private long drawSeedMenu(TERenderer ter) {
        ter.initialize(WIDTH, HEIGHT);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(40, 15, "Please enter the seed you want:");
        StdDraw.show();
        StringBuilder sb = new StringBuilder();

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char sInput = StdDraw.nextKeyTyped();
                sInput = Character.toLowerCase(sInput);
                if (sInput == 's') {
                    break;
                }
                if (Character.isDigit(sInput)) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    sb.append(sInput);
                    StdDraw.text(40,14,sb.toString());
                    StdDraw.show();
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledRectangle(40,14,80,0.5);
                }
            }
        }
        String s = sb.toString();
        System.out.println(Long.parseLong(s));
        return Long.parseLong(s);
    }

    private void drawWorld(TERenderer ter) {
        // 画出黑色底板
        // generate room
        // generate hall

        ter.initialize(WIDTH, HEIGHT);
        seed = drawSeedMenu(ter);
        Random rand = new Random(seed);
        int numberOfRoom =RandomUtils.uniform(rand,WIDTH);
        //int numberOfRoom = 10;
        TETile[][] randomTiles = new TETile[WIDTH][HEIGHT];
        ArrayList<Room> RoomList = new ArrayList<>();

        //设置黑色底板
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                randomTiles[x][y] = Tileset.NOTHING;
            }
        }

        while(RoomList.size() < numberOfRoom){
            Room myRoom = Room.generateRoom(rand, WIDTH, HEIGHT);
            if(RoomList.size() == 0) {
                RoomList.add(myRoom);
            }else{
                if(checkHelper(RoomList, myRoom)){
                    RoomList.add(myRoom);
                }
            }
        }
//        System.out.println("The numbeOfRoom is " + numberOfRoom);
//        System.out.println("The total RoomList is " + RoomList.size());

        // draw the room
        for(int i = 0; i < RoomList.size(); i++){
//            Point BotLeft = new Point(RoomList.get(i).center.x - RoomList.get(i).width/2, RoomList.get(i).center.y - RoomList.get(i).height/2);
//            Point TopRight = new Point(RoomList.get(i).center.x + RoomList.get(i).width/2, RoomList.get(i).center.y + RoomList.get(i).height/2);
//            if(i == 0){
//                System.out.println(randomTiles[TopRight.x][TopRight.y]);
//            }
            drawRoom(randomTiles, RoomList.get(i));
        }
        ter.renderFrame(randomTiles);
    }

    private boolean checkHelper(ArrayList<Room> rl, Room r) {
        boolean result = true;
        for(int i = 0; i < rl.size(); i++) {
            result = result && Room.roomIntersect(WIDTH, HEIGHT, r, rl.get(i));
        }
        return result;
    }


    private void drawRoom(TETile[][] world, Room r) {
        Point BotLeft = new Point(r.center.x - r.width/2, r.center .y - r.height/2);
        Point BotRight = new Point(r.center.x + r.width/2, r.center.y - r.height/2);
        Point TopLeft = new Point(r.center.x - r.width/2, r.center.y + r.height/2);
        Point TopRight = new Point(r.center.x + r.width/2, r.center.y + r.height/2);

        //botline
        for(int i = BotLeft.x; i <= BotRight.x; i++){
            world[i][BotLeft.y] = Tileset.FLOOR;
        }
        //topline
        for(int j = TopLeft.x; j <= TopRight.x; j++){
            world[j][TopLeft.y] = Tileset.FLOOR;
        }
        //leftline
        for(int x = BotLeft.y; x <= TopLeft.y; x++){
            world[TopLeft.x][x] = Tileset.FLOOR;
        }
        //rightline
        for(int y = BotRight.y; y <= TopRight.y; y++){
            world[TopRight.x][y] = Tileset.FLOOR;
        }
        //world[r.center.x][r.center.y] = Tileset.WALL;

    }









    /**
     * Method used for autograding and testing the game code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The game should
     * behave exactly as if the user typed these characters into the game after playing
     * playWithKeyboard. If the string ends in ":q", the same world should be returned as if the
     * string did not end with q. For example "n123sss" and "n123sss:q" should return the same
     * world. However, the behavior is slightly different. After playing with "n123sss:q", the game
     * should save, and thus if we then called playWithInputString with the string "l", we'd expect
     * to get the exact same world back again, since this corresponds to loading the saved game.
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */
    public TETile[][] playWithInputString(String input) {
        // TODO: Fill out this method to run the game using the input passed in,
        // and return a 2D tile representation of the world that would have been
        // drawn if the same inputs had been given to playWithKeyboard().

        TETile[][] finalWorldFrame = null;
        return finalWorldFrame;
    }
}

