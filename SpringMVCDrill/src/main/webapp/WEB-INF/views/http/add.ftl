<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title></title>
    <link href="/static/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/static/assets/js/jquery.min.js"></script>
    <script src="/static/assets/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container" style="padding: 15px">
    <div class="row" style="padding: 15px">
        <form action="/http/save" method="post">
            <div class="form-group">
            <#if editInfo?? > <label for="Id">ID</label>
                <input class="form-control" type="text" name="Id" id="Id" readonly="readonly"
                       value="${editInfo.id}"></#if>
                <label for="categoryId">类别</label>
                <input class="form-control" type="text" name="category" id="categoryId"<#if editInfo??>
                       value="${editInfo.category}"</#if>>
                <label for="nameId">名称</label>
                <input class="form-control" type="text" name="name" id="nameId"<#if editInfo??>
                       value="${editInfo.name}"</#if>>
                <label for="urlId">URL</label>
                <input class="form-control" type="text" name="url" id="urlId"<#if editInfo??>
                       value="${editInfo.url}"</#if>>
                <label for="methodId">Method</label>
                <select name="method" id="methodId" class="form-control">
                    <option value="POST">POST</option>
                    <option value="GET">GET</option>
                </select>
                <label for="cookieTypeId">Cookie类型</label>
                <input class="form-control" type="text" name="cookieType" id="cookieTypeId"<#if editInfo??>
                       value="${editInfo.cookieType!}"</#if>>
                <label for="createrId">创建人</label>
                <input class="form-control" type="text" name="creater" id="createrId"<#if editInfo??>
                       value="${editInfo.creater}"</#if>>
                <label for="remarkId">备注</label>
                <input class="form-control" type="text" name="remark" id="remarkId"<#if editInfo??>
                       value="${editInfo.remark!}"</#if>>

                <p class="help-block">Example block-level help text here.</p>
            </div>
            <button type="button" class="btn btn-default" onclick="window.location='/http/index'">返回</button>
            <button type="submit" class="btn btn-default">保存</button>
        </form>
    </div>
</div>
<script>
    $(document).ready(function () {
    <#if editInfo??>
        $("#methodId").val("<#if editInfo.method == "GET">GET<#else>POST</#if>");
    </#if>
    });
</script>
</body>