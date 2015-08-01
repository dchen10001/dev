package com.e2.ws.service;

import java.net.URLEncoder;



import org.apache.commons.httpclient.Header; 
import org.apache.commons.httpclient.HttpClient; 
import org.apache.commons.httpclient.methods.PostMethod; 

import com.e2.vo.BookVO;

public class RestClient {
    private static final String getURL = "http://localhost:8080/SoapWS/services/bookShelfServiceRest/bookService/getbook/"; 
    private static final String addURL = "http://localhost:8080/SoapWS/services/bookShelfServiceRest/bookService/addbook"; 

	public static void main(String[] args) {
		RestClient client = new RestClient();
		try {
			//client.addBook("Foundation and Earth", "Issac Asimov");
			//client.addBook("Foundation and Empire", "Issac Asimov");
			//client.addBook("Rama Revealed", "Arthur C Clarke");

			client.getBook("Rama Revealed");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public String getBook(String bookName) throws Exception { 
         String output = null; 
         try{ 
        	 String restURL = getURL + URLEncoder.encode(bookName, "UTF-8"); 
             HttpClient client = new HttpClient(); 
             PostMethod mPost = new PostMethod(restURL); 
             client.executeMethod( mPost ); 
             Header mtHeader = new Header(); 
             mtHeader.setName("content-type"); 
             mtHeader.setValue("application/x-www-form-urlencoded"); 
             mtHeader.setName("accept"); 
             mtHeader.setValue("application/xml"); 
             mPost.addRequestHeader(mtHeader); 

             client.executeMethod(mPost); 
             output = mPost.getResponseBodyAsString( ); 
             mPost.releaseConnection( ); 
             System.out.println("out : " + output); 
             return output; 
         } catch(Exception e){ 
             throw new Exception("Exception in retriving group page info : " + e); 
         } 
     } 

     public void addBook(String bookName, String author) throws Exception { 
         String output = null; 
         try{ 
             HttpClient client = new HttpClient(); 
             PostMethod mPost = new PostMethod(addURL); 

             mPost.addParameter("name", "Naked Sun"); 
             mPost.addParameter("author", "Issac Asimov"); 
             Header mtHeader = new Header(); 
             mtHeader.setName("content-type"); 
             mtHeader.setValue("application/x-www-form-urlencoded"); 
             mtHeader.setName("accept"); 
             mtHeader.setValue("application/xml"); 
             mPost.addRequestHeader(mtHeader); 

             client.executeMethod(mPost); 
             output = mPost.getResponseBodyAsString( ); 
             mPost.releaseConnection( ); 
             System.out.println("output : " + output); 
         } catch(Exception e) { 
        	 throw new Exception("Exception in adding bucket : " + e); 
         } 
     } 	
}
