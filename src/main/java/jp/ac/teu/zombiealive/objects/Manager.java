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

        Console.write("\n Press any key ...");
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
}


