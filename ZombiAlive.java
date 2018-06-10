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
        int x = 7,y = 4;//プレイヤーのX,Y軸初期位置(たぶん25番部屋のはず)
        int xd=0,yd=0;//プレイヤーが移動する向き
        String st;//方向の受け皿
        boolean gameover=false;//ゲームオーバーならtrue
        boolean error=false;//問題があるならtrue

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
                error=false;//エラー初期化
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
                        System.out.println("エラー文");
                        error=true;//エラーなら巻き戻される
                        break;
                }
                if(x+xd<0||x+xd>7||y+yd<0||y+yd>7){//行く方向が不正か？
                    //不正の場合の処理
                    System.out.println("エラー文");
                    error=true;
                }else if(dn.getDungeon(x+xd, y+yd)==0){//ダンジョンクラス内が０なら
                    System.out.println("エラー文");
                    error=true;
                }else if((dn.getDungeon(x, y)==14&&xd==-1) ||
//現在ダンジョンクラスが14の時に左なら
                        (dn.getDungeon(x, y)==19&&yd==-1)||
                        //現在のダンジョンクラスが19の時に上なら
                        (dn.getDungeon(x, y)==13&&(xd==1||yd==1))
//現在13番部屋に居る時に下、右が押されたら
                        ){
                    //くっついてる部屋が壁ならば
                    //現在はroom変数がない為ごり押しを行っている
                    //room変数がエラーならば
                    error=true;
                    
                }
            }while(error!=true);//向きが正しくない場合はループ
            System.out.println("覗くかの選択");
            //覗く選択氏は除く場合はy,覗かないならy以外の文字を打つようにすればいいと思う
            st=s.next();//何かしら文字を打てば続行。
            //覗くかの選択
            if(st=="y"){//覗く
                //次の部屋情報の出力
                
                
            }else{//覗かない
                //プレイヤーの移動処理
                x+=xd;//Ｘを移動した分だけ移動。
                y+=yd;//y軸を移動した分だけ移動
                //移動先にゾンビが居るか
                
                //(移動先の部屋番号にゾンビが存在するか)
                if(0!=0){//ゾンビが居る時の処理
                    do{//（戦闘処理は次回の授業で実装）
                    
                    }while(0==0);//戦闘終了処理が行われた場合
                }else if(dn.getDungeon(x, y)==7){//key部屋の場合の処理
                    
                }else if(dn.getDungeon(x, y)==15||dn.getDungeon(x, y)==12||dn.getDungeon(x, y)==5){//回復部屋か,
//（かつ使用フラグが立っていないかとかにすれば一応ごり押しできる。）
                    
                    if (pc.getHp()<30) {//プレイヤーのＨＰが初期値以下なら
                        System.out.println("");//回復するかしないかの処理
                        st = s.next();//yが撃ち込まれなかったら何もしない。
                        if (st=="y") {//回復するなら
                            pc.setHp(30);//HPを初期値にする
                        }
                    } else {
                        System.out.println("ここは回復部屋だ。今は必要ない");
                    }
                }else if(0!=0){//boss部屋か(次回の授業で実装)
                    //boss部屋の処理をここに書く。
                }
            }
            //娘の処理(次回の授業で実装。)
            if(0!=0){//娘が移動可能か
                if(0==0){//プレイヤーの移動先(現在の部屋)に娘が居るか。
                    //現在の部屋に娘が居る時の処理
                    
                }else if(0==0){
                    //娘の移動先にプレイヤーが居居た場合の処理
                    
                }
            }else if(0!=0){//娘が復活したか(次回の授業で実装)
                //if文の中身はturn+娘が倒されたターン>=3とかそんな感じになりそう
                //娘復活する処理
            }
            
            turn++;
            
            
            
            
        }while(gameover==true);
//ゲーム終了がtrueならとかに変更する
//コンティニューは実装する気はない
    }
    
}
