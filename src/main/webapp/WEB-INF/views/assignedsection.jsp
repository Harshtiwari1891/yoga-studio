<%-- 
    Document   : assginedsection
    Created on : Aug 6, 2014, 10:01:25 PM
    Author     : Yen
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:url var="cssUrl" value='/css/style.css'></c:url>
        <link rel="stylesheet" type="text/css" href=${cssUrl}>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Yoga Studio</title>
    </head>
    <body>
        <div id="container">
            <%@include file="template/header.jsp"%>
            <div id="content-container">
                <%@include file="template/sidebar.jsp"%>
                <div id="content">
                    <h2>
                        View Assigned Sections
                    </h2>
                    <table class="tg">
                        <tr>
                            <th>Section ID</th>
                            <th>Class Name</th>
                            <th>Price</th>
                            <th>Schedule</th>
                            <th>Location</th>
                            <th>Capacity</th>
                        </tr>
                        <c:if test="${!empty listSections}">
                            <c:forEach items="${listSections}" var="section">
                                <tr>
                                    <td>${section.id}</td>
                                    <td>${section.yogaClass.name}</td>
                                    <td>${section.yogaClass.price}</td>
                                    <td>${section.schedule}</td>
                                    <td>${section.location}</td>
                                    <td>${section.maxStudents}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </table>
                </div>
                <!--<%@include file="template/right-side.jsp"%>-->
                <%@include file="template/footer.jsp"%>
            </div>
        </div>
    </body>
</html>
