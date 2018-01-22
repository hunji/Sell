package com.youhualife.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * created by guo19
 * created on 2018/1/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest2 {
    @Test
    public void test(){
        log.debug("debug...");
        log.info("info...");
        log.error("error...");
        
    }
}
