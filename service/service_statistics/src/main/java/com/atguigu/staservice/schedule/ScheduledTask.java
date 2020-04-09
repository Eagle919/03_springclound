package com.atguigu.staservice.schedule;

import com.atguigu.staservice.service.StatisticsDailyService;
import com.atguigu.staservice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * note4scheduled:定时任务
 * 使用步骤
 * 1 添加集成了定时任务的spirngboot依赖
 * 2 在启动类com.atguigu.staservice.StaApplication添加开启定时任务功能注解 @EnableScheduling
 * 3 在需要定时执行的方法添加注解 @Scheduled(cron = "0 0 1 * * ?")即可 cron可以通过百度某些工具自动生成
 */
@Component
public class ScheduledTask {

    @Autowired
    private StatisticsDailyService staService;

    // 0/5 * * * * ?表示每隔5秒执行一次这个方法
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void task1() {
//        System.out.println("**************task1执行了..");
//    }

    //在每天凌晨1点，把前一天数据进行数据查询添加
    @Scheduled(cron = "0 0 1 * * ?")
    public void task2() {
        staService.registerCount(DateUtil.formatDate(DateUtil.addDays(new Date(), -1)));
    }
}
