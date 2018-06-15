package jp.ac.teu.zombiealive.objects;

/**
 * @author C0116086
 */
public class Room {
    boolean player;
    boolean daughter;
    boolean zombie;
    boolean key;
    boolean item;
    boolean boss;
    boolean north;
    boolean west;
    boolean south;
    boolean east;
    int zombieNum;

    public Room(int roomNo) {
        zombieNum = 0;
    }

    public int getZombieNum(int roomNo) {
        switch (roomNo) {
            case 2:
            case 4:
            case 13:
            case 14:
            case 16:
            case 17:
            case 19:
            case 23:
                zombieNum = 1;
                break;
            case 3:
            case 8:
            case 10:
                zombieNum = 2;
                break;
            case 7:
                zombieNum = 3;
                key = true;
                break;
            case 5:
            case 12:
            case 15:
                item = true;
                zombieNum = 0;
                break;
            case 6:
                boss = true;
                zombieNum = 0;
                break;
            default:
                zombieNum = 0;
        }
        return zombieNum;
    }

    public void zombieLocator() {

        if (zombie = true) {
            zombieNum += 1;
            System.out.println(zombieNum + " Zombies found!");
        } else {
            System.out.println("No Zombies.");
        }
    }

    public void Inventory() {
        if (key = true) {
            System.out.println("You have a key.");
        } else {
            System.out.println("You don't have a key.");
        }

        if (item = true) {
            System.out.println("You have an Item.");
        } else {
            System.out.println("You don't have an Item.");
        }
    }

    public void Daughter() {
        if (daughter = true) {
            System.out.println("a daughter is here.");
        } else {
            System.out.println("No daughter here.");
        }
    }
    
    public boolean[] nextMove(int roomNo) {        
        switch (roomNo) {
            case 1:
            case 18:
                east = true;
                south = true;
                break;
            case 2:
            case 3:
            case 5:
            case 8:
            case 19:
            case 22:
                west = true;
                east = true;
                break;
            case 4:
                west = true;
                east = true;
                south = true;
                break;
            case 7:
            case 11:
            case 14:
            case 16:
                east = true;
                break;
            case 9:
            case 15:
            case 17:
            case 25:
                west = true;
                break;
            case 10:
            case 20:
                north = true;
                south = true;
                break;
            case 13:
                north = true;
                break;
            case 21:
            case 24:
                north = true;
                east = true;
                break;
            case 23:
                north = true;
                west = true;
                break;
            default:
                break;
        }
        
        boolean[] nextMove = new boolean[4];
        if (north == true) {
            nextMove[0] = true;
            //Move to Northの処理
        }
        if (east == true) {
            nextMove[1] = true;
            //Movie to Eastの処理
        }
        if (south == true) {
            nextMove[2] = true;
            //Move to Southの処理
        }
        if (west == true) {
            nextMove[3] = true;
            //Move to Westの処理
        }
        return nextMove;
    }
}