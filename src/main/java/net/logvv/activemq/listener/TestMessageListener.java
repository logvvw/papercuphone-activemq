package net.logvv.activemq.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * TestMessageListener
 * 消息监听器，消费message
 * @author willie
 * @date 2018-12-29 15:30
 */
public class TestMessageListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestMessageListener.class);

    @Override
    public void onMessage(Message message) {

        if (message instanceof TextMessage) {

            try {
                TextMessage txtMsg = (TextMessage) message;
                String msg = txtMsg.getText();

                LOGGER.info("[listener 01] receive msg={}", msg);
                System.out.println("[listener 01] receive txt msg: " + msg);
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }

        } else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }

    }
}
