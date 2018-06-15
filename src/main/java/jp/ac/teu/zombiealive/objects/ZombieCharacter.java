package jp.ac.teu.zombiealive.objects;

/**
 * @author C0116178
 */

public class ZombieCharacter {

    private int zombieHitPoint;

    public ZombieCharacter() {
        zombieHitPoint = 6;
    }

    public int getHp() {                        //ゾンビのHPを返す
        return zombieHitPoint;
    }

    public void damageToZombie(int damage) {    //ゾンビのHPを減らす
        zombieHitPoint -= damage;
    }
}
