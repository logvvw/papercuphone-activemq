package net.logvv.activemq.service.impl;

import net.logvv.activemq.service.AMQProducerService;
import org.eclipse.jetty.util.ajax.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * AMQProducerServiceImpl
 *
 * @author willie
 * @date 2018-12-29 15:04
 */
@Service
public class AMQProducerServiceImpl implements AMQProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AMQProducerServiceImpl.class);

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    // 发送消息的队列名
    @Resource(name = "testQueueZeroOne")
    private Destination destination;

    @Override
    public void sendMsg(Object message) {
        final String msg = JSON.toString(message);
        try {
            LOGGER.info("send msg queue={}, msg={}", destination, msg);
            jmsTemplate.send(destination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(msg);
                }
            });

        } catch (Exception ex) {
            LOGGER.error("send msg fail, msg={}, queue={}", msg, destination);
        }
    }
}
