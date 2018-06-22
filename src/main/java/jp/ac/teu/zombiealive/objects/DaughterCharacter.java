package jp.ac.teu.zombiealive.objects;

import java.util.Queue;
import jp.ac.teu.zombiealive.util.Console;

/**
 * @author C0115222
 */
public class DaughterCharacter {

    int daughterAttack;    //娘の攻撃力
    int daughterHp;    //娘のHP
    boolean daughter_possible_action;  //娘の行動可能フラグ
    int daughter_impossible_action_turn;   //娘の行動不能ターン数
    int daughterPosition;  //娘のいる部屋番号
    int numberOfStep = 0;   //プレイヤーの歩数番号

    public DaughterCharacter() { //娘の持つメンバの初期化
        daughterAttack = 5;
        daughterHp = 30;
        daughter_possible_action = false;
        daughter_impossible_action_turn = 3;
        daughterPosition = 25;
    }

    public int get_hp() {    //娘のHPを返す
        return daughterHp;
    }

    public int get_daughterPosition() {  //娘の位置を返す
        return daughterPosition;
    }

    public boolean isDaughter_possible_action() {//娘が移動可能かを返す(移動可能の場合true)
        return daughter_possible_action;
    }

    public void turn_update() {  //行動可能までのターンが経っているかの判定
        if (daughter_possible_action == false) {
            daughter_impossible_action_turn -= 1;
            if (daughter_impossible_action_turn == 0) {
                daughter_possible_action = true;
                System.out.println("娘の叫び声が聞こえた");
                Console.read();
            }
        }
    }

    public void battle_daughter(int playerAttack) {  //娘のHP処理
        daughterHp -= playerAttack;
        daughter_possible_action = false;
        daughter_impossible_action_turn = 3;
    }

    public void move_daughter(int pOS) {  //娘の移動処理
        if (daughter_possible_action == true) {
            daughterPosition = pOS;
        } 
    }
    
    public void setDaughterPosition(int daughterPosition){//娘の現在位置を変更
        this.daughterPosition = daughterPosition;
    }

}
