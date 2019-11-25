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
                        Your Account Number</h1>
                    <input type="text" id="userPinInput" class="form-control"
                           maxlength="6" style="text-align: center;" required="true"/>
                    <div id="confirmPin">
                        <a href="#"
                           class="btn btn-block btn-lg btn-success text-uppercase">Confirm</a>
                    </div>
                    <div
                            style="display: block; padding-top: 150px; padding-bottom: 25px">
							<span class="text-uppercase text-center"><b>Upload CSV
									file to upload data account</b></span>
                        <form class="form-horizontal" method="POST"
                              action="${pageContext.request.contextPath}/upload"
                              enctype="multipart/form-data">
                            <input id="singleFileUploadInput" type="file" name="file"
                                   class="form-control-file" accept=".csv"
                                   style="padding: 20px 0px"/>
                            <button type="submit"
                                    class="btn btn-block btn-lg btn-info text-uppercase">Submit
                            </button>
                        </form>
                    </div>
                    <span style="color: red;">${ message }</span> <span
                        style="color: green;">${ notif }</span>
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
            function () {
                $("#confirmPin")
                    .click(
                        function () {
                            window.location
                                .replace("${pageContext.request.contextPath}/pin?an="
                                    + $(
                                        "#userPinInput")
                                        .val());
                        });
            });
</script>
</body>
</html>