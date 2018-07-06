package jp.ac.teu.zombiealive.objects;

import jp.ac.teu.zombiealive.util.Console;
import jp.ac.teu.zombiealive.objects.Dungeon;
import java.util.Queue;
import java.util.ArrayDeque;

import java.util.Random;

public class PlayerCharacter {

    private static int hp = 30;
    private static int roomId = 25;
    private static int x = 4;
    private static int y = 7;
    private static int weapon = 0;
    private static boolean key = false;
    private static String read;
    private static int yd = 0;
    private static int xd = 0;
    private static int tmp_roomId;
    Queue<Integer> step = new ArrayDeque<>();

    public int getHp() {
        return hp;
    }

    public static String getAboutHp() {
        String str = "denger";
        if (hp >= 20) {
            str = "fine";
        } else if (hp > 10) {
            str = "Caution";
        }
        return str;
    }

    public void setNumberOfStep() {
        step.add(roomId);
    }

    public int getNumberOfStep() {
        return step.poll();
    }

    public void clearStep() {//全削除処理
        step.clear();
    }

    public void setHp(int hp) {
        //System.out.println("HPが回復しました");
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

    public static int getWeapon() {
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

    public boolean move(int[][] room) {
        // TODO Player Move Logic

        tmp_roomId = 0;
        xd = 0;
        yd = 0;

        Console.text("行き先の方向を指定してください \n W:↑ A:← S:↓ D:→");

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
                Console.text("W:↑ A:← S:↓ D:→で入力してください");
                return false;
        }

        try {
            tmp_roomId = Dungeon.getDungeon(y + yd, x + xd);
        } catch (Exception e) {
            Console.text("移動できません");
            return false;
        }

        switch (tmp_roomId) {
            case 0:
                Console.text("移動できません");
                return false;
            case 6:
                if (key) {
                    escape(room);
                    roomId = tmp_roomId;
                    y = y + yd;
                    x = x + xd;
                    return true;
                } else {
                    Console.text("鍵がかかっているようだ･･･");
                    return false;
                }
            case 13:
                if (roomId == 14 | roomId == 19) {
                    Console.text("移動できません");
                    return false;
                } else {
                    escape(room);
                    roomId = tmp_roomId;
                    y = y + yd;
                    x = x + xd;
                    return true;
                }
            default:
                escape(room);
                roomId = tmp_roomId;
                y = y + yd;
                x = x + xd;
                return true;
        }
    }

    public void escape(int[][] room) {
        Console.write("次の部屋を覗きますか？");
        Console.write("覗くならyを入力してください");
        if ("y".equals(Console.read())) {
            Console.write("次の部屋の情報を表示します");
            Console.write("ゾンビの数　：" + room[0][tmp_roomId]);
            if (room[1][tmp_roomId] == 1) {
                Console.write("アイテムがありそうだ");
            } else {
                Console.write("アイテムはなさそうだ");
            }
            if (room[2][tmp_roomId] == 1) {
                Console.write("鍵がありそうだ");
            } else {
                Console.write("鍵はなさそうだ");
            }
            if (room[3][tmp_roomId] == 1) {
                Console.write("BOSSがいそうだ");
            } else {
                Console.write("BOSSはいないようだ");
            }
            tmp_roomId = roomId;
            yd = 0;
            xd = 0;
            Console.waitInput();

        } else {
            Console.write("次の部屋にそのまま移行します");
            Console.waitInput();
        }
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
