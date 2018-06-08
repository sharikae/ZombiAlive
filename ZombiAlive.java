/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombialive;

import java.util.Scanner;
import zombialive.Dungeon;

/**
 *
 * @author C0116125
 */
public class ZombiAlive {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //初期化----------------------------------
        int turn=0;//全体ターン数
        Dungeon dn=new Dungeon();//ダンジョンの初期化(呼び出すだけ)
        //Room rm = new Room();
        PlayerCharacter pc=new PlayerCharacter();//プレイヤー変数の初期化
        //DaughterCharacter dc= new DaughterCharacter();//娘変数の初期化
        //Timer tm=new Timer();//タイマークラスの呼び出し。仮置き
        int x = 0,y = 0;//プレイヤーのX,Y軸
        int xd=0,yd=0;//プレイヤーが移動する向き
        String st;//方向の受け皿
        boolean gameover=false;
        boolean error=false;

        Scanner s = new Scanner(System.in);//これでキーを指定
        //説明文の出力------------------------------------------
        
        //ボタンが押されたらスタート

        s.next();
        
        //Timerのスタート
        
        //ゲーム終了までループする文
        do{
            //部屋情報の表示(行ける部屋方向に矢印を出力)
            
            //移動方向の入力(if文でその向きが行ける部屋方向かを指定
            do{
                System.out.print("");
                st=s.next();//文字入力
                switch(st){
                    case"w"://上
                        yd--;
                        break;
                    case"a"://左
                        xd--;
                        break;
                    case"s"://下
                        yd++;
                        break;
                    case"d"://右
                        xd++;
                        break;
                    default://それ以外が打たれたら
                        
                        break;
                }
                if(x+xd<0||x+xd>8||y+yd<0||y+yd>8){//行く方向が不正か？
                    //不正の場合の処理
                }else{
                    //不正じゃない場合の処理
                }
            }while(0==0);//向きが正しくない場合はループ
            
            //覗くかの選択
            if(0==0){//覗く
                //次の部屋情報の出力
                
                
            }else{//覗かない
                //プレイヤーの移動処理
                
                //移動先にゾンビが居るか
                //(移動先の部屋番号にゾンビが存在するか)
                if(0==0){//ゾンビが居る時の処理
                    do{
                    
                    }while(0==0);//戦闘終了処理が行われた場合
                }else if(0==0){//key部屋の場合の処理
                    
                }else if(0==0){//回復部屋か
                    
                }else if(0==0){//boss部屋か
                    //boss部屋の処理をここに書く。
                }
            }
            //娘の処理
            if(0==0){//娘が移動可能か
                if(0==0){//プレイヤーの移動先(現在の部屋)に娘が居るか。
                    //現在の部屋に娘が居る時の処理
                    
                }else if(0==0){
                    //娘の移動先にプレイヤーが居居た場合の処理
                    
                }
            }else if(0==0){//娘が復活したか
                //娘復活する処理
            }
            
            turn++;
            
            
            
            
        }while(gameover==true);//ゲーム終了がtrueならとかに変更する
    }
    
}
