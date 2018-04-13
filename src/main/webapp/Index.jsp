<%@ page language="java" contentType="text/html; charset=GB18030"
         pageEncoding="GB18030" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=250, initial-scale=1.5, user-scalable=no">
    <meta http-equiv="Content-Type" content="text/html; charset=GB18030">
    <title> 影范电影 最新中英字幕电影美剧下载 热门电影推荐</title>
    <meta name="description" content="影范电影 -每日更新最新中文字幕电影，剧集，动漫，纪录片，分享高清电影下载，百度网盘电影，磁力电影下载，盘点热门电影合集。">
    <%--<link rel="stylesheet" type="text/css" href="/c5_20171220.css" />--%>
    <link rel="shortcut icon" href="http://my-photos.changs1992.cn/bitbug_favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="http://www.pniao.com/View/style/mov.css"/>
    <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <script>
        (adsbygoogle = window.adsbygoogle || []).push({
            google_ad_client: "ca-pub-1900874537947892",
            enable_page_level_ads: true
        });
    </script>

</head>
<body>
<div>
    <h3>
        影视名: ${title }
    </h3>

</div>



<div class="mainBox movieFlag movieOne sizeMovieOne" id="movieFlag26462"
     style="border: 0px; padding: 20px 5px 5px; width: 1409px;">

    <div class="clear"></div>
    <div class="movInfoOuter">

        ${movInfoOuter }
    </div>
    <div class="mobile_thumb"></div>
    <div class="clear"></div>

    <div class="clear"></div>

    <div class="clear"></div>
    <div class="briefOuter">
        <div class="briefTitle">简介</div>
        <div class="briefCnt">
            ${descb }
        </div>
    </div>

</div>

<div>
    <h3>
        提示:
    </h3>
</div>
<div>
    磁力下载
</div>
<div>

    1、直接点击，会出现弹出窗提醒下载。
</div>
<div>
    2、PC端在链接处点击右键,
</div>
<div>
    在弹出的菜单中-&gt;选择复制链接地址。
</div>
<div>
    3、若是移动端长按链接,
</div>
<div>
    出现弹出窗-&gt;选择复制链接地址
</div>
<div>
    4、若是用迅雷下载失败，
</div>
<div>
    可能该资源已被迅雷阻断，建议用115、utorrent下载

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