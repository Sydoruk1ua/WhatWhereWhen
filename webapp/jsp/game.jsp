<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Game</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="../css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="../css/style.css" rel="stylesheet">
    <!-- MDBootstrap Datatables  -->
    <link href="../css/addons/datatables.min.css" rel="stylesheet">

</head>
<body>
<%--HEADER--%>
<jsp:include page="common/header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-1-2">
            test1
        </div>
        <div class="col-1-2">
            test2
        </div>
    </div>
    <div class="row">
        <div class="col-1-3">
            <c:set var="count_messages" value="${fn:length(messageList)}"/>
            <p><textarea name="textarea" cols="100" rows="50">
                <c:forEach var="i" begin="1" end="${count_messages}">
                    <c:set var="message" value="${messageList[count_messages-i]}"/>
                    <c:out value="${message.userEmail} : ${message.value}"/>
                </c:forEach>
   </textarea></p>

        </div>
        <div class="col-1-4">

        </div>
        <div class="col-1-4">
            <button class="open-button" onclick="openForm()">Chat</button>
            <div class="form-popup" id="myForm">
                <form action="app" class="form-container">
                    <input type="hidden" name="command" value="game"/>
                    <h1>Chat</h1>
                    <input type="hidden" name="nickname" id="nickname" value="${sessionScope.user}"/>
                    <label for="msg"><b>Message</b></label>
                    <textarea id="msg" placeholder="Type message.." name="msg" required></textarea>

                    <button type="submit" class="btn">Send</button>
                    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
                </form>
            </div>
        </div>
    </div>
</div>


<!-- SCRIPTS -->
<!-- JQuery -->
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="../js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="../js/mdb.min.js"></script>
<!-- MDBootstrap Datatables  -->
<script type="text/javascript" src="../js/addons/datatables.min.js"></script>
<script>
    function openForm() {
        document.getElementById("myForm").style.display = "block";
    }

    function closeForm() {
        document.getElementById("myForm").style.display = "none";
    }

    function update() {
        $.get("app?command=reloadchat");
    }

    setInterval(function () {
        update();
    }, 10000);
</script>
</body>
</html>
<%--<iframe src="app?command=reloadchat" height="200" width="300">

</iframe>
<p id="result"></p>
<p style="float:left; margin-left:26%;"> Welcome, <%=login%>. </p>
<div id="list" class="always-middle-chat" style="overflow-y:auto;">
    <div id="content"></div>
</div>
<form action="app" class="text-light navbar-brand">
    <input type="text" id="u" value="<%=login%>">
    <textarea id='h' class="textbox-chat"
              onkeydown="if (event.keyCode == 13){ document.getElementById('btn').click(); return false}"></textarea>
    <input type="button" class="btn-chat" style="" id="btn" value="Enter"
           onclick="send_msg(); olist = document.getElementById('list'); olist.scrollTop = olist.scrollHeight;"/>
</form>
111111111111111111111111111111111111111111111111111111111111111111111
<c:forEach  items="${applicationScope.listM}" var="message">
    <tr>
        <td>${message}</td>
    </tr>
</c:forEach>--%>
<%--<script>
    function update() {
        $.get("app?command=game", { from : document.getElementById('userId').getAttribute('datafld') }, function(responseText) {
            $("#messageDiv").append(responseText);
        });
    }
    setInterval(update, 1000);
    $(document).on("click", "#sendButton", function() {
        $.post("app?command=game", { from : document.getElementById('userId').getAttribute('datafld'), message :
            document.getElementById('message').value });
    });
</script>--%>
<%--<div id="userId" datafld="${sessionScope.user}"></div>
<div>Hello, ${sessionScope.user}. Type your message below and press "Send" to broadcast it.</div>
<form action="app" class="text-light navbar-brand">
    <input type="hidden" name="command" value="game"/>
    <input id="message" type="text" value="message">
    <input id="sendButton" type="button" value="Send">
    <div id="messageDiv"></div>
   &lt;%&ndash; <input type="submit" class="btn btn-info btn-md" value=<fmt:message key="game"/>>&ndash;%&gt;
</form>

    function send_msg() {
        var login = document.getElementById("u").value;
        var msg = document.getElementById('h').value;
        olist = document.getElementById('list');
        if (msg.length == 0) return;
        ocontent = document.getElementById('content');
        document.getElementById('h').value = '';

        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "app?command=chatmsg&login=" + login + "&msg=" + msg, true);
        xmlhttp.send(null);
    }

    function reload() {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "app?command=reloadchat", true);
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("content").style.marginLeft = "10px";
                document.getElementById("content").innerHTML = xmlhttp.responseText;
                var list = document.getElementById('list');
                list.scrollTop = list.scrollHeight;
            }
        }
        xmlhttp.send(null);
    }
</script>
<%--<script>
    setInterval(reload, 1000);
</script>--%>