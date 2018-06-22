package jp.ac.teu.zombiealive.util;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author C0116221 Shota Harikae
 */

public class Console {

    public static String read() {
        Console.writeNoCR("> ");
        Scanner scan = new Scanner(System.in);
        String inputKeyCode="";
        inputKeyCode = scan.next();
        return inputKeyCode;
    }

    public static void write(String text) {
        System.out.println(text);
    }

    public static void writeNoCR(String text) {
        System.out.print(text);
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException exception) {
            System.out.println("InterruptedException 例外");
        }
    }
}
