package jp.ac.teu.zombiealive.util;

import java.util.Calendar;

public class Timer {

    Calendar start = Calendar.getInstance();
    Calendar timeUp = Calendar.getInstance();

    public Timer() {
        timeUp.add(Calendar.MINUTE, 1);//Timerクラス初期化の15分後にセット
    }

    public boolean getTimer() {//時間がたったかどうかの判断
        Calendar top = Calendar.getInstance();
        boolean time = top.after(timeUp);
        return time;
    }

    public int[] getClearTimer() {
        Calendar now = Calendar.getInstance();
        int progressMinute;
        int progressSecond;
        int evaluation;

        if (now.get(now.HOUR) == start.get(start.HOUR)) {
            progressMinute = now.get(now.MINUTE) - start.get(start.MINUTE);
            progressSecond = now.get(now.SECOND) - start.get(start.SECOND);
        } else {
            progressMinute = 60 + now.get(now.MINUTE) - start.get(start.MINUTE);
            progressSecond = now.get(now.SECOND) - start.get(start.SECOND);
        }
        System.out.println(now.get(now.MINUTE));
        System.out.println(start.get(start.MINUTE));

        if (progressMinute < 5) {
            evaluation = 1;
        } else if (progressMinute < 10) {
            evaluation = 2;
        } else {
            evaluation = 3;
        }
        return new int[]{progressMinute, progressSecond,evaluation};
    }

}
