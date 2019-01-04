package net.logvv.activemq.service;

/**
 * AMQProducerService
 *
 * @author willie
 * @date 2018-12-29 15:00
 */
public interface AMQProducerService {

    /**
     * 描述：发送amqp msg
     * @param
     * @author willie
     * @date 2018/12/29 15:03
     */
    void sendMsg(Object message);

}
