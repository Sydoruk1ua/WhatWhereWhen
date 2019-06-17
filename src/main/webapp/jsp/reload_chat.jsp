<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%String login = (String) session.getAttribute("user"); %>
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

<p id="result"></p>
<div id="list" class="always-middle-chat" style="overflow-y:auto;">
    <div id="content"></div>
</div>

<input style="display: none; " type="text" id="u" value="<%=login%>">
<textarea id='h' class="textbox-chat" style=""
          onkeydown="if (event.keyCode == 13){ document.getElementById('btn').click(); return false}"></textarea>
<input type="button" class="btn-chat" style="" id="btn" value="Enter"
       onclick="send_msg(); olist = document.getElementById('list'); olist.scrollTop = olist.scrollHeight;"/>
<c:forEach var="message" items="${listM}">
    ${message}
</c:forEach>

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
        };
        xmlhttp.send(null);
    }
</script>
<script>
    setInterval(reload, 1000);
</script>
</body>
</html>
