package jp.ac.teu.zombiealive.objects;

/**
 * @author C0116086
 */
public class Room {

    int[][] room
            = {{0, 0, 1, 2, 1, 0, 0, 3, 2, 0, 2, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0},//ゾンビの数
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//アイテム
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//鍵
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};//BOSS

    public int getZombieNum(int roomNo) {//ゾンビの数
        return room[0][roomNo];
    }

    public boolean getItem(int roomNo) {//アイテムがあるか
        if (room[1][roomNo] != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getKey(int roomNo) {//鍵があるか
        if (room[2][roomNo] != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getBoss(int roomNo) {//Bossがいるか
        if (room[3][roomNo] != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setZombieNum(int roomNo) {//ゾンビを倒したら
        room[0][roomNo] = 0;
    }

    public void setItem(int roomNo) {//アイテムを使用したら
        room[1][roomNo] = 0;
    }

    public void setKey(int roomNo) {//鍵を取得したら
        room[2][roomNo] = 0;
    }
}
