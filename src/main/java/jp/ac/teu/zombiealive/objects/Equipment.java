/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.teu.zombiealive.objects;

import jp.ac.teu.zombiealive.util.Console;

/**
 *
 * @author C0116125
 */
public class Equipment {

    private PlayerCharacter pc;

    public Equipment(PlayerCharacter p) {
        pc = p;
    }

    public PlayerCharacter getEqu(int weaponNo) {
        switch (weaponNo) {
            case 1: // ハンドガン
                System.out.print("ハンドガン(ATK:1-6,単体)");
                break;
            case 2: // ショットガン
                System.out.print("ショットガン(ATK:1-10,単体)");
                break;
            case 3: // マシンガン
                System.out.print("マシンガン(ATK:1-3,全体)");
                break;
            case 4: // グレネードランチャー
                System.out.print("グレネードランチャー(ATK:1-6,全体)");
                break;
            case 5: // ロケットランチャー
                System.out.print("ロケットランチャー(ATK:1-10,全体)");
                break;
        }

        System.out.println("がある。\n装備しますか?\n(装備する場合はY)");

        if ("y".equals(Console.read())) {
            System.out.println("装備しました");
            pc.setWeapon(weaponNo);
        } else {
            System.out.println("ドロップした武器を放棄しました");
        }

        System.out.println("Please Any key");
        Console.waitInput();
        return pc;
    }
}
