package jp.ac.teu.zombiealive.objects;

import java.util.Queue;

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

    public void turn_update() {  //行動可能までのターンが経っているかの判定
        if (daughter_possible_action == false) {
            daughter_impossible_action_turn -= 1;
            if (daughter_impossible_action_turn == 0) {
                daughter_possible_action = true;
            }
        }
    }

    public void battle_daughter(int playerAttack) {  //娘のHP処理
        daughterHp -= playerAttack;
        daughter_possible_action = false;
        daughter_impossible_action_turn = 3;
    }

    public void move_daughter(Queue<Integer> playerOfStep) {  //娘の移動処理
        if (daughter_possible_action == true) {
            daughterPosition = playerOfStep.poll();
        } else {
            playerOfStep.poll();
        }
    }
    
}
