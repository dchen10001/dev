<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
 
<html>
<head>
</head>
<body>
<h1>Struct Demo</h1>

<h2>Add Book</h2>
<div style="color:red">
	<html:errors/>
</div>

<html:form action="/addBook.do">

<div style="padding:16px">
	<div style="float:left;width:100px;">
		<bean:message key="book.label.name" /> : 
	</div> 
	<html:text property="bookName" size="40" maxlength="20"/>
</div>

<div style="padding:16px">
	<div style="float:left;width:100px;">
		<bean:message key="book.label.author" /> : 
	</div> 
 
	<html:textarea property="author" cols="50" rows="10"/>
</div>
 
<div style="padding:16px">
	<div style="float:left;padding-right:8px;">
		<html:submit>
             <bean:message key="book.label.button.submit" />
        </html:submit>
	</div>
	<html:reset>
          <bean:message key="book.label.button.reset" />
     </html:reset>
</div>
 
</html:form>
 
</body>
</html>