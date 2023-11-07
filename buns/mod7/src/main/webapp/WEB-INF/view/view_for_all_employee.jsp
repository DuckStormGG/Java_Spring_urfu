<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>
<h3> Information for all Employees </h3>
<br><br>

<security:authorize access="hasRole('HR')"><input type="button" value="salary" onclick="window.location.href ='hr_info' ">
    Only For HR staff
</security:authorize>

<br><br>
<security:authorize access="hasRole('MANAGER')"><input type="button" value="performance" onclick="window.location.href ='manager_info' ">
    Only For Managers
</security:authorize>

</body>
</html>
