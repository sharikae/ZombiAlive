/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiealive;

/**
 *
 * @author C0116086
 */
public class Room {
 
        boolean zombie;
        boolean player;
        boolean key;
        boolean item;
        boolean daughter;
        boolean north;
        boolean west;
        boolean south;
        boolean east;
        int zombieNum = 0;
        
        Room(){
            int x=0;
            while(x<25){//25部屋の初期化
                zombieLocator();
                Inventory();
                Daughter();
                nextMove();
                x++;
            }
        }
        
        private void zombieLocator(){
            
        if(zombie=true){
            zombieNum +=1;
            System.out.println(zombieNum+" Zombies found!");
        }else{
            System.out.println("No Zombies.");
            }
        }
        
        private void Inventory(){
        if(key=true){
            System.out.println("You have a key.");
        }else{
            System.out.println("You don't have a key.");
            }
        
        if(item=true){
            System.out.println("You have an Item.");
        }else{
            System.out.println("You don't have an Item.");
            }
        }
        
        private void Daughter(){
        if(daughter=true){
            System.out.println("a daughter is here.");
        }else{
            System.out.println("No daughter here.");
            }
        }
        
        private void nextMove(){
        if(north=true){
            //Move to Northの処理
        }else if(west=true){
            //Movie to Westの処理
        }else if(south=true){
            //Move to Southの処理
        }else if(east=true){
            //Move to Eastの処理
            }
        }
    }
