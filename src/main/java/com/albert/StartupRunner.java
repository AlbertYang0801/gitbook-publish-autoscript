package com.albert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Slf4j
@Component
public class StartupRunner implements ApplicationRunner {

    @Resource
    private ConfigurableApplicationContext context;

    @Value("${spring.application.name}")
    private String application;

    @Override
    public void run(ApplicationArguments args) {
        if (this.context.isActive()) {
            log.info("  _   _   _   _   _   _   _   _");
            log.info(" / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\");
            log.info("( c | o | m | p | l | e | t | e )");
            log.info(" \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/");
            log.info("{} 启动完毕,时间:{}", this.application, LocalDateTime.now());
        }
    }

}
