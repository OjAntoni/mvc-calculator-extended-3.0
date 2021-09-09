<%--
  Created by IntelliJ IDEA.
  User: antek
  Date: 30.08.2021
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ComplexCalculate</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<%@ include file="_header.jsp"%>
<%--<%@include file="_redirectUnregistered.jsp"%>--%>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4 my-2">
            <form action="${pageContext.request.contextPath}/calc/complex" method="post">
                <div class="row">
                    <div class="mb-3">
                        <input type="number" class="form-control" name="x1" placeholder="x1">
                    </div>
                    <div class="mb-3">
                        <input type="number" class="form-control" name="y1" placeholder="y1">
                    </div>
                </div>
                <div class="row">
                    <div class="mb-3">
                        <input type="number" class="form-control" name="x2" placeholder="x2">
                    </div>
                    <div class="mb-3">
                        <input type="number" class="form-control" name="y2" placeholder="y2">
                    </div>
                </div>
                <select class="form-select" aria-label="Default select example" name="operationSign">
                    <option value="sum">+</option>
                    <option value="sub">-</option>
                    <option value="div">/</option>
                    <option value="mult">*</option>
                </select>
                <div class="row justify-content-center">
                    <div class="col-sm-4 my-1">
                        <button type="submit" class="btn btn-primary w-100">Submit</button>
                    </div>
                </div>
            </form>

            <div class="row">
                <div class="col-sm-4">
                    <div class="row">
                        <div class="col-sm-2 me-5">
                        <span class="badge bg-secondary" style="height: 40px; width: 140px">
                            <h3>Result:</h3>
                        </span>
                        </div>
                        <c:if test="${result!=null}">
                            <div class="col-sm-2 ms-5">
                                <span class="badge bg-secondary" style="height: 40px; width: auto">
                                    <h3>${result}</h3>
                                </span>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
