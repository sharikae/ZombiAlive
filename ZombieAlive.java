/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombiealive;

import java.util.Scanner;
//import zombiealive.Dungeon;
//import zombiealive.PlayerCharacter;

/**
 *
 * @author C0116125
 */
public class ZombieAlive {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        //初期化----------------------------------
        int turn=0;//全体ターン数
        Dungeon dn = new Dungeon();//ダンジョンの初期化(呼び出すだけ)
        Room[] rm = new Room[26];
        boolean[] move;
        for(int i =0;i<rm.length;i++){
            rm[i] = new Room(i);
            System.out.println("RoomNo." + i + "のゾンビの数：" + rm[i].getZombieNum());
            System.out.print("RoomNo." + i + "の行ける方向：");
            move = rm[i].nextMove();
            if (move[0]) {
                System.out.print("上");
            }
            if (move[1]) {
                System.out.print("右");
            }
            if (move[2]) {
                System.out.print("下");
            }
            if (move[3]) {
                System.out.print("左");
            }
            System.out.println("");
        }
        System.out.println("");
        
        PlayerCharacter pc = new PlayerCharacter();//プレイヤー変数の初期化
        System.out.println("Playerの初期化確認");
        System.out.println("HPの状態："+pc.getAboutHp());
        System.out.println("HPの値："+pc.getHp());
        System.out.println("部屋の番号"+ pc.getRoom());
        System.out.println("鍵のフラグ" + pc.isKey());
        System.out.println("所持武器番号"+ pc.getWeapon());
        
        DaughterCharacter dc = new DaughterCharacter();//娘変数の初期化
        System.out.println("Daughterの初期化確認");
        System.out.println("HPの値："+dc.get_hp());
        System.out.println("部屋の番号："+dc.get_daughterPosition());
        
        BossCharacter bc = new BossCharacter();
        System.out.println("Bossの初期化確認");
        System.out.println("BossのHP:"+ bc.getBossHitPoint());
        
        ZombieCharacter zc = new ZombieCharacter();
        System.out.println("Zombieの初期化確認");
        System.out.println("ゾンビのHP:"+zc.getHp());
        
        //Timer tm=new Timer();//タイマークラスの呼び出し。仮置き
        int x = 7,y = 4;//プレイヤーのX,Y軸初期位置(たぶん25番部屋のはず)
        int xd=0,yd=0;//プレイヤーが移動する向き
        String st;//方向の受け皿
        boolean gameover = false;//ゲームオーバーならtrue
        boolean error = false;//問題があるならtrue

        Scanner s = new Scanner(System.in);//これでキーを指定
        //説明文の出力------------------------------------------
        System.out.println("スタートする場合はボタンを押す。");
        //ボタンが押されたらスタート
        st=s.next();
        
        //Timerのスタート
        
        //ゲーム終了までループする文
        do{
            //部屋情報の表示(行ける部屋方向に矢印を出力)
            System.out.println("現在の部屋番号:"+Dungeon.getDungeon(x, y));
            System.out.println("x:"+x+",y:"+y);
            System.out.println("現在の体力:"+pc.getAboutHp());
            //移動方向の入力(if文でその向きが行ける部屋方向かを指定
            do{
                error=false;//エラー初期化
                xd=0;//初期化
                yd=0;
                System.out.print("方向を入力してください");
                System.out.println("xd:"+xd+"yd:"+yd);
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
                        System.out.println("エラー文1");
                        error=true;//エラーなら巻き戻される
                        break;
                }
                System.out.println("xd:"+xd+"yd:"+yd);
                if(x+xd<0   ||  x+xd>7  ||  y+yd<0  ||    y+yd>4){//行く方向が不正か？
                    //不正の場合の処理
                    System.out.println("エラー文2");
                    error=true;
                }else if(Dungeon.getDungeon(x+xd, y+yd)==0){//ダンジョンクラス内が０なら
                    System.out.println("エラー文3");
                    error=true;
                }else if((Dungeon.getDungeon(x, y)==14&&xd==-1) ||
//現在ダンジョンクラスが14の時に左なら
                        (Dungeon.getDungeon(x, y)==19&&yd==-1)||
                        //現在のダンジョンクラスが19の時に上なら
                        (Dungeon.getDungeon(x, y)==13&&(xd==1||yd==1))
//現在13番部屋に居る時に下、右が押されたら
                        ){
                    //くっついてる部屋が壁ならば
                    //現在はroom変数がない為ごり押しを行っている
                    //room変数がエラーならば
                    System.out.println("エラー４");
                    error=true;
                    
                }else if (Dungeon.getDungeon(x, y)==5&&xd==1&&pc.getKey()==false) {
                    System.out.println("鍵がないので開かない");
                    error=true;
                }
            }while(error==true);//向きが正しくない場合はループ
            System.out.println("覗くかの選択");
            //覗く選択氏は除く場合はy,覗かないならy以外の文字を打つようにすればいいと思う
            st=s.next();//何かしら文字を打てば続行。
            
            //覗くかの選択
            if("y".equals(st)){//覗く
                //次の部屋情報の出力
                System.out.println("覗いた結果");
                System.out.println("覗き先の部屋番号:"+Dungeon.getDungeon(x+xd, y+yd));
            }else{//覗かない
                //プレイヤーの移動処理
                x+=xd;//Ｘを移動した分だけ移動。
                y+=yd;//y軸を移動した分だけ移動
                //移動先にゾンビが居るか
                
                //(移動先の部屋番号にゾンビが存在するか)
                if(0!=0){//ゾンビが居る時の処理
                    do{//（戦闘処理は次回の授業で実装）
                    
                    }while(0==0);//戦闘終了処理が行われた場合
                }else if(Dungeon.getDungeon(x, y)==7){//key部屋の場合の処理
                    System.out.println("鍵がある");
                    pc.setKey(true);
                }else if(Dungeon.getDungeon(x, y)==15||Dungeon.getDungeon(x, y)==12||Dungeon.getDungeon(x, y)==5){//回復部屋か,
//（かつ使用フラグが立っていないかとかにすれば一応ごり押しできる。）
                    System.out.println("回復部屋だ");
                    if (pc.getHp()<30) {//プレイヤーのＨＰが初期値以下なら
                        System.out.println("回復しますか？");//回復するかしないかの処理
                        st = s.next();//yが撃ち込まれなかったら何もしない。
                        if ("y".equals(st)) {//回復するなら
                            pc.setHp(30);//HPを初期値にする
                        }
                    } else {
                        System.out.println("今は必要ないようだ");
                    }
                }else if(Dungeon.getDungeon(x, y)==6){//boss部屋か(戦闘は次回の授業で実装)
                    //boss部屋の処理をここに書く。
                    System.out.println("ボス部屋だ");
                    gameover=true;
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
            
            
            
            
        }while(gameover!=true);
//ゲーム終了がtrueならとかに変更する
//コンティニューは実装する気はない
    }
    
}
