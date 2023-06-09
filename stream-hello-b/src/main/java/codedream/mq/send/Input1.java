package codedream.mq.send;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author alice
 * @time 2023-06-08 17:38
 **/
public interface Input1 {
    String INPUT_CHANNEL = "input1";

    @Input(INPUT_CHANNEL)
    SubscribableChannel input();
}
