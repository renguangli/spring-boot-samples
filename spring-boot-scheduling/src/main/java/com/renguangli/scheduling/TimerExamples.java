package com.renguangli.scheduling;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TimerExamples
 *
 * @author renguangli 2018/10/23 13:51
 * @since JDK 1.8
 */
public class TimerExamples {

    public void task() {
        /*
         * 只执行一次
         */
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("2000毫米后执行一次。");
            }
        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("5000毫米后执行一次。");
            }
        }, new Date(System.currentTimeMillis() + 5000));

        /*
         * 循环执行
         */
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(111);
            }
        }, 1000, 2000); // 1000毫米后执行第一次，之后每2000毫米执行一次

        // 终止定时任务
        timer.cancel();
    }
}
