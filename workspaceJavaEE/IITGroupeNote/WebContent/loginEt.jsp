<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Teliphony| Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="Admin/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="Admin/icone/font-awesome-4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="Admin/icone/ionicons-2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="Admin/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="Admin/plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body  class="hold-transition login-page">
    
    <!-- jQuery 2.1.4 -->
    <script src="Admin/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="Admin/bootstrap/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="Admin/plugins/iCheck/icheck.min.js"></script>

           <br> 
               <div class="row">
                <div class="col-xs-2">
                   </div>
                <div class="col-xs-8">
                  <div class="alert alert-danger alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <h4><i class="icon fa fa-ban"></i> Alert!</h4>
                 cdcd
                  </div>
                </div>
               </div>

    <div class="login-box">
<!-- /.login-logo -->
      <div class="login-box-body">
      <div class="login-logo">
        <p><img src="logo/iitGnote.png" width="200"  >     &nbsp; </p>
      </div>
        <p class="login-box-msg">Connectez-vous pour démarrer votre session</p>
        <form action="#" method="post">
          <div class="form-group has-feedback">
            <input type="email" class="form-control" placeholder="Email" name ="email">
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control" placeholder="Mot de passe" name ="motpasse">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="row">
            <div class="col-xs-8">
              <div class="checkbox icheck">
                <label>
                  <input type="checkbox"> Garder ma session active

                </label>
              </div>
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat">Connexion</button>
            </div><!-- /.col -->
          </div>
        </form>

        <div class="social-auth-links text-center"></div><!-- /.social-auth-links -->

        <a href="#">J'ai oublié mon mot de passe</a><br>
        

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
 
  </body>
</html>
