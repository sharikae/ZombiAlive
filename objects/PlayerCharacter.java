/**
 * @author Shota Harikae
 */
public class PlayerCharacter {
    int hp = 30;
    int room = 0;
    int weapon = 0;
    boolean key = false;

    public PlayerCharacter(int hp, int room, int weapon, boolean key) {
        this.hp = hp;
        this.room = room;
        this.weapon = weapon;
        this.key = key;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
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

    public int[] getAttackDamage() {
        Random rand = new Random();
        switch (weapon) {
            case 0: // 素手
                return [rand.nextInt(3) + 1, 0];
            case 1: // ハンドガン
                return [rand.nextInt(6) + 1, 0];
            case 2: // ショットガン
                return [rand.nextInt(10) + 1, 0];
            case 3: // マシンガン
                return [rand.nextInt(3) + 1, 1];
            case 4: // グレネードランチャー
                return [rand.nextInt(6) + 1, 1];
            case 5: // ロケットランチャー
                return [rand.nextInt(10) + 1, 1]
        }
    }
}
