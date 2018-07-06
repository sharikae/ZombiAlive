package jp.ac.teu.zombiealive.objects;
import jp.ac.teu.zombiealive.ZombieAlive;
import jp.ac.teu.zombiealive.objects.ZombieCharacter;
import jp.ac.teu.zombiealive.util.Console;

/**
 * @author C0116221 Shota Harikae
 */
public class Manager {

    public static void displayIntroduction() {
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

    public static void displayZombie() {
        Console.write("");
        Console.write(
                "                     ■■                   \n"
                + "                      ■      ■        ■  ■\n"
                + "                      ■               ■  ■\n"
                + "■■■■■  ■■■  ■■■■ ■■■  ■■■■   ■   ■■■  ■  ■\n"
                + "■  ■  ■  ■■ ■■ ■■  ■  ■■  ■  ■  ■  ■  ■  ■\n"
                + "  ■■ ■■   ■ ■   ■  ■  ■   ■  ■ ■■■■■  ■  ■\n"
                + "  ■  ■■   ■ ■   ■  ■  ■   ■  ■ ■■         \n"
                + " ■  ■ ■  ■■ ■   ■  ■  ■   ■  ■  ■         \n"
                + "■■■■■  ■■■  ■■ ■■■■■■■■■■■  ■■■  ■■■  ■  ■\n");
    }

    public static void displayGameOver() {
        Console.write("");
        Console.write(""
                + "   ■■■■    ■    ■■■    ■■■ ■■■■■ \n"
                + " ■■   ■    ■■    ■■    ■■  ■■  ■■\n"
                + " ■        ■■■    ■■■   ■■  ■■    \n"
                + "■■        ■ ■    ■ ■  ■ ■  ■■■■  \n"
                + "■■   ■■■  ■ ■■   ■ ■  ■ ■  ■■ ■  \n"
                + " ■    ■  ■■■■■   ■  ■■  ■  ■■    \n"
                + " ■■   ■  ■   ■■  ■  ■■  ■  ■■   ■\n"
                + "  ■■■■■ ■■■ ■■■■■■■ ■■ ■■■ ■■■■■■\n"
                + "                                                             \n"
                + "  ■■■■  ■■■  ■■■ ■■■■■  ■■■■■    \n"
                + " ■■   ■  ■■   ■  ■■  ■■ ■■  ■■   \n"
                + " ■    ■   ■  ■   ■■     ■■  ■■   \n"
                + "■■    ■■  ■  ■   ■■■■   ■■  ■    \n"
                + "■■    ■■  ■■ ■   ■■ ■   ■■■■■    \n"
                + " ■    ■    ■■    ■■     ■■  ■    \n"
                + " ■■   ■    ■■    ■■   ■ ■■  ■    \n"
                + "  ■■■■     ■     ■■■■■■ ■■■ ■■   \n");
    }
    public void displayGameClear() {
        Console.write("");
        Console.write(
                "   ■■■■    ■    ■■■    ■■■ ■■■■■    \n"
                + " ■■   ■    ■■    ■■    ■■  ■■  ■■   \n"
                + " ■        ■■■    ■■■   ■■  ■■       \n"
                + "■■        ■ ■    ■ ■  ■ ■  ■■■■     \n"
                + "■■   ■■■  ■ ■■   ■ ■  ■ ■  ■■ ■     \n"
                + " ■    ■  ■■■■■   ■  ■■  ■  ■■       \n"
                + " ■■   ■  ■   ■■  ■  ■■  ■  ■■   ■   \n"
                + "  ■■■■■ ■■■ ■■■■■■■ ■■ ■■■ ■■■■■■   \n"
                + "                                    \n"
                + "   ■■■■ ■■■    ■■■■■    ■     ■■■■■ \n"
                + " ■■   ■ ■■     ■■  ■■   ■■    ■■  ■■\n"
                + " ■      ■■     ■■      ■■■    ■■  ■■\n"
                + "■■      ■■     ■■■■    ■ ■    ■■  ■ \n"
                + "■■      ■■     ■■ ■    ■ ■■   ■■■■■ \n"
                + " ■      ■■     ■■     ■■■■■   ■■  ■ \n"
                + " ■■   ■ ■■  ■■ ■■   ■ ■   ■■  ■■  ■ \n"
                + "  ■■■■■ ■■■■■  ■■■■■■■■■ ■■■■ ■■■ ■■");
    }

    public static void displayHelp() {
        Console.write("========== 操作方法 ==========\n"
                + "移動： W↑ A← S↓ D→\n"
                + "Press any key： なにか文字を入力してEnter\n\n"
                + "========== ルール ==========\n"
                + "１５分以内にダンジョン内を探索し、奥地にある研究者を倒してワクチンを入手せよ\n"
                + "３ターン後には、ゾンビ化した娘が追いかけてくる\n"
                + "戦闘時はランダム攻撃だ\n"
                + "通常ゾンビのHPは６\n"
                + "ゾンビが武器をドロップする\n"
                + "自分のHPの細かい表示はない。状況を判断して回復せよ\n"
                + "素手のダメージは1-3\n"
                + "娘とエンカウントした場合、娘からのダメージと娘へのダメージが入ってしまう\n"
                + "武器は交換式だ\n\n"
                + "========== 勝利条件 ==========\n"
                + "ワクチンの入手\n"
                + "========== 敗北条件 ==========\n"
                + "自分のHPが0になる\n"
                + "時間切れになる\n"
                + "娘を死なせてしまう");

    }

    public static void displayStatus(int weapon, String aboutHp) {
        Console.writeNoCR("現在の所持武器: ");
        switch (weapon) {
            case 0: // 素手
                Console.write("素手");
                break;
            case 1: // ハンドガン
                Console.write("ハンドガン");
                break;
            case 2: // ショットガン
                Console.write("ショットガン");
                break;
            case 3: // マシンガン
                Console.write("マシンガン");
                break;
            case 4: // グレネードランチャー
                Console.write("グレネードランチャー");
                break;
            case 5: // ロケットランチャー
                Console.write("ロケットランチャー");
                break;
        }
        Console.write("現在の体力状態: " + aboutHp);
    }

    public static void restWindow() {
        for (int i = 0; i < 30; i++) {
            Console.write("");
        }
    }

    public static void displayScore() {
        Console.write("========== RESULT ==========\n");
        Console.write("CLEAR TIME: ");
        Console.write("KILLED ZOMBIE: "+ZombieCharacter.getKill());
        Console.write("TOTAL SCORE: " +ZombieCharacter.getKill()*100+1000);
    }
}
