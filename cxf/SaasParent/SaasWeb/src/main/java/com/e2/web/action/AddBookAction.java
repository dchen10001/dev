package com.e2.web.action;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.struts.ActionSupport;

import com.e2.domain.Book;
import com.e2.web.form.BookForm;

public class AddBookAction extends ActionSupport {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		JmsTemplate template = (JmsTemplate) getWebApplicationContext().getBean("jmsTemplate");


		BookForm bookForm = (BookForm) form;
		final Book book = new Book();
		book.setAuthor(bookForm.getAuthor());
		book.setBookName(bookForm.getBookName());
		// save it
		System.out.println("<---- send object message ------");
		template.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createObjectMessage(book);
                return message;
            }
        });
		
		System.out.println("<---- send test message ------");
		Topic topic = (Topic) getWebApplicationContext().getBean("topicDestination");
		
		template.send(topic, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage("Send you a add Book request.");
                return message;
            }
        });
		
		return mapping.findForward("success");

	}
}
