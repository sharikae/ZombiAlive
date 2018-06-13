package zombiealive;

/**
 *
 * @author C0116125佐藤啓
 */
public class BossCharacter {
    private int bossHitPoint;
    private int bossAttack;

    public BossCharacter(){//初期化
        this.bossHitPoint=35;
    }

    //ボスに対するダメージ
    public void damagedHitPoint(int damaged) {
        this.bossHitPoint -= damaged;
        if(this.bossHitPoint<=0){
            
        }
    }
    //現在HPを指定
    public int getBossHitPoint() {
        //マイナス数値を出さない為の処理。問題がある場合は削除
        if(this.bossHitPoint<0){
            this.bossHitPoint=0;
        };
        return bossHitPoint;
    }

    public int getBossAttack() {//ここで攻撃力を決定しダメージを返す
        this.bossAttack=(int)(1+Math.random()*5);//1D5のダメージ
        return bossAttack;//ダメージ値を返す
    }
    
    
    

}
