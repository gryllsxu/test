package test.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


public class JmsTest {

    public static void main(String[] args) throws JMSException {
        System.out.println("aaaaaaaaaaaaaa");
        ConnectionFactory cf;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageProducer producer;
        MessageConsumer consumer;

        cf = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
//                "tcp://10.200.1.203:61616?wireFormat.maxInactivityDuration=0");

        connection = cf.createConnection();
        connection.start();
        session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        destination = session.createQueue("first_queue");

        producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        sendMessage(session, producer);
        session.commit();

        consumer = session.createConsumer(destination);
        receiveMessage(consumer);
    }

    public static void receiveMessage(MessageConsumer consumer) throws JMSException {
        while (true) {  
            // 设置接收者接收消息的时间，为了便于测试，这里谁定为100s  
            TextMessage message = (TextMessage) consumer.receive(100000);  
            if (null != message) {  
                System.out.println("收到消息" + message.getText());  
            } else {  
                break;  
            }  
        }
    }

    public static void sendMessage(Session session, MessageProducer producer) throws JMSException {
        TextMessage message = session.createTextMessage("Activemq message 1");
        producer.send(message);
    }
}
