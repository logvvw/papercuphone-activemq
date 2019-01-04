package net.logvv.activemq;

/**
 * Application
 *
 * @author willie
 * @date 2018-12-29 14:33
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@EnableAutoConfiguration
@ImportResource("classpath:spring-main.xml")
@EnableAsync
@EnableScheduling
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws IOException
    {
        SpringApplication.run(Application.class, args);

        LOGGER.info("Begin to run spring-activemq !");

    }

}

