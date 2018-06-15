package jp.ac.teu.zombiealive.objects;

/**
 * @author C0116086
 */
public class Room {
    int[][] room
            = {{0, 0, 1, 2, 1, 0, 0, 3, 2, 0, 2, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    public int getZombieNum(int roomNo) {
        return room[0][roomNo];
    }

    public boolean getItem(int roomNo) {
        if (room[1][roomNo] != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getKey(int roomNo) {
        if (room[2][roomNo] != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getBoss(int roomNo) {
        if (room[3][roomNo] != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setZombieNum(int roomNo) {
        room[0][roomNo] = 0;
    }

    public void setItem(int roomNo) {
        room[1][roomNo] = 0;
    }

    public void setKey(int roomNo) {
        room[2][roomNo] = 0;
    }
}
