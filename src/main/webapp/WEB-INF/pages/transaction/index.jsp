<!DOCTYPE html>
<%@include file="../taglibs.jsp" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>ATM System Options: Account Details</title>
    <!-- Loading Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="demo-headline" style="padding: 0px;">
    </div>
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
                        <div class="tile">
                            <h4 class="text-uppercase balance">
                                <span>Balance</span>$${ balance }
                            </h4>
                        </div>
                    </div>
                    <div class="col-xs-4">
                        <a href="${pageContext.request.contextPath}/transfer-destination">
                            <div class="tile">
                                <h3 class="tile-title">Transfer</h3>
                                <p>Transfer funds to another account.</p>
                            </div>
                        </a>
                    </div>
                    <div class="col-xs-4">
                        <a href="${pageContext.request.contextPath}/view-transaction">
                            <div class="tile">
                                <h3 class="tile-title">View Last ${ nTransaction } Transaction</h3>
                                <p>View Last ${ nTransaction } Transaction.</p>
                            </div>
                        </a>
                    </div>
                    <!-- // END OPTIONS -->
                </div>
                <!-- 1/4 -->
                <div class="col-xs-3">
                    <div class="tile">
                        <a id="cancelTransactin"
                           href="${pageContext.request.contextPath}/logout"
                           class="btn btn-lg btn-danger text-uppercase btn-padding"><span
                                class="fui-cross"></span> Exit</a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-9">
                    <span class="text-center col-xs-12" style="color: red;">${ message }</span>
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
