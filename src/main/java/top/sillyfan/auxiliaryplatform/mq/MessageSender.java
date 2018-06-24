package top.sillyfan.auxiliaryplatform.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.sillyfan.auxiliaryplatform.constants.RabbitMqQueue;
import top.sillyfan.auxiliaryplatform.domain.model.message.DelayMessage;

@Component
@Slf4j
public class MessageSender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 发送mq
     */
    public void sendMessage(RabbitMqQueue queue, DelayMessage message) {
        try {

            rabbitTemplate.convertAndSend(queue.getExchanges(), queue.getRoutKey(), objectMapper.writeValueAsString(message), MessageDelayProcessorFactory.of(message.getDelay()));
        } catch (JsonProcessingException e) {
            log.error("mq发送失败", e);
        }
    }
}
