/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zonbialive;

/**
 *
 * @author C0116125
 */
public class BossCharacter {
    private int bossHitPoint;
    private int bossAttack;
    public BossCharacter(int bossHitPoint, int bossAttack) {
        this.bossHitPoint = bossHitPoint;
    }

    public int getBossHitPoint() {
        return bossHitPoint;
    }

    public int getBossAttack() {//‚±‚±‚ÅUŒ‚—Í‚ğŒˆ’è‚µƒ_ƒ[ƒW‚ğ•Ô‚·
        return bossAttack;
    }
}
