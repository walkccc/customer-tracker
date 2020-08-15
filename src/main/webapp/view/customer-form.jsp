<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <title>Save Customer</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">
</head>
<body>
<div>
  <div id="header">
    <h2>CRM - Customer Relationship Manager</h2>
  </div>
  <div>
    <h3>Save Customer</h3>
    <form:form action="saveCustomer" modelAttribute="customer" method="POST">
      <table>
        <tbody>
        <tr>
          <td><label>First name:</label></td>
          <td><form:input path="firstName"/></td>
        </tr>
        <tr>
          <td><label>Last name:</label></td>
          <td><form:input path="lastName"/></td>
        </tr>
        <tr>
          <td><label>Email:</label></td>
          <td><form:input path="email"/></td>
        </tr>
        <tr>
          <td><label></label></td>
          <td><input type="submit" value="Save"></td>
        </tr>
        </tbody>
      </table>
    </form:form>
    <div style="clear; both;"></div>
    <p>
      <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
    </p>
  </div>
</div>
</body>
</html>