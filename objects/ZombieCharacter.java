package zombiealive;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
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
