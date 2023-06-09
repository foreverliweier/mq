import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author alice
 * @time 2023-06-07 11:28
 **/
@RunWith(SpringRunner.class)
@EnableBinding(value = {SinkApplicationTests.SinkSender.class})
public class SinkApplicationTests {

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void sinkSenderTester() {
        sinkSender.output().send(MessageBuilder.withPayload("produce a message:I'am alice through input channel;").build());
        sinkSender.output2().send(MessageBuilder.withPayload("produce a message:I'am alice through raw-sensor-data channel;").build());
    }

    public interface SinkSender {

        String OUTPUT = "input"; //若不配置 application.properties 文件，消息管道是 input
        String OUTPUT2 = "raw-sensor-data";

        /**
         * 定义了一个输出通过，而该输出通道的名称为input
         */
        @Output(SinkSender.OUTPUT)
        MessageChannel output();

        @Output(SinkSender.OUTPUT2)
        MessageChannel output2();

    }

}
