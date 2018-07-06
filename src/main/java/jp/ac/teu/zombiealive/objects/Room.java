package jp.ac.teu.zombiealive.objects;

import jp.ac.teu.zombiealive.util.Console;

/**
 * @author C0116086
 */
public class Room {

    static int[][] room
            = {{0, 0, 1, 2, 1, 0, 0, 3, 2, 0, 2, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0},//ゾンビの数
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//アイテム
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//鍵
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//BOSS
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};//行った部屋のフラグ

    static int[][] dungeon = Dungeon.getMapDungeon();
    static String[][] r = new String[26][6];

    public Room() {
        r[0][0] = "       ";
        r[0][1] = "       ";
        r[0][2] = "       ";
        r[0][3] = "       ";
        r[0][4] = "       ";
        r[0][5] = "       ";

        r[25][0] = "*******";
        r[25][1] = "*     *";
        r[25][2] = "*     *";
        r[25][3] = "D     *";
        r[25][4] = "*  P  *";
        r[25][5] = "*******";

        r[24][0] = "***D***";
        r[24][1] = "*     *";
        r[24][2] = "*  Z  *";
        r[24][3] = "*     D";
        r[24][4] = "*     *";
        r[24][5] = "*******";

        r[14][0] = "*******";
        r[14][1] = "*     *";
        r[14][2] = "*  Z  *";
        r[14][3] = "*     D";
        r[14][4] = "*     *";
        r[14][5] = "***D***";

        r[20][0] = "***D***";
        r[20][1] = "*     *";
        r[20][2] = "*    Z*";
        r[20][3] = "D     *";
        r[20][4] = "*     *";
        r[20][5] = "***D***";

        r[19][0] = "*******";
        r[19][1] = "*     *";
        r[19][2] = "*  Z  *";
        r[19][3] = "D     D";
        r[19][4] = "*     *";
        r[19][5] = "*******";

        r[18][0] = "*******";
        r[18][1] = "*     *";
        r[18][2] = "*     *";
        r[18][3] = "*     D";
        r[18][4] = "*     *";
        r[18][5] = "***D***";

        r[23][0] = "***D***";
        r[23][1] = "*     *";
        r[23][2] = "*  Z  *";
        r[23][3] = "D     *";
        r[23][4] = "*     *";
        r[23][5] = "*******";

        r[22][0] = "*******";
        r[22][1] = "*     *";
        r[22][2] = "*     *";
        r[22][3] = "D     D";
        r[22][4] = "*     *";
        r[22][5] = "*******";

        r[21][0] = "***D***";
        r[21][1] = "*     *";
        r[21][2] = "*     *";
        r[21][3] = "*     D";
        r[21][4] = "*     *";
        r[21][5] = "*******";

        r[17][0] = "***D***";
        r[17][1] = "*     *";
        r[17][2] = "*  Z  *";
        r[17][3] = "D     *";
        r[17][4] = "*     *";
        r[17][5] = "***D***";

        r[16][0] = "*******";
        r[16][1] = "*     *";
        r[16][2] = "*  Z  *";
        r[16][3] = "*     D";
        r[16][4] = "*     *";
        r[16][5] = "*******";

        r[11][0] = "***D***";
        r[11][1] = "*     *";
        r[11][2] = "*     *";
        r[11][3] = "*     D";
        r[11][4] = "*     *";
        r[11][5] = "***D***";

        r[12][0] = "*******";
        r[12][1] = "*     *";
        r[12][2] = "*    H*";
        r[12][3] = "D     *";
        r[12][4] = "*     *";
        r[12][5] = "*******";

        r[9][0] = "***D***";
        r[9][1] = "*     *";
        r[9][2] = "*     *";
        r[9][3] = "D     *";
        r[9][4] = "*     *";
        r[9][5] = "***D***";

        r[8][0] = "*******";
        r[8][1] = "*     *";
        r[8][2] = "*  Z  *";
        r[8][3] = "D     D";
        r[8][4] = "*     *";
        r[8][5] = "*******";

        r[7][0] = "*******";
        r[7][1] = "*     *";
        r[7][2] = "*  K  *";
        r[7][3] = "*     D";
        r[7][4] = "*     *";
        r[7][5] = "*******";

        r[1][0] = "*******";
        r[1][1] = "*     *";
        r[1][2] = "*     *";
        r[1][3] = "*     D";
        r[1][4] = "*     *";
        r[1][5] = "***D***";

        r[2][0] = "*******";
        r[2][1] = "*     *";
        r[2][2] = "*  Z  *";
        r[2][3] = "D     D";
        r[2][4] = "*     *";
        r[2][5] = "*******";

        r[3][0] = "*******";
        r[3][1] = "*     *";
        r[3][2] = "*  Z  *";
        r[3][3] = "D     D";
        r[3][4] = "*     *";
        r[3][5] = "*******";

        r[4][0] = "*******";
        r[4][1] = "*     *";
        r[4][2] = "*  Z  *";
        r[4][3] = "D     D";
        r[4][4] = "*     *";
        r[4][5] = "***D***";

        r[10][0] = "***D***";
        r[10][1] = "*     *";
        r[10][2] = "*  Z  *";
        r[10][3] = "*     *";
        r[10][4] = "*     *";
        r[10][5] = "***D***";

        r[13][0] = "***D***";
        r[13][1] = "*     *";
        r[13][2] = "*  Z  *";
        r[13][3] = "*     *";
        r[13][4] = "*     *";
        r[13][5] = "*******";

        r[5][0] = "*******";
        r[5][1] = "*     *";
        r[5][2] = "*   H *";
        r[5][3] = "D     L";
        r[5][4] = "*     *";
        r[5][5] = "*******";

        r[6][0] = "*******";
        r[6][1] = "*  B  *";
        r[6][2] = "*     *";
        r[6][3] = "D     *";
        r[6][4] = "*     *";
        r[6][5] = "*******";

        r[15][0] = "*******";
        r[15][1] = "*     *";
        r[15][2] = "*    H*";
        r[15][3] = "D     *";
        r[15][4] = "*     *";
        r[15][5] = "*******";

    }

    public static void mapRoom() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 8; k++) {
                    if (Room.room[4][dungeon[i][k]] == 1) {
                        System.out.print(r[dungeon[i][k]][j]);
                    } else {
                        System.out.print(r[0][j]);
                    }
                }
                System.out.println("");
            }
        }
        Console.write("*=壁   D=扉   Z=ZOMBIE   B=BOSS   P=PLAYER");
        Console.write("H=回復アイテム   K=KEY   L=ロックされた扉");
    }

    public void resetMapRoom(int roomNo) {
        r[roomNo][2] = "*     *";
    }

    public static void setPlayerMapRoom(int roomNo) {
        r[roomNo][4] = "*  P  *";
    }

    public static void resetPlayerMapRoom(int roomNo) {
        r[roomNo][4] = "*     *";
    }
    
    public int[][] getRoom(){
        return room;
    }

    public void setMapRoom(int roomNo) {
        room[4][roomNo] = 1;
    }

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
