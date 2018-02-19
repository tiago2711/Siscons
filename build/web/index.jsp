<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="utf-8">
            <title>SISCONS</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta name="description" content="">
            <meta name="author" content="">
            <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
            <link rel="stylesheet" href="bootstrap/css/skin-blue.min.css">


            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

            <link rel="stylesheet" href="bootstrap/css/AdminLTE.min.css">

            <link rel="stylesheet" href="bootstrap/css/skin-blue.min.css">

            <link href="bootstrap/css/global.css" rel="stylesheet">
            
            <link href="bootstrap/css/login.css" rel="stylesheet">

            <link rel="icon" href="img/LOGO1.png">

        </head>

        <body id="colorBackground">
           
            <div class="container" >

                          
                <img src="img/LOGO1.png" id="logo">
                <form class="form-signin" method="post" action="AuthenticateController?action=logon">
                    <h2 class="form-signin-heading">Identifique-se</h2>

                    <span class="fa fa-envelope" id="lock" aria-hidden="true"><label>Email</label></span>
                    <input type="text" class="input-block-level" name="email" required="true">

                    <span class="fa fa-lock" aria-hidden="true" id="lock"><label>Senha</label></span>
                    <input type="password" class="input-block-level" name="password" required="true">


                    <button class="btn btn-group" type="submit" id="btn_login">Entrar</button>

                    <br>
                    <h5>Esqueceu sua senha? Clique <a href="#">aqui</a></h5>


                </form>
            </div> <!-- /container -->

            <script src="bootstrap/js/jquery.js"></script>

        </body>
        
    </html>

