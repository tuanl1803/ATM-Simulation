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
        </h1>
    </div>
    <!-- /demo-headline -->
    <div class="row">
        <div class="col-xs-12" id="screenView">
            <!-- Place <h1></h1> below -->

            <!-- Replace Video with Animated Gif or Animated SVG -->
            <div class="row">
                <div class="col-xs-8 text-center">
                    <h1 class="demo-section-title text-uppercase text-center">Input
                        Amount Transfer</h1>
                    <input id="destination" type="hidden" value="${ destination }">
                    <input type="text" id="amountInput" class="form-control"
                           maxlength="4" style="text-align: center;" required="true"/>
                    <div id="confirmAmount">
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
    $(document)
        .ready(
            function() {
                $("#confirmAmount")
                    .click(
                        function() {
                            window.location
                                .replace("${pageContext.request.contextPath}/transfer-confirm?destination="
                                    + $(
                                        "#destination")
                                        .val()
                                    + "&amount="
                                    + $(
                                        "#amountInput")
                                        .val());
                        });
            });
</script>
</body>
</html>