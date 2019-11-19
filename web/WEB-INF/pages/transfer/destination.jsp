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
                        Destination Account Number</h1>
                    <input type="text" id="userPinInput" class="form-control"
                           maxlength="6" style="text-align: center;" required="true"/>
                    <div id="confirmPin">
                        <a href="#"
                           class="btn btn-block btn-lg btn-success text-uppercase">Confirm</a>
                    </div>
                    <div id="cancelTransaction">
                        <a href="${pageContext.request.contextPath}/transaction"
                           class="btn btn-block btn-lg btn-danger text-uppercase"><span
                                class="fui-cross"></span> Cancel</a>
                    </div>
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
<script>
    videojs.options.flash.swf = "js/video-js.swf";
    $(document)
        .ready(
            function () {
                $("#confirmPin")
                    .click(
                        function () {
                            window.location
                                .replace("${pageContext.request.contextPath}/transferAmount?destination="
                                    + $(
                                        "#userPinInput")
                                        .val());
                        });
            });
</script>
</body>
</html>