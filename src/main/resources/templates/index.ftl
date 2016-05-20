<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Study mybatis </title>
    <link href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="/static/app.css" rel="stylesheet">
</head>
<#macro jsMac>
<script type="text/javascript" src="/webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="/static/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript" src="/static/app.js"></script>

</#macro>
<body>
<div id="modal-form" class="modal fade" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-6 b-r">
                        <h3 class="m-t-none m-b">登录</h3>

                        <p>欢迎登录本站(⊙o⊙)</p>

                        <form role="form">
                            <div class="form-group">
                                <label>用户名：</label>
                                <input type="email" placeholder="请输入用户名" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>密码：</label>
                                <input type="password" placeholder="请输入密码" class="form-control">
                            </div>
                            <div>
                                <button class="btn btn-sm btn-primary pull-right m-t-n-xs" type="submit"><strong>登录</strong>
                                </button>
                                <label>
                                    <div class="icheckbox_square-green" style="position: relative;"><input type="checkbox" class="i-checks" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins></div>自动登录</label>
                            </div>
                        </form>
                    </div>
                    <div class="col-sm-6">
                        <h4>还不是会员？</h4>
                        <p>您可以注册一个账户</p>
                        <p class="text-center">
                            <a href="form_basic.html"><i class="fa fa-sign-in big-icon"></i></a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="main-content">
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
        打开示例窗口
    </button>
    <button class="btn btn-primary" id="newUser">增加新用户</button>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>email</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td class="trade-buttons">
                <button class="btn btn-primary" name="delete">Del</button>
                <button class="btn btn-primary">Update</button>
            </td>
        </tr>
        </#list>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="2">Total</td>
            <td class="number">${users?size}</td>
            <td></td>
        </tr>
        </tfoot>
        <tbody></tbody>
    </table>
</div>
</body>
<@jsMac/>
<script>
    $("button[name=delete]").click(function () {
        var tr = $(this).parents("tr");
        var id = tr.find("td:eq(0)").html();//要删除的ID
        swal({
            title: "您确定要删除这条信息吗",
            text: "删除后将无法恢复，请谨慎操作！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "删除",
            closeOnConfirm: false
        }, function () {

            $.delete("/user/" + id, function () {
                swal("删除成功！", "您已经永久删除了这条信息。", "success");
                tr.remove();
            });

        });
    });


    $("#newUser").click(function () {

    });
</script>
</html>