<!DOCTYPE html>
<%@include file="../taglibs.jsp" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>ATM System Login: Input Pin</title>
    <!-- Loading Bootstrap -->
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

            <!-- Replace Video with Animated Gif or Animated SVG -->
            <div class="row">
                <div class="col-xs-8 text-center"
                     style="border-right: solid 3px #CCC">
                    <h1 class="demo-section-title text-uppercase text-center">Input
                        Your PIN</h1>
                    <form class="form-horizontal" method="POST"
                          action="${pageContext.request.contextPath}/login">
                        <input name="accountNumber" type="hidden"
                               value="${ accountNumber }"> <input type="password"
                                                                  id="userPinInput" name="pin" class="form-control"
                                                                  maxlength="6"
                                                                  style="text-align: center;" required="true"/>
                        <div id="confirmPin">
                            <button type="submit"
                                    class="btn btn-block btn-lg btn-success text-uppercase">Confirm
                            </button>
                        </div>
                    </form>
                    <span style="color: red;">${ message }</span>
                    <!-- // Pin Pad -->
                </div>
                <div class="col-xs-4">
                    <div style="margin-top: 8rem;">
                        <img src="img/CardInsertedGreenLight.png" style="width: 16em;"/>
                    </div>
                </div>
                <!-- /.col-xs-4 -->
            </div>
            <!-- // END login screen  -->
        </div>
    </div>
    <!-- // END row-->
</div>
<!-- /container -->
<script src="js/jquery.min.js"></script>
</body>
</html>