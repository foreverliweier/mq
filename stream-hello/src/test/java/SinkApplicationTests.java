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
        sinkSender.output().send(MessageBuilder.withPayload("produce a message:I'am alice").build());
    }

    public interface SinkSender {

        String OUTPUT = "input";

        /**
         * 定义了一个输出通过，而该输出通道的名称为input
         */
        @Output(SinkSender.OUTPUT)
        MessageChannel output();

    }

}
