<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:requestEncoding value="utf-8"/>
<fmt:setBundle basename="/ie.globalcom.task_1/localization.locale" var="loc"/>
<fmt:message bundle="${loc}" key="locale.message.MainPage" var="MainPage"/>
<fmt:message bundle="${loc}" key="locale.message.Submit" var="Submit"/>
<fmt:message bundle="${loc}" key="locale.message.EnterKeyword" var="EnterKeyword"/>
<fmt:message bundle="${loc}" key="locale.message.ShowList" var="ShowList"/>
<html>
<head>
    <title>${MainPage}</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-md-offset-3 col-lg-offset-3 col-lg-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="panel-title">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6 col-lg-5 col-lg-offset-3" align="center">
                                ${EnterKeyword} <i class="fa fa-smile-o"></i>
                            </div>
                        </div>
                    </div>
                </div>
                <form role="form" action="controller" method="post">
                    <input type="hidden" id="command" name="command" value=""/>
                    <div class="panel-body">
                        <br/>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6 col-lg-4 col-lg-offset-2 ">
                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <span class="glyphicon glyphicon-pencil">
                                                        </span>
                                                    </span>
                                    <input type="text" id="keyword" name="keyword" value="" class="form-control" placeholder="keyword" autofocus/>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 col-lg-offset-1 col-lg-4">
                                <div class="btn-group-vertical">
                                    <button type="submit" class="btn btn-labeled btn-primary"
                                            onclick="document.getElementById('keyword').required='required';
                                                         document.getElementById('command').value='submit';">
                                        <span class="btn-label" type="submit"><i class="glyphicon glyphicon-send" style="font-size: 120%"></i></span> ${Submit}
                                    </button>
                                    <button type="submit" class="btn btn-labeled btn-primary"
                                            onclick="document.getElementById('command').value='show-list';
                                            document.getElementById('keyword').required='';">
                                        <span class="btn-label" type="submit"><i class="glyphicon glyphicon-list-alt" style="font-size: 120%"></i></span> ${ShowList}
                                    </button>
                                </div>
                            </div>
                        </div>
                        <br/>
                        <div align="center">
                               <h3><c:out value="${message}"/></h3>
                        </div>
                        <div align="center">
                            <c:forEach var="type" items="${list}">
                            <xmp><c:out value="${type.value.keyword}"/></xmp>
                            </c:forEach>
                        </div>
                    </div>
                    <%@include file="/WEB-INF/jsp/footerPart.jsp"%>
                </form>
            </div>
        </div>
    </div>
    </form>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
