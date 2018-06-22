package jp.ac.teu.zombiealive.objects;

import jp.ac.teu.zombiealive.ZombieAlive;
import jp.ac.teu.zombiealive.util.Console;

/**
 * @author C0116221 Shota Harikae
 */

public class Manager {
    public void displayIntroduction() {
        Console.write("                         ■                                         ");
        Console.write(" ■■■■■                   ■      ■             ■    ■  ■            ");
        Console.write("     ■                   ■                    ■    ■               ");
        Console.write("    ■    ■■■   ■■■ ■■■   ■■■■   ■   ■■■      ■ ■   ■  ■ ■   ■  ■■■ ");
        Console.write("   ■    ■■ ■■  ■  ■■  ■  ■■ ■■  ■  ■  ■      ■ ■   ■  ■  ■  ■ ■  ■ ");
        Console.write("  ■■    ■   ■  ■  ■   ■  ■   ■  ■  ■   ■    ■   ■  ■  ■  ■ ■  ■   ■");
        Console.write("  ■     ■   ■  ■  ■   ■  ■   ■  ■  ■■■■■    ■■■■■  ■  ■  ■ ■  ■■■■■");
        Console.write(" ■      ■■ ■■  ■  ■   ■  ■■ ■■  ■  ■        ■   ■  ■  ■   ■■  ■    ");
        Console.write("■■■■■■■  ■■■   ■  ■   ■  ■■■■   ■   ■■■    ■     ■ ■  ■   ■    ■■■ ");

        Console.write("\n                   ■ Press any key to Start ■ ");
        Console.write("                           1.Help");
    }

    public void displayHelp() {
        Console.write("ターン制\n" +
                "１５分以内にクリアしなければ死亡\n" +
                "（１移動あたり１ターン）\n" +
                "３ターン後に娘が追いかけてくる\n" +
                "戦闘時はランダム攻撃\n" +
                "通常ゾンビのHPは６\n" +
                "ゾンビが武器をドロップするかも\n" +
                "戦わないで１部屋戻れる\n" +
                "自分のHPが半分になった時と瀕死のときに警告\n" +
                "素手のダメージは1-3\n" +
                "娘とエンカウントした場合、娘からのダメージと娘へのダメージが入る\n" +
                "武器は交換式");
    }

    public void displayStatus(int roomNum, String aboutHp) {
        Console.write("現在の部屋番号: " + roomNum);
        Console.write("現在の体力状態: " + aboutHp);
    }

    public void restWindow() {
        for (int i = 0; i < 30; i++) {
            Console.write("");
        }
    }

    public void displayRoom(int roomNum) {

    }
}


