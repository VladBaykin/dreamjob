<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
        crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
          integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
          integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
          crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
          integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
          crossorigin="anonymous"></script>

  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <title>Работа мечты</title>
</head>
<body>
<div class="container">
  <div class="row">
    <ul class="nav">
      <li class="nav-item">
        <a class="nav-link" href='<c:url value="/index.do" />'>Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp"> <c:out value="${user.name}"/> | Выйти</a>
      </li>
    </ul>
  </div>
  <div class="container pt-3">
    <div class="row">
      <div class="card" style="width: 100%">
        <div class="card-header">
          Кандидаты
        </div>
        <div class="card-body">
          <table class="table">
            <thead>
            <tr>
              <th scope="col">Имя</th>
              <th scope="col">Фото</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${candidates}" var="cand">
              <tr>
                <td>
                  <a href="<c:url value="/candidate/edit.jsp?id=${cand.id}"/>">
                    <i class="fa fa-edit mr-3"></i>
                  </a>
                  <c:out value="${cand.name}"/>
                </td>
                <td>
                  <c:choose>
                    <c:when test="${cand.photoId == 0}">
                      <a href="<c:url value="/candidate/upload.jsp?id=${cand.id}"/>">
                        Upload photo
                      </a>
                      <br/>
                    </c:when>
                    <c:otherwise>
                      <a href="<c:url value='/download?name=${cand.photoId}'/>">
                        <img src="<c:url value='/download?name=${cand.photoId}'/>"
                             width="70px"
                             height="70px"/></a>
                      <br/>
                    </c:otherwise>
                  </c:choose>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>