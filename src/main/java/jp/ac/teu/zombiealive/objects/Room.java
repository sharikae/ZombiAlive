package jp.ac.teu.zombiealive.objects;

/**
 * @author C0116086
 */
public class Room {

    int[][] room
            = {{0, 0, 1, 2, 1, 0, 0, 3, 2, 0, 2, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0},//ゾンビの数
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//アイテム
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//鍵
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//BOSS
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};//行った部屋のフラグ
     
    public void mapRoom() {
String[] r0 = new String[6];
        r0[0] = "       ";
        r0[1] = "       ";
        r0[2] = "       ";
        r0[3] = "       ";
        r0[4] = "       ";
        r0[5] = "       ";

        String[] r25 = new String[6];
        r25[0] = "*******";
        r25[1] = "*     *";
        r25[2] = "*     *";
        r25[3] = "D  P  *";
        r25[4] = "*     *";
        r25[5] = "*******";

        String[] r24 = new String[6];
        r24[0] = "***D***";
        r24[1] = "*     *";
        r24[2] = "*  Z  *";
        r24[3] = "*     D";
        r24[4] = "*     *";
        r24[5] = "*******";

        String[] r20 = new String[6];
        r20[0] = "***D***";
        r20[1] = "*     *";
        r20[2] = "*     *";
        r20[3] = "D     *";
        r20[4] = "*     *";
        r20[5] = "***D***";

        String[] r14 = new String[6];
        r14[0] = "*******";
        r14[1] = "*     *";
        r14[2] = "*  Z  *";
        r14[3] = "*     D";
        r14[4] = "*     *";
        r14[5] = "***D***";

        String[] r15 = new String[6];
        r20[0] = "*******";
        r20[1] = "*     *";
        r20[2] = "*    H*";
        r20[3] = "D     *";
        r20[4] = "*     *";
        r20[5] = "*******";

        String[] r19 = new String[6];
        r19[0] = "***D***";
        r19[1] = "*     *";
        r19[2] = "*  Z  *";
        r19[3] = "D     D";
        r19[4] = "*     *";
        r19[5] = "*******";

        String[] r18 = new String[6];
        r18[0] = "*******";
        r18[1] = "*     *";
        r18[2] = "*     *";
        r18[3] = "*     D";
        r18[4] = "*     *";
        r18[5] = "***D***";

        String[] r23 = new String[6];
        r23[0] = "***D***";
        r23[1] = "*     *";
        r23[2] = "*  Z  *";
        r23[3] = "D     *";
        r23[4] = "*     *";
        r23[5] = "*******";

        String[] r22 = new String[6];
        r22[0] = "*******";
        r22[1] = "*     *";
        r22[2] = "*     *";
        r22[3] = "D     D";
        r22[4] = "*     *";
        r22[5] = "*******";

        String[] r21 = new String[6];
        r21[0] = "***D***";
        r21[1] = "*     *";
        r21[2] = "*     *";
        r21[3] = "*     D";
        r21[4] = "*     *";
        r21[5] = "*******";

        String[] r17 = new String[6];
        r17[0] = "***D***";
        r17[1] = "*     *";
        r17[2] = "*  Z  *";
        r17[3] = "D     *";
        r17[4] = "*     *";
        r17[5] = "***D***";

        String[] r16 = new String[6];
        r16[0] = "*******";
        r16[1] = "*     *";
        r16[2] = "*  Z  *";
        r16[3] = "*     D";
        r16[4] = "*     *";
        r16[5] = "*******";

        String[] r11 = new String[6];
        r11[0] = "***D***";
        r11[1] = "*     *";
        r11[2] = "*     *";
        r11[3] = "*     D";
        r11[4] = "*     *";
        r11[5] = "***D***";

        String[] r12 = new String[6];
        r12[0] = "*******";
        r12[1] = "*     *";
        r12[2] = "*    H*";
        r12[3] = "D     *";
        r12[4] = "*     *";
        r12[5] = "*******";

        String[] r9 = new String[6];
        r9[0] = "***D***";
        r9[1] = "*     *";
        r9[2] = "*     *";
        r9[3] = "D     *";
        r9[4] = "*     *";
        r9[5] = "***D***";

        String[] r8 = new String[6];
        r8[0] = "*******";
        r8[1] = "*     *";
        r8[2] = "*  Z  *";
        r8[3] = "D     D";
        r8[4] = "*     *";
        r8[5] = "*******";

        String[] r7 = new String[6];
        r7[0] = "*******";
        r7[1] = "*  K  *";
        r7[2] = "*     *";
        r7[3] = "*     D";
        r7[4] = "*     *";
        r7[5] = "*******";
        
        String[] r1 = new String[6];
        r1[0] = "*******";
        r1[1] = "*     *";
        r1[2] = "*     *";
        r1[3] = "*     D";
        r1[4] = "*     *";
        r1[5] = "***D***";
        
        String[] r2 = new String[6];
        r2[0] = "*******";
        r2[1] = "*     *";
        r2[2] = "*  Z  *";
        r2[3] = "D     D";
        r2[4] = "*     *";
        r2[5] = "*******";
        
         String[] r3 = new String[6];
        r3[0] = "*******";
        r3[1] = "*     *";
        r3[2] = "*  Z  *";
        r3[3] = "D     D";
        r3[4] = "*     *";
        r3[5] = "*******";
        
        String[] r4 = new String[6];
        r4[0] = "*******";
        r4[1] = "*     *";
        r4[2] = "*  Z  *";
        r4[3] = "D     D";
        r4[4] = "*     *";
        r4[5] = "***D***";
        
        String[] r10 = new String[6];
        r10[0] = "***D***";
        r10[1] = "*     *";
        r10[2] = "*  Z  *";
        r10[3] = "*     *";
        r10[4] = "*     *";
        r10[5] = "***D***";
        
         String[] r13 = new String[6];
        r13[0] = "***D***";
        r13[1] = "*     *";
        r13[2] = "*  Z  *";
        r13[3] = "*     *";
        r13[4] = "*     *";
        r13[5] = "*******";
        
         String[] r5 = new String[6];
        r5[0] = "*******";
        r5[1] = "*     *";
        r5[2] = "*   H *";
        r5[3] = "D     L";
        r5[4] = "*     *";
        r5[5] = "*******";
        
         String[] r6 = new String[6];
        r10[0] = "*******";
        r10[1] = "*  B  *";
        r10[2] = "*     *";
        r10[3] = "D     *";
        r10[4] = "*     *";
        r10[5] = "*******";
        for (int i = 0; i < 6; i++) {
            System.out.print(r0[i]);
            if (room[4][0] == 1) {
                System.out.print(r0[i]);
            }
            if (room[4][1] == 1) {
                System.out.print(r1[i]);
            }
            if (room[4][2] == 1) {
                System.out.print(r2[i]);
            }
            if (room[4][3] == 1) {
                System.out.print(r3[i]);
            }
            if (room[4][4] == 1) {
                System.out.print(r4[i]);
            }
            if (room[4][5] == 1) {
                System.out.print(r5[i]);
            }
            if (room[4][6] == 1) {
                System.out.print(r6[i]);
            }
            if (room[4][7] == 1) {
                System.out.print(r7[i]);
            }
            if (room[4][8] == 1) {
                System.out.print(r8[i]);
            }
            if (room[4][9] == 1) {
                System.out.print(r9[i]);
            }
            if (room[4][10] == 1) {
                System.out.print(r10[i]);
            }
            if (room[4][11] == 1) {
                System.out.print(r11[i]);
            }
            if (room[4][12] == 1) {
                System.out.print(r12[i]);
            }
            if (room[4][13] == 1) {
                System.out.print(r13[i]);
            }
            if (room[4][14] == 1) {
                System.out.print(r14[i]);
            }
            if (room[4][15] == 1) {
                System.out.print(r15[i]);
            }
            if (room[4][16] == 1) {
                System.out.print(r16[i]);
            }
            if (room[4][17] == 1) {
                System.out.print(r17[i]);
            }
            if (room[4][18] == 1) {
                System.out.print(r18[i]);
            }
            if (room[4][19] == 1) {
                System.out.print(r19[i]);
            }
            if (room[4][20] == 1) {
                System.out.print(r20[i]);
            }
            if (room[4][21] == 1) {
                System.out.print(r21[i]);
            }
            if (room[4][22] == 1) {
                System.out.print(r22[i]);
            }
            if (room[4][23] == 1) {
                System.out.print(r23[i]);
            }
            if (room[4][24] == 1) {
                System.out.print(r24[i]);
            }
            if (room[4][25] == 1) {
                System.out.println(r25[i]);
            }
        }

    }

    public void setMapRoom(int roomNo){
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
