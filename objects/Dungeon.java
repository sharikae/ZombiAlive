/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombialive;

/**
 *
 * @author C0116125佐藤啓
 */


public class Dungeon {
    
    //クラス関数にしてあるけどこれ初期化の奴入れる必要がある
    //とりあえず構造だけ
    private static int[][] dungeon={{0,0,1,2,3,4,5,6},
                                    {7,8,9,0,0,10,0,0},
                                    {0,0,11,12,0,13,14,15},
                                    {0,16,17,0,18,19,20,0},
                                    {0,0,21,22,23,0,24,25}};
    //ここで書き入れる場合用の奴
    
    
    public Dungeon(){//とりあえず呼び出し。クラス関数なのでとりあえず存在を決定する用
       
    }
    
    //座標を入力して部屋番号を返す。部屋番号がない場合は0
    public static int getDungeon(int x,int y) {
        return dungeon[y][x];
    }
    
    
}
