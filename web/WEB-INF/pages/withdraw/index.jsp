<!DOCTYPE html>
<%@include file="../taglibs.jsp" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>ATM System: Withdrawal Funds</title>
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
            <h1 class="demo-section-title text-uppercase text-center">Withdrawal
                Funds</h1>
            <h6 class="text-center">${ accountNumber }</h6>
            <div class="row">
                <!-- 3/4 -->
                <div class="col-xs-9">
                    <div class="row">
                        <div class="col-xs-4">
                            <div class="tile">
                                <a id="qc10"
                                   href="${pageContext.request.contextPath}/withdrawl?amount=10"
                                   class="btn btn-lg btn-primary text-uppercase btn-padding">&#36;
                                    10.00</a>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <div class="tile">
                                <a id="qc50"
                                   href="${pageContext.request.contextPath}/withdrawl?amount=50"
                                   class="btn btn-lg btn-primary text-uppercase btn-padding">&#36;
                                    50.00</a>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <div class="tile">
                                <a id="qc100"
                                   href="${pageContext.request.contextPath}/withdrawl?amount=100"
                                   class="btn btn-lg btn-primary text-uppercase btn-padding">&#36;
                                    100.00</a>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <h6>Click a button to get that amount of cash.</h6>
                            <h5>or input a multiple of $10. Must be lower than $1000</h5>
                            <input type="text" id="qcCustomNumber" class="form-control"
                                   placeholder="50.00"/>
                            <!-- Number Keys -->
                            <!-- TABLE -->
                            <div id="pinPad">
                                <table>
                                    <tr>
                                        <td colspan="5"><a id="btnConfirm" href="#"
                                                           class="btn btn-block btn-lg btn-primary text-uppercase">Confirm</a>
                                        </td>
                                        <td colspan="2"><a id="btnDelete" href="#"
                                                           class="btn btn-block btn-lg btn-default text-uppercase">Clear</a>
                                        </td>
                                    </tr>
                                </table>
                                <span style="color: red;">${ message }</span>
                            </div>
                            <!-- // Pin Pad -->
                        </div>
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
<script>
    $(document)
        .ready(
            function () {
                $("#btnConfirm")
                    .click(
                        function () {
                            window.location
                                .replace("${pageContext.request.contextPath}/withdrawl?amount="
                                    + $(
                                        "#qcCustomNumber")
                                        .val());
                        });
                $("#btnDelete").click(function () {
                    $("#qcCustomNumber").val('')
                });
            });
</script>
</body>
</html>
