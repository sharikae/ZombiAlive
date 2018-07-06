/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.teu.zombiealive.objects;

import com.sun.java.swing.plaf.windows.WindowsBorders;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jp.ac.teu.zombiealive.ZombieAlive.alive;
import jp.ac.teu.zombiealive.util.Console;

/**
 *
 * @author C0116125
 */
public class Battle {

    private static PlayerCharacter pc;
    private static DaughterCharacter dc;
    static Manager mng = new Manager();
    private static boolean test = false;//テスト用か(trueでテスト用)
    private static long time=800;//ウェイトタイムを修正する際はここで決定

    private static boolean finished = true;//終了したら
    private static boolean vs = true;//戦闘に敗北したらfalseになる,

    public Battle(PlayerCharacter p) {//初期化
        Battle.pc = p;//ここいる？
    }

    public static PlayerCharacter getPc() {//戦闘後の初期化
        return pc;
    }

    public static DaughterCharacter getDc() {
        return dc;
    }

    public static boolean vsZombie(PlayerCharacter p) {
        finished = true;//終了したら
        vs = true;//戦闘に敗北したらfalseになる,
        ZombieCharacter zc = new ZombieCharacter();
        pc = p;
        Console.write("ゾンビが現れた！");
        //Console.write("Press Any Key");
        Console.waitInput();
        Console.write("戦闘開始！");
        
        while (finished) {
            int a=pc.getAttackDamage()[0];//とりあえず帰ってくるのは[]ではない場合の処理
            //int a = 2;このままだとダメージが強制的に  2になる
            zc.damageToZombie(a);
            Console.write("あなたは" + a + "ダメージを与えた");
            if (zc.getHp() <= 0) {//ゾンビが0ならば
                Console.write("敵を倒した！");
                //Console.write("Please Any Key");
                //Console.waitInput();
                break;//勝利は初期化されてるので戻る
            }

            try {
                //Console.waitInput();
                Thread.sleep(time);//１秒待つ
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }

            Console.write("あなたは1ダメージを喰らった!");
            pc.setHp(pc.getHp() - 1);//１ダメージ喰らう

            if (pc.getHp() <= 0) {
                Console.write("あなたは死んだ！");
                vs = false;
                break;
            }

            if (test) {
                Console.write("現在の体力状態: " + pc.getHp());
            } else {
                Console.write("現在の体力状態: " + pc.getAboutHp());
            }

            /*
            Console.write("Please Any key");
            Console.waitInput();
             */
            try {
                //Console.waitInput();
                Thread.sleep(time);//１秒待つ
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Console.write("戦闘終了");
        //Console.write("Press Any Key");
        Console.waitInput();
        return vs;
    }

    public static boolean vsZombie(PlayerCharacter p, int i) {
        finished = true;//終了したら
        vs = true;//戦闘に敗北したらfalseになる,
        ZombieCharacter zc1 = new ZombieCharacter();
        ZombieCharacter zc2 = new ZombieCharacter();
        ZombieCharacter zc3 = new ZombieCharacter();
        int num = i;//書き換えを行うので一応やっとく処理
        int x = 3;
        switch (num) {
            case 1://１体なら
                zc2.damageToZombie(99);//ゾンビ2もいない
                x-=1;
            case 2://２体なら
                zc3.damageToZombie(99);//ゾンビ3はいない
                x-=1;
            
        }
        Console.write("ゾンビが"+x+"体現れた！");
        Console.waitInput();
        Console.write("戦闘開始！");
        while (finished) {
            int[] a = pc.getAttackDamage();//とりあえず帰ってくるのは[]ではない場合の処理

            if (a[1] == 0) {//全体攻撃じゃなければ
                if (zc3.getHp() > 0) {//ゾンビ３が死んでなければ
                    zc3.damageToZombie(a[0]);
                    x = 3;
                } else if (zc2.getHp() > 0) {//ゾンビ2が死んでなければ
                    zc2.damageToZombie(a[0]);
                    x = 2;
                } else if (zc1.getHp() > 0) {//ゾンビ1が死んでなければ
                    zc1.damageToZombie(a[0]);
                    x = 1;
                }
                Console.write("あなたはゾンビ" + x + "に" + a[0] + "ダメージを与えた!");

            } else {//全体攻撃ならば
                zc3.damageToZombie(a[0]);
                zc2.damageToZombie(a[0]);
                zc1.damageToZombie(a[0]);
                Console.write("あなたは" + num + "体に" + a[0] + "ダメージ与えた！");

            }
            try {
                //Console.waitInput();
                Thread.sleep(time);//time/1000秒待つ
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (zc1.getHp() <= 0 && zc2.getHp() <= 0 && zc3.getHp() <= 0) {//ゾンビが0ならば
                Console.write("全ての敵を倒した！");
                //Console.waitInput();
                break;//勝利は初期化されてるので戻る
            }
            num = 0;//生存確認
            if (zc1.getHp() > 0) {
                num++;//ゾンビ1の生存確認
            }
            if (zc2.getHp() > 0) {
                num++;//ゾンビ2の生存確認
            }
            if (zc3.getHp() > 0) {
                num++;//ゾンビ3の生存確認
            }
            Console.write("あなたは" + num + "ダメージを喰らった!");
            pc.setHp(pc.getHp() - num);
            if (pc.getHp() <= 0) {
                Console.write("あなたは死んだ！");
                vs = false;
                break;
            }

            if (test) {
                Console.write("現在の体力状態: " + pc.getHp());
            } else {
                Console.write("現在の体力状態: " + pc.getAboutHp());
            }

            try {
                //Console.waitInput();
                Thread.sleep(time);//time/1000秒待つ
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Console.write("戦闘終了");
        //Console.write("Press Any Key");
        Console.waitInput();
        return vs;
    }

    public static boolean vsBoss(PlayerCharacter p, DaughterCharacter d) {
        BossCharacter bc = new BossCharacter();
        dc = d;
        pc = p;//初期化
        
        vs = true;
        int a, b;
        pc.setRoom(6);//とりあえず置いとくだけのやつ。最悪いらない

        Console.write("ボスが立ちはだかった！");
        Console.waitInput();
        Console.write("戦闘開始!");
        

        while (finished) {
            a = pc.getAttackDamage()[0];
            Console.write("あなたは" + a + "ダメージを与えた！");
            bc.damagedHitPoint(a);//ダメージ処理
            if (bc.getBossHitPoint() <= 0) {//ボスが死んだら
                Console.write("ボスを倒した！");
                break;
            }
            try {
                //Console.waitInput();
                Thread.sleep(time);//.5秒待つ
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }

            b = bc.getBossAttack();//ボスの攻撃力参照
            Console.write("ボスからの攻撃で" + b + "ダメージを喰らった！");
            pc.setHp(pc.getHp() - b);
            if (pc.getHp() <= 0) {
                Console.write("ボスに敗北した...");
                return false;
            }//死んだら
            try {
                //Console.waitInput();
                Thread.sleep(time);//0.5秒待つ
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }
            pc.setNumberOfStep();
            if (dc.daughter_possible_action) {
                if (dc.get_daughterPosition() == 6) {//部屋に入っているかつ移動可能ならば
                    //ここに娘出現時の処理を行う。
                    vs = Battle.vsDaughter(pc, dc);
                } else {
                    //Console.write("アクション");//テスト用
                    dc.move_daughter(pc.getNumberOfStep());//移動処理
                    //娘との接触判定
                    if (dc.get_daughterPosition() == pc.getRoom()) {//娘が部屋に入ってくるか
                        alive = Battle.vsDaughter(pc, dc);//戦闘
                    }
                    if (!alive) {//もし娘に殺された(殺した)なら
                        Console.write("GAME OVER");
                        return false;
                    }                    
                }
                //System.out.println("DT:"+dc.get_hp());
                System.out.println("PC:"+pc.getHp());
            }
            if (test) {
                Console.write("現在の体力状態: " + pc.getHp() );
            } else {
                Console.write("現在の体力状態: " + pc.getAboutHp() );
            }

            try {
                Thread.sleep(time);//time/1000秒待つ
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }
            dc.turn_update();
        }
        Console.write("戦闘終了");
        return vs;
    }

    public static boolean vsDaughter(PlayerCharacter p, DaughterCharacter d) {
        dc = d;
        pc = p;//初期化
        vs = true;
        int attack;
        
        Console.write("    ■                     ■                        ");
        Console.write("    ■                     ■      ■             ■  ■");
        Console.write("    ■                     ■      ■             ■  ■");
        Console.write(" ■■■■  ■■■   ■   ■   ■■■  ■■■■  ■■■■  ■■■  ■ ■ ■  ■");
        Console.write("■■ ■■  ■  ■  ■   ■  ■  ■  ■■  ■  ■   ■  ■  ■■  ■  ■");
        Console.write("■   ■   ■■■  ■   ■  ■  ■  ■   ■  ■   ■   ■ ■   ■  ■");
        Console.write("■   ■ ■■  ■  ■   ■  ■■■   ■   ■  ■   ■■■■■ ■   ■  ■");
        Console.write("■■ ■■ ■   ■  ■  ■■  ■     ■   ■  ■   ■     ■       ");
        Console.write(" ■■■■  ■■■■   ■■ ■  ■■■■■ ■   ■  ■■   ■■■  ■   ■  ■");
        Console.write("                    ■   ■                          ");
        Console.write("                    ■■■■                           ");

        try {
            //Console.waitInput();
            Thread.sleep(time);//１秒待つ
        } catch (InterruptedException ex) {
            Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
        }
        Console.write("出現した娘の攻撃で5ダメージを喰らった!");
        pc.setHp(pc.getHp() - 5);
        
        if (pc.getHp() <= 0) {
            Console.write("娘に殺されてしまった!");
            vs = false;
            return vs;
        }//死んだら
        
        try {
            //Console.waitInput();
            Thread.sleep(time);//１秒待つ
        } catch (InterruptedException ex) {
            Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        attack = pc.getAttackDamage()[0];
        Console.write("あなたの反撃!\n娘に" + attack + "ダメージを与えてしまった!");
        dc.battle_daughter(attack);

        if (dc.get_hp() <= 0) {//娘死んだら
            Console.write("娘を殺してしまった！");
            vs = false;
        }else{
            Console.write("娘は気絶してしまった...");
        }

        pc.clearStep();//主人公の位置を削除
        //Console.write("Press Any Key");
        Console.waitInput();
        return vs;
    }

}
