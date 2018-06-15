package jp.ac.teu.zombiealive.objects;

import jp.ac.teu.zombiealive.util.Console;
import jp.ac.teu.zombiealive.objects.Dungeon;

import java.util.Random;

public class PlayerCharacter {
    private int hp = 30;
    private int roomId = 25;
    private int x = 4;
    private int y = 7;
    private int weapon = 0;
    private boolean key = false;
    private String read;


    public int getHp() {
        return hp;
    }

    public String getAboutHp() {
        String str = "denger";
        if (hp >= 15) {
            str = "fine";
        } else if (hp > 10) {
            str = "Caution";
        }
        return str;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getRoom() {
        return roomId;
    }

    public boolean getKey() {
        return key;
    }

    public void setRoom(int roomId) {
        this.roomId = roomId;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public boolean move() {

        // TODO Player Move Logic

        Console.write("行き先の方向を指定してください");
        Console.write("W:↑ A:← S:↓ D:→");

        int yd = 0;
        int xd = 0;
        int tmp_roomId;

        read = Console.read();

        switch (read) {
            case "w":
                --yd;
                break;
            case "a":
                ++xd;
                break;
            case "s":
                ++yd;
                break;
            case "d":
                --xd;
                break;
            default:
                Console.write("W:↑ A:← S:↓ D:→で入力してください");
                return false;
        }
        try {
            tmp_roomId = Dungeon.getDungeon(x + xd, y + yd);
        } catch (Exception e) {
            Console.write("移動できません");
            return false;
        }

        if (tmp_roomId == 0) {
            Console.write("移動できません");
            return false;
        } else {

            return true;
        }
    }

    public void escape() {

        // TODO Player Escape Logic

    }

/*    public int[] getAttackDamage() {
        Random rand = new Random();
        switch (weapon) {
            case 0: // 素手
                return [rand.nextInt(3) + 1, 0];
                break;
            case 1: // ハンドガン
                return [rand.nextInt(6) + 1, 0];
                break;
            case 2: // ショットガン
                return [rand.nextInt(10) + 1, 0];
            case 3: // マシンガン
                return [rand.nextInt(3) + 1, 1];
            case 4: // グレネードランチャー
                return [rand.nextInt(6) + 1, 1];
            case 5: // ロケットランチャー
                return [rand.nextInt(10) + 1, 1];

        }
    }*/
}
