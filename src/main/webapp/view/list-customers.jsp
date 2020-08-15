<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>List Customers</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">
</head>
<body>
<div id="wrapper">
  <div id="header">
    <h2>CRM - Customer Relationship Manager</h2>
  </div>
  <div id="container">
    <div id="content">
      <%-- put new button: Add Customer --%>
      <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;">

      <table>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Action</th>
        </tr>

        <%-- loop and print our customers --%>
        <c:forEach var="customer" items="${customers}">

          <%-- construct an "update" link with customter id --%>
          <c:url var="updateLink" value="/customer/showFormForUpdate">
            <c:param name="customerId" value="${customer.id}"/>
          </c:url>

          <%-- construct an "delete" link with customter id --%>
          <c:url var="deleteLink" value="/customer/delete">
            <c:param name="customerId" value="${customer.id}"/>
          </c:url>
          <tr>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>
                <%-- display the update and delete link --%>
              <a href="${updateLink}">Update</a>
              |
              <a href="${deleteLink}"
                 onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</div>
</body>
</html>
