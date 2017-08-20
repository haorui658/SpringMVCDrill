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
    <script src="/static/assets/js/aceEditor/mode-groovy.js"></script>

</head>
<body>
<div class="row">
    <div class="col-md-6 input-group">
        <label for="parameterId">入参</label>
        <div id="groovyeditor" style="width:100%;height:500px"></div>
    </div>
    <div class="col-md-6 input-group">
        <label for="parameterId">输出</label>
        <div id="jsoneditor2" style="width:100%;height:500px"></div>
    </div>
</div>
<div class="row">
    <div class="col-md-4 button-bar col-md-offset-10">
        <button id="invoke" type="button" class="btn btn-default">调用</button>
        <button id="save" type="button" class="btn btn-default">保存</button>
    </div>
</div>
</div>
<script>
    $(document).ready(function () {
        var editor = ace.edit("groovyeditor");
        editor.getSession().setMode("ace/mode/groovy");

        $("#invoke").click(function () {
            var parameter = editor.getSession().getValue();
            $.ajax({
                async: true,
                type: "POST",
                dataType: "text",
                url: "/labelHelper/replace",
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

    });

</script>
</body>