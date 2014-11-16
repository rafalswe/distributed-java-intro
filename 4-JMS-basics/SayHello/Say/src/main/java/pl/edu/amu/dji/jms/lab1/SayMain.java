package pl.edu.amu.dji.jms.lab1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SayMain {

    public static final String EXIT = "exit";

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination queue = session.createQueue("SayHelloQueue");
        MessageProducer producer = session.createProducer(queue);

<<<<<<< HEAD
        /*
        Create Connection instance from ConnectionFactory

        Create Session instance from connection object.
        - Session shouldn't by transactional and should by in auto acknowledge mode (Session.AUTO_ACKNOWLEDGE).

        Create Destination queue from session (check Session class and createQueue method)
        - queue name should be "SayHelloQueue"

        Create MessageProducer from session for given queue/topic
        - set producer delivery mode to non persistent (DeliveryMode.NON_PERSISTENT);
         */

        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination queue = session.createQueue("SayHelloQueue");
        MessageProducer producer = session.createProducer(queue);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

=======
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
>>>>>>> a5a8e520cb29c15444c80ada099f87fa8bea906e

        producer.setTimeToLive(3000);
        connection.start();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String in = "";
        while (!in.equalsIgnoreCase(EXIT)) {
            System.out.print("Say hello to:");
<<<<<<< HEAD
            text = bufferedReader.readLine();

            TextMessage textMessage = session.createTextMessage(text);
            textMessage.setBooleanProperty("Dots",text.contains("."));
            producer.send(queue,textMessage);
            //Create TextMessage from session with text variable
            //Send this message to queue (use producer for that)
=======
            in = bufferedReader.readLine();
            TextMessage message = session.createTextMessage(in);
            producer.send(message);
>>>>>>> a5a8e520cb29c15444c80ada099f87fa8bea906e
        }

        session.close();
        connection.close();
    }
}
