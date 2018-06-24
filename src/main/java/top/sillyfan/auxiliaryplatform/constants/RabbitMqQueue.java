package top.sillyfan.auxiliaryplatform.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RabbitMqQueue {

    Task("delay_exchange", "task", "task");


    private String exchanges;

    private String routKey;

    private String queue;
}
