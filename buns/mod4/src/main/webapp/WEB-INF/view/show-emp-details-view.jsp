<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="employee" scope="request" type="com.pavelhaimov.spring.mvc.Employee"/>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
Your name: ${employee.name}
<br>
Your surname: ${employee.surname}
<br>
Your salary: ${employee.salary}
<br>
Your department: ${employee.department}
<br>
Your car: ${employee.carBrand}
<br>
Language(s):
<ul>

    <c:forEach var="lang" items="${employee.languages}">
        <li>    ${lang}    </li>
    </c:forEach>

</ul>
<br>
Phone number:${employee.phoneNumber}
<br>
Email:${employee.email}
<br>

</body>
</html>
