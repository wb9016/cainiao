package test1.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author wb
 * @date 2025/11/24 9:53
 */
public class Consumer {
    public static void main(String[] args) {
        try {
            // 实例化消息消费者Producer
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer ("consumergroup");

            // 设置NameServer的地址
            consumer.setNamesrvAddr("192.168.10.31:9876");

            //从最开始的位置开始消费
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

            // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
            //和发送者保持一致才能搜到消息
            consumer.subscribe("topic_log", "tags_error");

            // 注册回调实现类来处理从broker拉取回来的消息
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext context) {

                    System.out.printf("%s 成功搜到消息: %s %n", Thread.currentThread().getName(), msgs);

                    // 标记该消息已经被成功消费
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            // 启动Consumer实例
            consumer.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
