package com.e2.ws.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component("jmsTopicListener")
public class JmsTopicListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				String text = ((TextMessage) message).getText();
				System.out.println(text);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
