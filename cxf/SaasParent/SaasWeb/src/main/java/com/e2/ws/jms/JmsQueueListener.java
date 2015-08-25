package com.e2.ws.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.e2.domain.Book;
import com.e2.service.BookShelfService;

@Component("jmsQueueListener")
public class JmsQueueListener implements MessageListener {

	@Autowired
	@Qualifier("bookShelfServiceImpl")
	private BookShelfService bookService;

	@Autowired
	@Qualifier("jmsTemplate")		
	private JmsTemplate template;
	
	@Autowired
	@Qualifier("topicDestination")	
	private Topic topic;
	
	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				String text = ((TextMessage) message).getText();
				System.out.println(text);
			} else if (message instanceof ObjectMessage) {
				ObjectMessage objMsg = (ObjectMessage)message;
				Book book = (Book)objMsg.getObject();
				bookService.insertBook(book);
				
				template.send(topic, new MessageCreator() {
		            public Message createMessage(Session session) throws JMSException {
		                TextMessage message = session.createTextMessage("Book is added.");
		                return message;
		            }
		        });			
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
