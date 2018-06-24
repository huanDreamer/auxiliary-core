package top.sillyfan.auxiliaryplatform.mq;

import org.springframework.amqp.core.MessagePostProcessor;

public class MessageDelayProcessorFactory {

    /**
     * 延时发送
     *
     * @param delay
     * @return
     */
    public static MessagePostProcessor of(Integer delay) {
        return message -> {

            message.getMessageProperties().setDelay(delay * 1000);

            return message;
        };
    }
}
