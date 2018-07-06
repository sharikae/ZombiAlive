package jp.ac.teu.zombiealive.objects;

/**
 * @author C0116178
 * @author c0116125
 */

public class ZombieCharacter {

    private static int kill=0;
    private int zombieHitPoint;

    public ZombieCharacter() {
        zombieHitPoint = 6;
        kill++;
    }

    public int getHp() {                        //ゾンビのHPを返す
        return zombieHitPoint;
    }

    public void damageToZombie(int damage) {    //ゾンビのHPを減らす
        zombieHitPoint -= damage;
    }

    public static int getKill() {
        return kill;
    }
    
    
}
