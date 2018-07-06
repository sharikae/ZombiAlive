package jp.ac.teu.zombiealive;

import jp.ac.teu.zombiealive.objects.Battle;

import jp.ac.teu.zombiealive.objects.Dungeon;
import jp.ac.teu.zombiealive.objects.PlayerCharacter;
import jp.ac.teu.zombiealive.objects.Room;
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

        mng.displayIntroduction();                          // タイトル出力
        if (Console.read().equals("1")) {
            mng.displayHelp();                             // ルール表示
            Console.waitInput();                           // Press any key
        }

        Timer tm = new Timer();     //Timerの初期化

        //ゲーム終了までループ
        while (alive) {

            if (tm.getTimer()) {
                Console.text("TIME UP!! \n zombie virusに侵食されてしまった！");
                break;
            }

            /* ステータス表示 */
            Manager.restWindow();  // 画面クリア
            Room.mapRoom();
            Manager.displayStatus( // ステータス表示
                    PlayerCharacter.getWeapon(),
                    PlayerCharacter.getAboutHp()
            );

            //プレイヤー移動 
            do {
                rm.resetPlayerMapRoom(pc.getRoom());
                Moved = pc.move(rm.getRoom());
            } while (!Moved);
            rm.setPlayerMapRoom(pc.getRoom());
            rm.setMapRoom(pc.getRoom());

            //ゾンビ戦闘判定
            int num = rm.getZombieNum(pc.getRoom());
            if (num > 0) {//ゾンビが存在するならば
                mng.restWindow();
                rm.mapRoom();
                mng.displayZombie();
                if (num > 1) {//ゾンビが1体より多いならば
                    alive = Battle.vsZombie(pc, num);//複数処理
                } else {
                    alive = Battle.vsZombie(pc);//単体用
                }

                pc = Battle.getPc();//戦闘終了処理
                rm.setZombieNum(pc.getRoom());//ルーム番号処理
                rm.resetMapRoom(pc.getRoom());

                //武器ドロップ判定処理
                int weaponNo = 0;
                switch (pc.getRoom()) {
                    case 14:
                        weaponNo = 1;
                        break;
                    case 16:
                        weaponNo = 2;
                        break;
                    case 2:
                        weaponNo = 3;
                        break;
                    case 4:
                        weaponNo = 4;
                        break;
                    case 13:
                        weaponNo = 5;
                        break;
                }

                if (weaponNo > 0) {//武器があるなら
                    Equipment e = new Equipment(pc);
                    pc = e.getEqu(weaponNo);//武器を装備するか判定処理
                }
            }

            //ボス部屋判定
            if (pc.getRoom() == 6) {
                mng.restWindow();
                Console.text("鍵を使用しました");
                alive = Battle.vsBoss(pc, dc);
                if (alive) {
                    mng.displayGameClear();
                    break;
                }else{//この処理を入れないと娘にもう一度殺される
                    dc=Battle.getDc();
                }
                
            }

            if (rm.getItem(pc.getRoom())) {
                rm.mapRoom();
                Console.text("救急箱を見つけました。使用するならyを入力してください");
                if ("y".equals(Console.read())) {
                    pc.setHp(30);
                    rm.setItem(pc.getRoom());
                    rm.resetMapRoom(pc.getRoom());
                    Console.text("救急箱を使用し、HPが回復しました");
                    Console.waitInput();
                }else{
                    Console.text("使用しませんでした。");
                    Console.waitInput();
                }
            }

            if (rm.getKey(pc.getRoom())) {//現在部屋に鍵があるか
                Console.text("鍵が落ちている･･･\nとりあえず取っておこう");
                pc.setKey(true);//鍵を手に入れる処理
                rm.setKey(pc.getRoom());//鍵が無くなる処理
                Console.waitInput();
            }

            //現在の位置を記憶
            pc.setNumberOfStep();//主人公の現在位置を記憶

            // TODO Daughter logic
            if (dc.isDaughter_possible_action()) {//娘が移動可能の場合
                //娘との接触判定
                if (dc.get_daughterPosition() == pc.getRoom()) {//娘が部屋に入っているか
                    alive = Battle.vsDaughter(pc, dc);//戦闘
                    pc = Battle.getPc();//主人公の戦闘後処理
                    dc = Battle.getDc();//娘の戦闘後処理

                } else {//戦闘しなければ
                    //娘の移動処理
                    dc.move_daughter(pc.getNumberOfStep());//移動処理

                    //娘との接触判定
                    if (dc.get_daughterPosition() == pc.getRoom()) {//娘が部屋に入ってくるか
                        alive = Battle.vsDaughter(pc, dc);//戦闘
                        pc = Battle.getPc();//主人公の初期化
                        dc = Battle.getDc();//娘の初期化
                    }

                }

            } else {
                dc.turn_update();//娘の復活処理
            }

            if (!alive) {
                mng.displayGameOver();
            }

            turn++;

        }
        if (alive) {//生存でクリアした場合スコア出力
            mng.displayScore(tm.getClearTimer(),pc.getHp(),dc.get_hp());//現在はKill数のみ指定。
        }
    }
}
