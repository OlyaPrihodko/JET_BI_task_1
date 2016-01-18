<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>
<fmt:setBundle basename="/ie.globalcom.task_1/localization.locale" var="loc"/>
<fmt:message bundle="${loc}" key="locale.message.FirstTask" var="FirstTask"/>
<div class="panel-footer">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-lg-offset-3 col-lg-6">
            <h5 class="text-center">${FirstTask}</h5>
        </div>
    </div>
</div>
