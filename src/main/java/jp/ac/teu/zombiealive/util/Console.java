package jp.ac.teu.zombiealive.util;

import java.io.IOException;
import java.util.Scanner;

import jp.ac.teu.zombiealive.ZombieAlive;
import jp.ac.teu.zombiealive.objects.*;

/**
 * @author C0116221 Shota Harikae
 */
public class Console {

    public static String read() {
        Console.writeNoCR("> ");
        String inputKeyCode = "";
        Scanner scan = new Scanner(System.in);
        inputKeyCode = scan.next();
        return inputKeyCode.toLowerCase();
    }

    public static void write(String text) {
        System.out.println(text);
        
    }

    public static void text(String text) {
        Room.mapRoom();
        Manager.displayStatus(PlayerCharacter.getWeapon(), PlayerCharacter.getAboutHp());
        Console.write("####### Message #################################################################################");
        Console.write("                                                                                                 ");
        Console.write(text);
        Console.write("                                                                                                 ");
        Console.write("#################################################################################################");
    }

    public static void writeNoCR(String text) {
        System.out.print(text);
    }
    
    public static void writeClosed(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("◆");
        }
        System.out.println("");
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException exception) {
            System.out.println("InterruptedException 例外");
        }
    }

    public static void waitInput() {
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }
}
