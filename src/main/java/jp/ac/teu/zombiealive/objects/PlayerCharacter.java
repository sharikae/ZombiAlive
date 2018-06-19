package jp.ac.teu.zombiealive.objects;

import jp.ac.teu.zombiealive.util.Console;
import jp.ac.teu.zombiealive.objects.Dungeon;
import java.util.Queue;
import java.util.ArrayDeque;

import java.util.Random;

public class PlayerCharacter {

    private int hp = 30;
    private int roomId = 25;
    private int x = 4;
    private int y = 7;
    private int weapon = 0;
    private boolean key = false;
    private String read;
    private int yd = 0;
    private int xd = 0;
    private int tmp_roomId;
    Queue<Integer> step = new ArrayDeque<Integer>();

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

    public void setNumberOfStep() {
        step.add(roomId);
    }

    public Queue getNumberOfStep() {
        return step;
    }

    public int getXPosition() {
        return y;
    }

    public int getYPosition() {
        return x;
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

        tmp_roomId = 0;
        xd = 0;
        yd = 0;

        Console.write("行き先の方向を指定してください");
        Console.write("W:↑ A:← S:↓ D:→");

        read = Console.read();

        switch (read) {
            case "w"://上
                xd--;
                break;
            case "a"://左
                yd--;
                break;
            case "s"://下
                xd++;
                break;
            case "d"://右
                yd++;
                break;
            default:
                Console.write("W:↑ A:← S:↓ D:→で入力してください");
                return false;
        }

        try {
            tmp_roomId = Dungeon.getDungeon(y + yd, x + xd);
            System.out.println(tmp_roomId);
        } catch (Exception e) {
            Console.write("移動できません");
            return false;
        }

        if (tmp_roomId == 0) {
            Console.write("移動できません");
            return false;
        } else {
            roomId = tmp_roomId;
            y = y + yd;
            x = x + xd;
            return true;
        }
    }

    public void escape() {

        // TODO Player Escape Logic
    }

    public int[] getAttackDamage() {
        Random rand = new Random();
        switch (weapon) {
            case 0: // 素手
                return new int[]{rand.nextInt(3) + 1, 0};
            case 1: // ハンドガン
                return new int[]{rand.nextInt(6) + 1, 0};
            case 2: // ショットガン
                return new int[]{rand.nextInt(10) + 1, 0};
            case 3: // マシンガン
                return new int[]{rand.nextInt(3) + 1, 1};
            case 4: // グレネードランチャー
                return new int[]{rand.nextInt(6) + 1, 1};
            case 5: // ロケットランチャー
                return new int[]{rand.nextInt(10) + 1, 1};
        }
        return new int[]{0, 0};
    }
}
