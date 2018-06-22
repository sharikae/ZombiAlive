/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.teu.zombiealive;

import jp.ac.teu.zombiealive.objects.Battle;
import jp.ac.teu.zombiealive.objects.DaughterCharacter;
import jp.ac.teu.zombiealive.objects.Dungeon;
import jp.ac.teu.zombiealive.objects.Manager;
import jp.ac.teu.zombiealive.objects.PlayerCharacter;
import jp.ac.teu.zombiealive.objects.Room;
import jp.ac.teu.zombiealive.util.Console;

/**
 *
 * @author C0116125
 */
public class BattleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        PlayerCharacter pc = new PlayerCharacter();         // プレイヤー変数の初期化
        DaughterCharacter dc = new DaughterCharacter();     // 娘変数の初期化
        Manager mng = new Manager();
        int i = 0;//戦闘回数

        boolean k = true;//初期テスト用
        boolean test = true;
        while (k) {//テスト終了まで持続            
            System.out.println("武器選択を行います。");
            System.out.print("素手：0,　");
            System.out.print("ハンドガン：1,　");
            System.out.print("ショットガン:2,　");
            System.out.print("マシンガン：3,　");
            System.out.print("グレネードランチャー：4,　");
            System.out.println("ロケットランチャー:5　を半角で入力してください");

            while (test) {
                switch (Integer.parseInt(Console.read())) {
                    case 0: // 素手
                        System.out.println("素手に変更しました");
                        pc.setWeapon(0);
                        test = false;
                        break;
                    case 1: // ハンドガン
                        System.out.println("ハンドガンに変更しました");
                        pc.setWeapon(1);
                        test = false;
                        break;
                    case 2: // ショットガン
                        System.out.println("ショットガンに変更しました");
                        pc.setWeapon(2);
                        test = false;
                        break;
                    case 3: // マシンガン
                        System.out.println("マシンガンに変更しました");
                        pc.setWeapon(3);
                        test = false;
                        break;
                    case 4: // グレネードランチャー
                        System.out.println("グレネードランチャーに変更しました");
                        pc.setWeapon(4);
                        test = false;
                        break;
                    case 5: // ロケットランチャー
                        System.out.println("ロケットランチャーに変更しました");
                        pc.setWeapon(5);
                        test = false;
                        break;
                    default:
                        System.out.println("その数字は使用できません");
                }
            }
            test = true;

            Battle b = new Battle(pc);
            System.out.println("zombieとの戦闘を行う場合は1-3でzombieの数を選択してください");
            System.out.println("Bossとの戦闘を行う場合には1-3以外の数字を半角で入力してください");
            int x = Integer.parseInt(Console.read());
            if (x == 1) {//1体だけなら
                k = Battle.vsZombie(pc);
            } else if (x > 1 && x < 4) {//1~3でゾンビの数指定
                k = Battle.vsZombie(pc, x);
            } else {//boss戦闘処理テスト
                dc.setDaughterPosition(6);;//今回限定の処理
                k = Battle.vsBoss(pc, dc);
            }//戦闘処理

            pc = Battle.getPc();//PCのデータを戻す
            i++;//ターン経過
            System.out.println("pcHP:" + pc.getHp());
            System.out.println("現在戦闘回数;" + i);
        }
    }

}
