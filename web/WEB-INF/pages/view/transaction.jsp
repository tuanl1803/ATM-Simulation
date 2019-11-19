<!DOCTYPE html>
<%@include file="../taglibs.jsp" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>ATM System Options: Account Details</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="demo-headline" style="padding: 0px;">
        <h1 class="demo-logo">
            ATM
            <small>24 Hour Syariah Saving</small>
        </h1>
    </div>
    <!-- /demo-headline -->
    <div class="row">
        <div class="col-xs-12" id="screenView">
            <!-- Place <h1></h1> below -->
            <h1 class="demo-section-title text-uppercase text-center">Account
                Details</h1>
            <h6 class="text-center">${ accountNumber }</h6>
            <br/>
            <div class="row">
                <!-- 3/4 -->
                <!-- Balance -->
                <div class="col-xs-9">
                    <div class="col-xs-12">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Date</th>
                                <th>Type</th>
                                <th>Amount</th>
                                <th>Destination</th>
                                <th>Reference</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="row" varStatus="loop">
                                <tr>
                                    <td><c:out value="${ row.date }"></c:out></td>
                                    <td><c:out value="${ row.type }"></c:out></td>
                                    <td>$<c:out value="${ row.amount }"></c:out></td>
                                    <td><c:out
                                            value="${ row.destinationAccount }"></c:out></td>
                                    <td><c:out value="${ row.reference }"></c:out></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- 1/4 -->
                <div class="col-xs-3">
                    <div class="tile">
                        <a id="back"
                           href="${pageContext.request.contextPath}/transaction"
                           class="btn btn-lg btn-inverse text-uppercase btn-padding"><span
                                class="fui-arrow-left"></span> Back</a>
                    </div>
                    <div class="tile">
                        <a id="cancelTransactin"
                           href="${pageContext.request.contextPath}/logout"
                           class="btn btn-lg btn-danger text-uppercase btn-padding"><span
                                class="fui-cross"></span> Exit</a>
                    </div>
                </div>
            </div>
            <!-- // END OPTIONS-->
        </div>
        <!--  // END column-->
    </div>
    <!-- // END row-->
</div>
<!-- /container -->
<script src="js/jquery.min.js"></script>
</body>
</html>
