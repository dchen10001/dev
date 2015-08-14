<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
 
<html>
<head>
</head>
<body>
<h2>List All Books</h2>

<table border="1">
<tr><td>Book Name</td><td>Author</td></tr>

<logic:iterate id="book" name="bookListForm" property="books">
<tr>	
<td><bean:write name="book" property="bookName"/></td>
<td><bean:write name="book" property="author"/></td>
</tr>
</logic:iterate> 

</table>

<br/>
<br/>
<html:link action="/addBookPage.do">Add Book</html:link>
 
</body>
</html>