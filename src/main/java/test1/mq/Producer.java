package test1.mq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author wb
 * @date 2025/11/24 9:50
 */
//消息发送者
public class Producer {

    public static void main(String[] args) {
        try {
            // 实例化消息生产者Producer
            DefaultMQProducer producer = new DefaultMQProducer("producergroup");
            // 设置NameServer的地址
            producer.setNamesrvAddr("192.168.10.31:9876");
            // 启动Producer实例
            producer.start();
            for (int i = 0; i < 100; i++) {
                //构建消息
                Message message = new Message("topic_log","tags_error",("我是消息"+i).getBytes());
                SendResult sendResult = producer.send(message);
                System.out.printf("%s%n", sendResult);
            }

            // 如果不再发送消息，关闭Producer实例。
            producer.shutdown();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
