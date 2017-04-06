<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title></title>
    <link href="/static/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/static/assets/js/jquery.min.js"></script>
    <script src="/static/assets/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container" style="padding: 15px">
    <div class="row" style="padding: 15px">
        <div class="col-md-4">
            <select name="resource" id="resource" class="form-control">
                <option value="risk">天网</option>
                <option value="risk2">天网2.0</option>
            </select>
        </div>
        <div class="col-md-4 input-group">
            <span class="input-group-addon" id="basic-addon1">ERP</span>
            <input type="text" name="pin" id="pin" class="form-control" placeholder="Erp"
                   aria-describedby="basic-addon1">
        </div>
        <button id="query" class="col-md-2 btn btn-primary">查询</button>
    </div>
    <div class="row" style="padding: 15px">
        <div class="col-md-8 input-group">
            <span class="input-group-addon" id="basic-addon1">权限码</span>
            <input type="text" id="codejudge" class="form-control" placeholder="Code"
                   aria-describedby="basic-addon1">
        </div>
        <div class="col-md-4">
            <label id="result">未知</label>
        </div>
    </div>

    <div class="row">
        <textarea id="response" class="form-control" rows="20">$!{uimResponse}</textarea>
    </div>
</div>
<script>
    $(document).ready(function () {
        $("#codejudge").blur(function () {
            var reponse = $("#response").val();
            var pattern = '"' + $(this).val() + '"';
            if ($(this).val() == "") {
                var label = document.getElementById("result");
                label.innerHTML = "空串";
                return
            }
            if (reponse.indexOf(pattern) >= 0) {
                var label = document.getElementById("result");
                label.innerHTML = "存在";
            } else {
                var label = document.getElementById("result");
                label.innerHTML = "不存在";
            }

        });

        $("#query").click(function () {
            $("#response").val("");
            var resource = $("#resource").val();
            var name = $("#pin").val();
            $.ajax({
                async: true,
                type: "POST",
                dataType: "json",
                url: "/UIM/queryCode",
                data: {pin: name, resource: resource},
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success: function (data) {
                    $("#response").val(data.uimResponse);
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