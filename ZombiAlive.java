/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombialive;

import java.util.Scanner;

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
        int xd=0,yd = 0;//プレイヤーの移動先のx,y軸
        boolean er=false;
        boolean gameover=false;
        Scanner s = new Scanner(System.in);//これでキーを指定
        //BufferReaderでも同じことが出来るし速いけど例外処理が必要な為無視
        
        //説明文の出力------------------------------------------
        System.out.println("説明的なのを書く");
        //ボタンが押されたらスタート
        s.next();//文字待ち等を行う
        
        //Timerのスタート
        
        //ゲーム終了までループする文
        do{
            //部屋情報の表示(行ける部屋方向に矢印を出力)
            
            //移動方向の入力(if文でその向きが行ける部屋方向かを指定
            do{
                er=false;//ループするかの処理
                xd=0,yd=0;//行く方向の初期化
                System.out.println("行く方向を指定してください");
                System.out.println("w:上,a:左,s:下,d:右");
                String sn = s.next();//行く方向指定
                switch(sn){
                    case "w"://上方向の場合
                        yd--;//ベクトル変化
                        
                        break;
                    case "a"://左の場合
                        xd--;
                        break;
                    case"s"://下方向の場合
                        yd++;
                        break;
                    case"d"://右方向の場合
                        xd++;
                    break;
                    default:
                        System.err.println("入力方向が不正です");
                        er=true;
                        break;
                        
                }
                if(x+xd<0||x+xd>8||y+yd<0||y+yd>5){
//行く方向指定がどう考えてもおかしい時かどうか
                    //不正の場合の処理
                }else{
                //不正じゃない場合の処理
                }
                switch(sn){
                    case "w"://上方向の場合
                        yd--;
                        break;
                    case "a"://左の場合
                        xd--;
                        break;
                    case"s"://下方向の場合
                        yd++;
                        break;
                    case"d"://右方向の場合
                        xd++;
                    break;
                    default:
                        System.err.println("入力方向が不正です");
                        er=true;
                        break;
                        
                }
                        
            }while(er=false);//向きが正しくない場合はループ
            
            //覗くかの選択
            System.out.println("覗きますか\nY or other key");
            String ne=s.next();
            if(ne=="Y"){//覗く
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
