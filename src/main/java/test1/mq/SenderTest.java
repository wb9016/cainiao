package test1.mq;

import io.netty.util.CharsetUtil;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author wb
 * @date 2025/11/24 10:35
 */
public class SenderTest {
    //演示消息同步发送
    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        //生产者
        DefaultMQProducer producer = new DefaultMQProducer("hello-producerGroup");
        //设置name server地址
        producer.setNamesrvAddr("192.168.10.31:9876");
        //设置队列数量为2，有4个，根据情况设置
        producer.setDefaultTopicQueueNums(2);
        //启动
        producer.start();

        for (int i = 0 ; i < 16 ; i++){

        Message message = new Message();
        //消息主题
        message.setTopic("hello-topic");
        //消息标签
        message.setTags("sms");
        //添加内容
        message.setBody(("我是消息").getBytes(CharsetUtil.UTF_8));
        //执行发送
        SendResult result = producer.send(message);
        //打印结果
        System.out.println(result);
        }

        producer.shutdown();
    }
}
