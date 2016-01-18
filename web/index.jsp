<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>
<fmt:setBundle basename="/ie.globalcom.task_1/localization.locale" var="loc"/>
<fmt:message bundle="${loc}" key="locale.message.IndexPage" var="IndexPage"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
      <title>${IndexPage}</title>
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
  </head>
  <body>
      <jsp:forward page="/WEB-INF/jsp/main.jsp"/>
  </body>
</html>