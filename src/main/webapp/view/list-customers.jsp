<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>List Customers</title>
</head>
<body>
<div id="wrapper">
  <div id="header">
    <h2>CRM - Customer Relationship Manager</h2>
  </div>
  <div id="container">
    <div id="content">
      <table>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
        </tr>

        <%-- loop and print our customers --%>
        <c:forEach var="customer" items="${customers}">
          <tr>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</div>
</body>
</html>
