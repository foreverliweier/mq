package codedream.mq.listener;

import codedream.mq.send.Input1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author alice
 * @time 2023-06-07 09:20
 **/
@EnableBinding({Sink.class, Input1.class})
public class SinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    /**
     * 该注解主要定义在方法上，作用是将被修饰的方法注册为消息中间件上数据流的事件监听器，注解中的属性值对应了监听的消息通道名
     */
    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("Received through input channel, {}, to String,{} ", payload, payload.toString());
    }

    @StreamListener(Input1.INPUT_CHANNEL)
    public void receive1(Object payload) {
        logger.info("Received through input1 channel, {}, to String,{} ", payload, payload.toString());
    }
}
