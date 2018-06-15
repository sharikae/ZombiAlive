/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.teu.zombiealive.objects;

/**
 *
 * @author C0116125
 */
public class Battle {
    private static PlayerCharacter pc;
    public Battle(PlayerCharacter p){//初期化
        this.pc=p;
    }

    public static PlayerCharacter getPc() {//戦闘後の初期化
        return pc;
    }
    
    
    
    public static boolean vsZombie(PlayerCharacter p,int x){
        boolean finished=true;//終了したら
        boolean vs=true;//戦闘に勝利したらtrue
        ZombieCharacter zc=new ZombieCharacter();
        while (finished) {
            //int[] a=pc.getAttackDamage();//とりあえず帰ってくるのは[]ではない場合の処理
            int a=2;
            zc.damageToZombie(a);
            System.out.println("あなたは"+a+"ダメージを与えた");
            if (zc.getHp()<=0) {//ゾンビが0ならば
                System.out.println("敵を倒した！");
                break;//勝利は初期化されてるので戻る
            }
            
            pc.setHp(pc.getHp()-1);//１ダメージ喰らう
            if (pc.getHp()<=0) {
                System.out.println("あなたは死んだ！");
                vs=false;
                break;
            }
            
            
        }
        return vs;
    }
    
    
    
}
