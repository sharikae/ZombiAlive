/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.teu.zombiealive.objects;

import jp.ac.teu.zombiealive.util.Console;

/**
 *
 * @author C0116125
 */
public class Battle {
    private static PlayerCharacter pc;
    Manager mg=new Manager();
    public Battle(PlayerCharacter p){//初期化
        Battle.pc=p;//ここいる？
    }

    public static PlayerCharacter getPc() {//戦闘後の初期化
        return pc;
    }
    
    
    
    public static boolean vsZombie(PlayerCharacter p){
        boolean finished=true;//終了したら
        boolean vs=true;//戦闘に敗北したらfalseになる,
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
            System.out.println("あなたは1ダメージを喰らった!");
            pc.setHp(pc.getHp()-1);//１ダメージ喰らう
            if (pc.getHp()<=0) {
                System.out.println("あなたは死んだ！");
                vs=false;
                break;
            }
            Console.write("現在の体力状態: " + pc.getHp());
            
        }
        return vs;
    }
    
    public static boolean vsZombie(PlayerCharacter p,int i){
        boolean finished=true;//終了したら
        boolean vs=true;//戦闘に敗北したらfalseになる,
        ZombieCharacter zc1=new ZombieCharacter();
        ZombieCharacter zc2=new ZombieCharacter();
        ZombieCharacter zc3=new ZombieCharacter();
        int n=i;//書き換えを行うので一応やっとく処理
        int x=0;
        switch (n){
            case 2://２体なら
                zc3.damageToZombie(99);//ゾンビ3はいない
            case 1://１体なら
                zc2.damageToZombie(99);//ゾンビ2もいない
        }
        while (finished) {
            int[] a=pc.getAttackDamage();//とりあえず帰ってくるのは[]ではない場合の処理
            if (a[1]==0) {//全体攻撃じゃなければ
                if (zc3.getHp() > 0) {//ゾンビ３が死んでなければ
                    zc3.damageToZombie(a[0]);
                    x=3;
                } else if (zc2.getHp() > 0) {//ゾンビ2が死んでなければ
                    zc2.damageToZombie(a[0]);
                    x=2;
                } else if (zc1.getHp() > 0) {//ゾンビ1が死んでなければ
                    zc1.damageToZombie(a[0]);
                    x=1;
                }
                System.out.println("あなたはゾンビ"+x+"に"+a[0]+"ダメージを与えた");
                
            }else{//全体攻撃ならば
                zc3.damageToZombie(a[0]);
                zc2.damageToZombie(a[0]);
                zc1.damageToZombie(a[0]);
                
                System.out.println("あなたは"+n+"体に"+a[0]+"ダメージ与えた！");
                
            }
            
            
            if (zc1.getHp()<=0&&zc2.getHp()<=0&&zc3.getHp()<=0) {//ゾンビが0ならば
                System.out.println("全ての敵を倒した！");
                break;//勝利は初期化されてるので戻る
            }
            n=0;//生存確認
            if (zc1.getHp()>0)  n++;//ゾンビ1の生存確認
            if(zc2.getHp()>0)   n++;//ゾンビ2の生存確認
            if(zc3.getHp()>0)   n++;//ゾンビ3の生存確認
            
            System.out.println("あなたは"+n+"ダメージを喰らった!");
            pc.setHp(pc.getHp()-n);
            if (pc.getHp()<=0) {
                System.out.println("あなたは死んだ！");
                vs=false;
                break;
            }
            Console.write("現在の体力状態: " + pc.getHp());
            
        }
        return vs;
    }
    
    
    
}
