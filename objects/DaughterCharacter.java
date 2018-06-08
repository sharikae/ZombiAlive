/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiealive;

/**
 *
 * @author C0115222
 */
public class DaughterCharacter {
    int daughterAttack ;
    int daughterHp ;
    int daughterDamage;
    boolean daughter_possible_action ;
    int daughter_impossible_action_turn ;
    int daughterPosition ;
    int attackedTurn;
    
    public DaughterCharacter(){
        daughterAttack = 5;
        daughterHp = 30;
        daughterDamage = 0;
        daughter_possible_action = false;
        daughter_impossible_action_turn = 3;
        daughterPosition = 25;
    }
    
    public int get_hp(){
        return daughterHp;
    }
    
    public int get_daughterPosition(){
        return daughterPosition;
    }
    
    public void turn_update(){
        daughter_impossible_action_turn -= 1;
        if(daughter_impossible_action_turn == 0){
            daughter_possible_action = true;
        }
    }
    
    public void move_daughter(){
        
    }
    
    public int battle_daughter(int playerAttack,int turn){
        daughterDamage = playerAttack;
        daughterHp -= daughterDamage;
        daughter_possible_action = false;
        daughter_impossible_action_turn = 3;
        daughterDamage = 0;
        attackedTurn = turn;
        return daughterHp;
    }
}
