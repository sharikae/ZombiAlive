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
    private static long time=500;//ウェイトタイムを修正する際はここで決定

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
        Console.text("ゾンビが現れた！Press Any Key");
        Console.waitInput();
        Console.text("戦闘開始！");
        
        while (finished) {
            int a=pc.getAttackDamage()[0];//とりあえず帰ってくるのは[]ではない場合の処理
            //int a = 2;このままだとダメージが強制的に  2になる
            zc.damageToZombie(a);
            Console.text("あなたは" + a + "ダメージを与えた");
            if (zc.getHp() <= 0) {//ゾンビが0ならば
                Console.text("敵を倒した！");
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

            Console.text("あなたは1ダメージを喰らった!");
            pc.setHp(pc.getHp() - 1);//１ダメージ喰らう

            if (pc.getHp() <= 0) {
                Console.text("あなたは死んだ！");
                vs = false;
                break;
            }

            if (test) {
                Console.text("現在の体力状態: " + pc.getHp());
            } else {
                Console.text("現在の体力状態: " + pc.getAboutHp());
            }

            /*
            Console.text("Please Any key");
            Console.waitInput();
             */
            try {
                //Console.waitInput();
                Thread.sleep(time);//１秒待つ
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Console.text("戦闘終了\nPress Any Key");
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
            case 2://２体なら
                zc3.damageToZombie(99);//ゾンビ3はいない
                x-=1;
            case 1://１体なら
                zc2.damageToZombie(99);//ゾンビ2もいない
                x-=1;
        }
        Console.text("ゾンビが"+x+"体現れた！");
        Console.waitInput();
        Console.text("戦闘開始！");
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
                Console.text("あなたはゾンビ" + x + "に" + a[0] + "ダメージを与えた!");

            } else {//全体攻撃ならば
                zc3.damageToZombie(a[0]);
                zc2.damageToZombie(a[0]);
                zc1.damageToZombie(a[0]);
                Console.text("あなたは" + num + "体に" + a[0] + "ダメージ与えた！");

            }
            try {
                //Console.waitInput();
                Thread.sleep(time);//time/1000秒待つ
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (zc1.getHp() <= 0 && zc2.getHp() <= 0 && zc3.getHp() <= 0) {//ゾンビが0ならば
                Console.text("全ての敵を倒した！");
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
            Console.text("あなたは" + num + "ダメージを喰らった!");
            pc.setHp(pc.getHp() - num);
            if (pc.getHp() <= 0) {
                Console.text("あなたは死んだ！");
                vs = false;
                break;
            }

            if (test) {
                Console.text("現在の体力状態: " + pc.getHp());
            } else {
                Console.text("現在の体力状態: " + pc.getAboutHp());
            }

            try {
                //Console.waitInput();
                Thread.sleep(time);//time/1000秒待つ
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Console.text("戦闘終了");
        Console.text("Press Any Key");
        Console.waitInput();
        return vs;
    }

    public static boolean vsBoss(PlayerCharacter p, DaughterCharacter d) {
        BossCharacter bc = new BossCharacter();
        dc = d;
        pc = p;//初期化
        int turn = 0;
        vs = true;
        int a, b;
        pc.setRoom(6);//とりあえず置いとくだけのやつ。最悪いらない

        Console.text("ボスが立ちはだかった！");
        Console.waitInput();
        Console.text("戦闘開始!");
        

        while (finished) {
            Console.text("現在の状態:" + pc.getAboutHp());
            a = pc.getAttackDamage()[0];
            Console.text("あなたは" + a + "ダメージを与えた！");
            bc.damagedHitPoint(a);//ダメージ処理
            if (bc.getBossHitPoint() <= 0) {//ボスが死んだら
                Console.text("ボスを倒した！");
                break;
            }
            try {
                //Console.waitInput();
                Thread.sleep(time);//.5秒待つ
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }

            b = bc.getBossAttack();//ボスの攻撃力参照
            Console.text("ボスからの攻撃で" + b + "ダメージを喰らった！");
            pc.setHp(pc.getHp() - b);
            if (pc.getHp() <= 0) {
                Console.text("ボスに敗北した...");
                vs = false;
                break;
            }//死んだら
            try {
                //Console.waitInput();
                Thread.sleep(time);//0.5秒待つ
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }
            pc.setNumberOfStep();
            if (dc.get_daughterPosition() == 6 && dc.daughter_possible_action) {//部屋に入っているかつ移動可能ならば
                //ここに娘出現時の処理を行う。
                vs = Battle.vsDaughter(pc, dc);
                dc = Battle.getDc();
                pc = Battle.getPc();
            }else{
                //Console.write("アクション");//テスト用
                dc.move_daughter(pc.getNumberOfStep());//移動処理
                //娘との接触判定
                if (dc.get_daughterPosition() == pc.getRoom()) {//娘が部屋に入ってくるか
                    alive = Battle.vsDaughter(pc, dc);//戦闘
                    pc = Battle.getPc();//主人公の初期化
                    dc = Battle.getDc();//娘の初期化
                }
                if(!alive){//もし娘に殺された(殺した)なら
                    Console.text("GAME OVER");
                    break;
                } 
            }
            if (test) {
                Console.text("現在の体力状態: " + pc.getHp() );
            } else {
                Console.text("現在の体力状態: " + pc.getAboutHp() );
            }

            try {
                Thread.sleep(time);//time/1000秒待つ
            } catch (InterruptedException ex) {
                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
            }
            dc.turn_update();
            turn++;
        }
        Console.text("ボスを倒した。\n戦闘終了");
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

        Console.text("出現した娘の攻撃で5ダメージを喰らった!");
        pc.setHp(pc.getHp() - 5);

        if (pc.getHp() <= 0) {
            Console.text("娘に殺されてしまった!");
            vs = false;
            return vs;
        }//死んだら

        attack = pc.getAttackDamage()[0];
        Console.text("あなたの反撃!\n娘に" + attack + "ダメージを与えてしまった!");
        dc.battle_daughter(attack);

        if (dc.get_hp() <= 0) {//娘死んだら
            Console.text("娘を殺してしまった！");
            vs = false;
        }else{
            Console.text("娘は気絶してしまった...");
        }

        pc.clearStep();//主人公の位置を削除
        Console.text("Press Any Key");
        Console.waitInput();
        return vs;
    }

}
