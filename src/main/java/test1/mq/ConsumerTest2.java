package test1.mq;

import io.netty.util.CharsetUtil;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author wb
 * @date 2025/11/24 10:44
 */
public class ConsumerTest2 {
    public static void main(String[] args) {
        try {
            // 实例化消息生产者Producer
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer
                    ("hello-consumergroup");

            // 设置NameServer的地址
            consumer.setNamesrvAddr("192.168.10.31:9876");

            //设置消费模式
            consumer.setMessageModel(MessageModel.CLUSTERING); //默认是集群
//            consumer.setMessageModel(MessageModel.BROADCASTING); //广播模式

            //从最开始的位置开始消费
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

            // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
            //和发送者保持一致才能搜到消息
            consumer.subscribe("hello-topic", "sms");

            // 注册回调实现类来处理从broker拉取回来的消息
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext context) {

                    msgs.forEach(message->{
                        System.out.println(message+" ; "+new String(message.getBody(), CharsetUtil.UTF_8));
                    });
                    //System.out.printf("%s 成功搜到消息: %s %n", Thread.currentThread().getName(), msgs);

                    // 标记该消息已经被成功消费 ack机制
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            // 启动Producer实例
            consumer.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
