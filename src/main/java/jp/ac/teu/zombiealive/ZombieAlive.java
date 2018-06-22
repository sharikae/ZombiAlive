package jp.ac.teu.zombiealive;

import java.util.Scanner;
import jp.ac.teu.zombiealive.objects.Battle;

import jp.ac.teu.zombiealive.objects.Dungeon;
import jp.ac.teu.zombiealive.objects.PlayerCharacter;
import jp.ac.teu.zombiealive.objects.Room;
import jp.ac.teu.zombiealive.objects.BossCharacter;
import jp.ac.teu.zombiealive.objects.DaughterCharacter;

import jp.ac.teu.zombiealive.objects.Manager;
import jp.ac.teu.zombiealive.util.Console;
import jp.ac.teu.zombiealive.util.Timer;

/**
 * @author C0116125
 */

public class ZombieAlive {

    public static int turn = 0;                   // 全体ターン数
    public static int x = 7;
    public static int y = 4;                      // プレイヤーのX,Y軸初期位置(たぶん25番部屋のはず)
    public static int xd = 0, yd = 0;             // プレイヤーが移動する向き
    public static String st;                      // 方向の受け皿
    public static boolean alive = true;           // ゲームオーバーならfalse
    public static boolean error = false;          // 問題があるならtrue
    public static boolean Moved = true;

    public static void main(String[] args) {

        Manager mng = new Manager();
        Dungeon dn = new Dungeon();                         // ダンジョンの初期化
        Room rm = new Room(0);                      // 部屋クラスの初期化
        PlayerCharacter pc = new PlayerCharacter();         // プレイヤー変数の初期化
        DaughterCharacter dc = new DaughterCharacter();     // 娘変数の初期化
        Timer tm = new Timer();                             //タイマークラスの呼び出し

        mng.displayIntroduction();                          // 説明文出力
        Console.read();                                     // Press any key

        // TODO Timer logic here

        //ゲーム終了までループ
        while (alive) {
            /* ステータス表示 */
            mng.restWindow();                               // 画面クリア
            mng.displayStatus(                              // ステータス表示
                    pc.getRoom(),
                    pc.getAboutHp()
            );

            /* プレイヤー移動 */
            do {
                Moved = pc.move();
            } while (!Moved);


            /* 室内調査 */
            // TODO Room check logic
            /*
                ゾンビがいるか
                回復アイテムがあるか
                鍵部屋か
                ボス部屋か
             */

            // TODO battle logic
            if(rm.getZombieNum(pc.getRoom())>0){//ゾンビが居たら(0以上なら)
               if(rm.getZombieNum(pc.getRoom())>1){//ゾンビが2体以上居たら
                   alive=Battle.vsZombie(pc, x);//複数ゾンビ用の処理
               }else{//ゾンビが1体ならば
                   alive=Battle.vsZombie(pc);//ゾンビ1体用の処理
               } 
               pc=Battle.getPc();//戦闘終了処理
            }
            // TODO battle boss logic
            if (pc.getRoom()==6) {//ボス部屋ならば
                alive=Battle.vsBoss(pc, dc);//ボス戦闘の開始
                if (alive) {//ボス戦闘に勝利したら
                    //エンディング処理
                    System.out.println("Game ｸﾘｱｧ");
                }
            }
            // TODO recovery logic

            // TODO Daughter logic

            turn++;
        }
    }
}