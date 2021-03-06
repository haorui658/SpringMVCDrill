<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title></title>
    <link href="/static/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/static/assets/js/jquery.min.js"></script>
    <script src="/static/assets/js/bootstrap.min.js"></script>
    <script src="/static/assets/js/aceEditor/ace.js"></script>
    <script src="/static/assets/js/aceEditor/mode-json.js"></script>
    <script src="/static/assets/js/aceEditor/worker-json.js"></script>
</head>
<body>
<div class="container" style="padding: 15px">
<#if editInfo.id??>
    <div class="row">
        <label for="Id">ID</label>
        <input class="form-control" type="text" name="id" id="Id" readonly="readonly"
               value="${editInfo.id}">
    </div>
</#if>
    <div class="row">
        <div class="col-md-6 input-group">
            <label for="nameId">名称</label>
            <input class="form-control" type="text" name="name" id="nameId"
            <#if (editInfo.name)??>
                   value="${editInfo.name}"
            </#if>
            >
        </div>
        <div class="col-md-6 input-group">
            <label for="createrId">创建人</label>
            <input class="form-control" type="text" name="creater" id="createrId"
            <#if (editInfo)??>
                   value="${editInfo.creater}"
            </#if>
            >
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-6 input-group">
        <label for="parameterId">入参</label>
        <div id="jsoneditor" style="width:100%;height:200px"></div>
    </div>
    <div class="col-md-6 input-group">

        <label for="expectResponseId">期望结果</label>
        <textarea class="form-control" rows="8" name="expectResponse"
                  id="expectResponseId">${editInfo.expectResponse?html}</textarea>
    </div>
</div>
<div class="row">
    <div class="col-md-4 button-bar col-md-offset-10">
        <button type="button" class="btn btn-default"
                onclick="window.location='/http/userCase/${editInfo.infoId}'">返回
        </button>
        <button id="invoke" type="button" class="btn btn-default">调用</button>
        <button id="save" type="button" class="btn btn-default">保存</button>
    </div>
</div>
</div>
<script>
    $(document).ready(function () {
        var editor = ace.edit("jsoneditor");
//        editor.setTheme("ace/theme/twilight");
        editor.getSession().setMode("ace/mode/json");
    <#if (editInfo.requestParameter)??>
        editor.setValue(JSON.stringify(${editInfo.requestParameter}));
    </#if>

        $("#invoke").click(function () {
            $("#expectResponseId").val("");
            var parameter = editor.getSession().getValue();
            $.ajax({
                async: true,
                type: "POST",
                dataType: "text",
                url: "/http/userCase/request/${editInfo.id}",
                data: {param: parameter},
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success: function (data) {
                    $("#expectResponseId").val(data);
                    return false;
                },
                error: function (data, status, e) {
                    alert(e.message);
                }
            });
        });
        $("#save").click(function () {
            var saveData = {
                id: $("#Id").val(),
                name: $("#nameId").val(),
                creater: $("#createrId").val(),
                requestParameter: editor.getSession().getValue(),
                expectResponse: $("#expectResponseId").val(),
                infoId: ${editInfo.infoId}
            };
            $.post("/http/userCase/save", saveData, function (data, status) {
                if (data == 'success') {
                    window.location.href = "/http/userCase/" + ${editInfo.infoId};
                }
//                console.log(result)
            }, 'text');
        });
    });

</script>
</body>