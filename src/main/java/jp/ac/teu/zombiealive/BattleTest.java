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
        int i=0;//戦闘回数
        
        boolean k=true;//初期テスト用
        while (k) {//テスト終了まで持続            
            System.out.println("武器選択");
            switch (Integer.parseInt(Console.read())) {
            case 0: // 素手
                System.out.print("素手");
                pc.setWeapon(0);
                break;
            case 1: // ハンドガン
                System.out.print("ハンドガン");
                pc.setWeapon(1);
                break;
            case 2: // ショットガン
                System.out.print("ショットガン");
                pc.setWeapon(2);
                break;
            case 3: // マシンガン
                System.out.print("マシンガン");
                pc.setWeapon(3);
                break;
            case 4: // グレネードランチャー
                System.out.print("グレネードランチャー");
                pc.setWeapon(4);
                break;
            case 5: // ロケットランチャー
                System.out.print("ロケットランチャー");
                pc.setWeapon(5);
                break;
            }
            System.out.println("に変更しました。");
            Battle b=new Battle(pc);
            k = Battle.vsZombie(pc, 3);//戦闘処理
            pc=Battle.getPc();//PCのデータを戻す
            i++;//ターン経過
            System.out.println("pcHP:"+pc.getHp());
            System.out.println("現在ターン数;"+i);
        }
    }
    
}
