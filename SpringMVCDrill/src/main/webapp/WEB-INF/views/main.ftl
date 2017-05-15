<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title></title>
    <!-- basic styles -->

    <link href="/static/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/static/assets/css/font-awesome.min.css"/>


    <!-- page specific plugin styles -->
    <!-- fonts -->

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"/>

    <!-- ace styles -->

    <link rel="stylesheet" href="/static/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="/static/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="/static/assets/css/ace-skins.min.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="assets/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->

    <script src="/static/assets/js/ace-extra.min.js"></script>
    <script src="/static/assets/js/ace-extra.min.js"></script>
    <script src="/static/assets/js/handlebars.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    ACE后台管理系统
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">

                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="assets/avatars/user.jpg" alt="Jason's Photo"/>
                        <span class="user-info">
									<small>欢迎光临,</small>
									Jason
								</span>

                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="icon-cog"></i>
                                设置
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <i class="icon-user"></i>
                                个人资料
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="#">
                                <i class="icon-off"></i>
                                退出
                            </a>
                        </li>
                    </ul>
                </li>

            </ul><!-- /.ace-nav -->
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <div class="sidebar" id="sidebar">

            <div class="sidebar-shortcuts" id="sidebar-shortcuts">
                <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                    <button class="btn btn-success">
                        <i class="icon-signal"></i>
                    </button>

                    <button class="btn btn-info">
                        <i class="icon-pencil"></i>
                    </button>

                    <button class="btn btn-warning">
                        <i class="icon-group"></i>
                    </button>

                    <button class="btn btn-danger">
                        <i class="icon-cogs"></i>
                    </button>
                </div>

                <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                    <span class="btn btn-success"></span>

                    <span class="btn btn-info"></span>

                    <span class="btn btn-warning"></span>

                    <span class="btn btn-danger"></span>
                </div>
            </div><!-- #sidebar-shortcuts -->
            <div id="sidebarMenu">
            </div>
        </div>

        <div class="main-content">
            <div class="page-content">
                <iframe id="iframe" name="main" src="" width="100%" allowtransparency="true"
                        height="100%" frameborder="0" scrolling="no" style="overflow:visible;"></iframe>
            </div><!-- /.page-content -->
        </div><!-- /.main-content -->
    </div><!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->


<script src="/static/assets/js/jquery-1.10.2.min.js"></script>
<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='/static/assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/static/assets/js/jquery-1.10.2.min.js'>" + "<" + "/script>");
</script>
<![endif]-->

<script type="text/javascript">
    if ("ontouchend" in document) document.write("<script src='/static/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="/static/assets/js/bootstrap.min.js"></script>
<script src="/static/assets/js/typeahead-bs2.min.js"></script>


<script src="/static/assets/js/ace-elements.min.js"></script>
<script src="/static/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script>
    //导航
    $(function () {

        //数据配置
        var sideBarData = {
            data: [
                {
                    menuid: "1",
                    menuname: "UIM权限",
                    menuurl: "/UIM/Index",
                    tobarString: "UIM权限",
                    iconName: "icon-stethoscope",
                    openState: "",
                    activeState: ""
                },
                {
                    menuid: "3",
                    menuname: "MQ消息",
                    menuurl: "/MQ/Index",
                    tobarString: "MQ消息",
                    iconName: "icon-phone",
                    openState: "",
                    activeState: ""
                },
                {
                    menuid: "4",
                    menuname: "接口测试",
//                    menuurl: "Interface/Index",
                    tobarString: "接口测试",
                    iconName: "icon-inbox",
                    openState: "",
                    activeState: "",
                    subData: [
                        {
                            menuid: "41",
                            menuname: "Http请求",
                            menuurl: "/http/index",
                            tobarString: "Http请求",
                            openState: "",
                            activeState: ""
                        }
                    ]
                }
//                ,
//                {
//                    menuid: "6",
//                    menuname: "我的账户",
//                    menuurl: "ljhy_wdzh.html",
//                    tobarString: "我的账户",
//                    iconName: "icon-user",
//                    openState: "",
//                    activeState: ""
//                }
            ]
        };
        //模板渲染
        function sideBarBuild() {
            var tpl = $("#_sidebarTpl").html();
            //预编译模板
            var template = Handlebars.compile(tpl);
            //var sideBarHtml = template("_sidebarTpl", sideBarData);
            var sideBarHtml = template(sideBarData);
            $("#sidebarMenu").html(sideBarHtml);
        }

        //初始化
        sideBarBuild();

//        //点击一级菜单
//        $(document).on('click', '.nav-list>li', function () {
//            var markid = $(this).data('markid');
//            _.each(sideBarData.data, function (sideBarDataItem) {
//                if (sideBarDataItem.menuid == markid) {
//                    if (sideBarDataItem.subData) {
//                        _.each(sideBarDataItem.subData, function (sideBarSubDataItem) {
//                            sideBarSubDataItem.activeState = '';
//                        });
//                        if (sideBarDataItem.openState == 'open') {
//                            sideBarDataItem.openState = '';
//                        } else {
//                            sideBarDataItem.openState = 'open';
//                        }
//                        if (sideBarDataItem.activeState == 'active') {
//                            sideBarDataItem.activeState = '';
//                        } else {
//                            sideBarDataItem.activeState = 'active';
//                        }
//                    } else {
//                        sideBarDataItem.activeState = 'active';
//                    }
//                } else {
//                    sideBarDataItem.openState = '';
//                    sideBarDataItem.activeState = '';
//                }
//                sideBarBuild();
//            })
//        });
//
//        //点击submenu子菜单
//        $(document).on('click', '.nav-list>li .submenu>li', function () {
//            var markid = $(this).data('markid');
//            _.each(sideBarData.data, function (sideBarDataItem) {
//                _.each(sideBarDataItem.subData, function (sideBarSubDataItem) {
//                    if (sideBarSubDataItem.menuid == markid) {
//                        _.each(sideBarData.data, function (sideBarDataItem) {
//                            sideBarDataItem.activeState = '';
//                        });
//                        sideBarDataItem.activeState = 'active';
//                        sideBarSubDataItem.activeState = 'active';
//                    } else {
//                        sideBarSubDataItem.activeState = '';
//                    }
//                });
//            });
//            sideBarBuild();
//            return false;
//        });

        //点击跳转
        $(document).on('click', '.nav-list a', function () {
            // setTab(this);
            changeSrc(this);
        });

//        //点击折叠
//        $(document).on('click', '#sidebar-collapse', function () {
//            var collapseIcon = $(this).children('i');
//            if ($("#sidebar").hasClass('menu-min')) {
//                $("#sidebar").removeClass('menu-min');
//                collapseIcon.attr('class', 'icon-double-angle-left');
//            } else {
//                $("#sidebar").addClass('menu-min');
//                collapseIcon.attr('class', 'icon-double-angle-right');
//            }
//        });

        function changeSrc(link) {
            document.getElementById("iframe").src = link;
        }
    })
</script>

<script id="_sidebarTpl" type="text/html">
    <ul class="nav nav-list">
        {{#each data}}
        <li data-markid="{{menuid}}" class="{{activeState}} {{openState}}">
            <a href="javascript:;" class="dropdown-toggle" menuid="{{menuid}}"
               menuname="{{menuname}}" menuurl="{{menuurl}}"
               tobarString="{{tobarString}}">
                <i class="{{iconName}}"></i>
                <span class="menu-text">{{menuname}}</span>
                {{#if subData}}
                <b class="arrow icon-angle-down"></b>
                {{/if}}
            </a>
            {{#if subData}}
            <ul class="submenu">
                {{#each subData}}
                <li data-markid="{{menuid}}"
                    class="{{activeState}} {{openState}}">
                    <a href="javascript:;" menuid="{{menuid}}" menuname="{{menuname}}"
                       menuurl="{{menuurl}}" tobarString="{{tobarString}}">
                        <i class="icon-double-angle-right"></i>
                        {{menuname}}
                    </a>
                </li>
                {{/each}}
            </ul>
            {{/if}}
        </li>
        {{/each}}
    </ul><!-- /.nav-list -->
    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
           data-icon2="icon-double-angle-right"></i>
    </div>
</script>
</body>
</html>
