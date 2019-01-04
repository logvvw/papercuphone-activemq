import net.logvv.activemq.service.AMQProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-main.xml"})
/**
 * MQProducerTest
 *
 * @author willie
 * @date 2018-12-29 16:36
 */
public class MQProducerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MQProducerTest.class);

    @Autowired
    AMQProducerService amqProducerService;

    @Test
    public void send() throws Exception{

        for(int i=0;i<100;i++){

            Map<String,Object> msg = new HashMap<>();
            msg.put("data","2018-12-29 mq test message " + i);

            amqProducerService.sendMsg(msg);

            LOGGER.info("send msg #{}",i);

            Thread.sleep(500);
        }
    }
}
