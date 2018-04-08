<%@ page language="java" contentType="text/html; charset=GB18030"
         pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=250, initial-scale=1.5, user-scalable=no">
    <meta http-equiv="Content-Type" content="text/html; charset=GB18030">
    <title></title>

    <%--<link rel="stylesheet" type="text/css" href="/c5_20171220.css" />--%>
    <link rel="stylesheet" href="http://www.pniao.com/View/style/mov.css"  />


</head>
<body>
<div >
    <h3 >
       ”∞ ”√˚: ${title }
    </h3>

</div>


<%--<table class="dataintable">--%>
    <%--<tbody>--%>
    <%--<tr>--%>
        <%--<td>--%>
           <%----%>
        <%--</td>--%>

    <%--</tr>--%>

    <%--</tbody></table>--%>

${detail }


<script>
    function log(content) {
        var logContainer = document.getElementById('log');
        var p = document.createElement('p');
        p.textContent = content;
        logContainer.appendChild(p);
    }

    log('body width:' + document.body.clientWidth)
    log(document.querySelector('[name="viewport"]').content)
</script>
</body>
</html>