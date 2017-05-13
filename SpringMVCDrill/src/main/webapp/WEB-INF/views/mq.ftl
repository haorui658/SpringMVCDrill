<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>MQ发送</title>
    <link href="/static/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/static/assets/js/jquery.min.js"></script>
    <script src="/static/assets/js/bootstrap.min.js"></script>

    <link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet"/>
    <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
</head>
<body>

<div class="container" style="padding: 15px">
    <div class="row">
        <div class="col-md-4 input-group">
            <span class="input-group-addon" id="basic-addon1">ERP</span>
            <input type="text" name="pin" id="pin" class="form-control" placeholder="Erp"
                   aria-describedby="basic-addon1">
        </div>
        <a href="/MQ/add">test</a>
        <button id="query" class="col-md-2 btn btn-primary">新增</button>
    </div>
    <div class="row table-responsive" style="padding: 15px">
        <table id="person" class="table">
            <thead>
            <tr>
                <td>No</td>
                <td>姓名</td>
                <td>门派</td>
                <td>性别</td>
                <td>职业</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>


<!-- 发送模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">发送MQ</h4>
            </div>
            <div class="modal-body">在这里添加一些文本</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script>
    $(document).ready(function () {

        var table = $("#person").dataTable({    // 和<table>的id对应，指定初始化datatables。
            "pagingType": "full_numbers",
            language: {
                lengthMenu: '<select>' + '<option value="1">1</option>' + '<option value="10">10</option>' + '<option value="30">30</option>' + '<option value="50">50</option></select>条',//左上角的分页大小显示。
                search: '<span class="label label-success">搜索：</span>',//右上角的搜索文本，可以写html标签

                paginate: {//分页的样式内容。
                    previous: "上一页",
                    next: "下一页",
                    first: "<<",
                    last: ">>"
                },

                zeroRecords: "没有内容",//table tbody内容为空时，tbody的内容。
                //下面三者构成了总体的左下角的内容。
                info: "共_PAGES_ 页，第_START_ 到第 _END_条 ( _TOTAL_/_MAX_) ",//左下角的信息显示，大写的词为关键字。
                infoEmpty: "0条记录",//筛选为空时左下角的显示。
                infoFiltered: ""//筛选之后的左下角筛选提示，
            },
            //给table内自定义按钮
            "columnDefs": [
                {
                    // targets用于指定操作的列，从第0列开始，-1为最后一列，这里第六列
                    // return后边是我们希望在指定列填入的按钮代码
                    "targets": -1,
                    "render": function (data, type, row, meta) {
                        return "<input type = 'button' id = 'delBtn' value = '删除'>" +
                                "<input type = 'button' id = 'sendBtn' value = '发送'  data-toggle='modal' data-target='#myModal'>"// onclick=popSendWindow("+row.id+")> "
                    }
                }
            ],
            //给列赋值，这里的列名需要和data的数据名对应
            //注意这里第六列数据指定为null，用来存放我们加入的按钮
            "columns": [
                {"data": "id"},
                {"data": "name"},
                {"data": "app"},
                {"data": "topic"},
                {"data": "createDate"},
                {"data": null}
            ],
            ajax: {
                url: '/MQ/query',
                dataSrc: ''
            }
        });


        //为我们生成的按钮绑定方法，这里是弹出姓名和职业的对话框
        $("#person tbody").on("click", "#delBtn", function () {
            //获取行
            var row = $("table#person tr").index($(this).closest("tr"));
            //获取某列（从0列开始计数）的值
            var name = $("table#person").find("tr").eq(row).find("td").eq(1).text();
            var job = $("table#person").find("tr").eq(row).find("td").eq(5).text();
            alert(row + name + "是" + job);
        });
    });

    function popSendWindow(id) {
        alert(id);
    }

</script>
</body>