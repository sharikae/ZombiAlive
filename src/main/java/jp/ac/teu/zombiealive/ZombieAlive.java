package jp.ac.teu.zombiealive;

import java.util.Scanner;
import jp.ac.teu.zombiealive.objects.Battle;

import jp.ac.teu.zombiealive.objects.Dungeon;
import jp.ac.teu.zombiealive.objects.PlayerCharacter;
import jp.ac.teu.zombiealive.objects.Room;
import jp.ac.teu.zombiealive.objects.BossCharacter;
import jp.ac.teu.zombiealive.objects.DaughterCharacter;
import jp.ac.teu.zombiealive.objects.Equipment;

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
        Room rm = new Room();                      // 部屋クラスの初期化
        PlayerCharacter pc = new PlayerCharacter();         // プレイヤー変数の初期化
        DaughterCharacter dc = new DaughterCharacter();     // 娘変数の初期化
        Timer tm = new Timer();
        tm.getTimer();
        mng.displayIntroduction();                          // 説明文出力
        Console.read();                                     // Press any key

        // TODO Timer logic here
        //ゲーム終了までループ
        while (alive) {
            /* ステータス表示 */
            mng.restWindow();                               // 画面クリア
            mng.displayStatus( // ステータス表示
                    Dungeon.getDungeon(pc.getXPosition(), pc.getYPosition()),
                    pc.getAboutHp()
            );

            /* プレイヤー移動 */
            do {
                Moved = pc.move();
            } while (!Moved);
            
            //ゾンビ戦闘判定
            x=rm.getZombieNum(pc.getRoom());
            if (x > 0) {//ゾンビが存在するならば
                if (x > 1) {//ゾンビが1体より多いならば
                    alive = Battle.vsZombie(pc, x);//複数処理
                } else {
                    alive = Battle.vsZombie(pc);//単体用
                }
                pc = Battle.getPc();//戦闘終了処理
                rm.setZombieNum(pc.getRoom());//ルーム番号処理
                //武器ドロップ判定処理
                if(0>0){//武器があるなら
                    Equipment e=new Equipment();
                }
            }

            //ボス部屋判定
            if (pc.getRoom() == 6) {
                alive = Battle.vsBoss(pc, dc);
                if (alive) {
                    System.out.println("GAME ｸﾘｱｧ");
                }
            }

            if (rm.getItem(Dungeon.getDungeon(pc.getXPosition(), pc.getYPosition()))) {
                Console.write("回復アイテムを見つけました。使用するならUを入力してください");
                if ("u".equals(Console.read())) {
                    pc.setHp(30);
                    rm.setItem(Dungeon.getDungeon(pc.getXPosition(), pc.getYPosition()));
                }
            }

            /* 室内調査 */
            // TODO Room check logic
            /*
                ゾンビがいるか
                回復アイテムがあるか
                鍵部屋か
                ボス部屋か
             */
            // TODO battle logic
            // TODO battle boss logic
            // TODO recovery logic
            // TODO Daughter logic
            turn++;
        }
    }
}
