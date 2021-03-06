<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎登录后台管理系统</title>

    <!-- basic styles -->
    <link href="/static/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/static/assets/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/static/assets/css/ace.min.css" rel="stylesheet" type="text/css"/>
    <link href="/static/assets/css/ace-rtl.min.css" rel="stylesheet" type="text/css"/>

</head>
<body class="login-layout ljhy_login">

<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1 class="login_logo">
                            <span class="blue app_name">后台管理系统</span>
                        </h1>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative login_area">
                        <div id="login-box" class="login-box visible ">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-coffee green"></i>
                                        请输入登录信息
                                    </h4>
                                    <form  method="post" action="/doLogin">
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-left">
															<input name="userName" type="text" class="form-control"
                                                                   placeholder="用户名"/>
															<i class="icon-user"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-left">
															<input name="password" type="password" class="form-control"
                                                                   placeholder="密码"/>
															<i class="icon-lock"></i>
														</span>
                                            </label>

                                            <div class="space"></div>

                                            <div class="clearfix">
                                                <label class="inline">
                                                    <input type="checkbox" class="ace"/>
                                                    <span class="lbl">记住密码</span>
                                                </label>

                                                <button type="submit"
                                                        class="width-35 pull-right btn btn-sm btn-primary">
                                                    <i class="icon-key"></i>
                                                    登录
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>

                                </div><!-- /widget-main -->

                            </div><!-- /widget-body -->
                        </div><!-- /login-box -->
                    </div><!-- /widget-body -->
                </div><!-- /signup-box -->
            </div><!-- /position-relative -->
        </div>
    </div><!-- /.col -->
</div><!-- /.row -->
</div>
</div><!-- /.main-container -->

</body>
</html>