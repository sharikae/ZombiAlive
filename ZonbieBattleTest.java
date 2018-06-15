/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiealive;

import java.util.Scanner;
import javafx.scene.transform.Scale;

/**
 *
 * @author C0116125
 */
public class ZonbieBattleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PlayerCharacter pc = new PlayerCharacter();//プレイヤー変数の初期化
        System.out.println("Playerの初期化確認");
        System.out.println("HPの状態："+pc.getAboutHp());
        System.out.println("HPの値："+pc.getHp());
        System.out.println("所持武器番号"+ pc.getWeapon());
        
        DaughterCharacter dc = new DaughterCharacter();//娘変数の初期化
        System.out.println("Daughterの初期化確認");
        System.out.println("HPの値："+dc.get_hp());
        
        BossCharacter bc = new BossCharacter();
        System.out.println("Bossの初期化確認");
        System.out.println("BossのHP:"+ bc.getBossHitPoint());
        
        ZombieCharacter zc = new ZombieCharacter();
        System.out.println("Zombieの初期化確認");
        System.out.println("ゾンビのHP:"+zc.getHp());
        
        System.out.println("武器番号の指定\n"
                + "0:素手\n"
                + "1:");
        String str;
        Scanner s = new Scanner(System.in);//これでキーを指定
        str=s.next();
        switch(Integer.parseInt(str)){
            case 0: // 素手
                pc.setWeapon(0);
                break;
            case 1: // ハンドガン
                pc.setWeapon(1);
                break;
            case 2: // ショットガン
                pc.setWeapon(2);
                break;
            case 3: // マシンガン
                pc.setWeapon(3);
                break;
            case 4: // グレネードランチャー
                pc.setWeapon(4);
                break;
            case 5: // ロケットランチャー
                pc.setWeapon(5);
                break;
            default:
                System.out.println("戦闘を開始します。");
        }
        System.out.println("戦闘形式の選択\n"
                + "0:Daughter\n"
                + "1:Zombie*1\n"
                + "2:Zombie*2\n"
                + "3:Zombie*3\n"
                + "Another:Boss\n");
        str=s.next();
        if (str=="0") {
            dc.battle_daughter(0);
        }else if (Integer.parseInt(str)>0&&Integer.parseInt(str)<4) {
            for (int i = 0; i < Integer.parseInt(str); i++) {
                //ここにゾンビ変数の初期化を置く？
            }
            
        }else
        
        
    }
    
}
