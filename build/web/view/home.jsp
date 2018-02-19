<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
     <link rel="icon" href="img/LOGO1.png">
     
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
     
     
    <title>SISCONS</title>

    <!-- Bootstrap Core CSS -->
    <link href="layout/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
        
    <link href="layout/css/sb-admin.css" rel="stylesheet">
    <!-- Morris Charts CSS -->
    <link href="layout/css/plugins/morris.css" rel="stylesheet">
    
    <!-- Custom Fonts -->
    <link href="layout/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    
    <link href="bootstrap/css/home.css" rel="stylesheet">


</head>

<body id="fundoBranco">

    <div id="wrapper" >

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" id="navbar">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    
                </button>
                <a class="navbar-brand" href="UserController?action=inicio" id="textos">
                 <img src="img/LOGO1.png" id="logoNavbar">
                             
                </a>
                
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav"> 
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="textos" ><i class="fa fa-user"></i> <c:out value="${usuario.getNome()}" /> <b class="caret"></b></a>
                    <ul class="dropdown-menu" id="dropdown">
                        <li>
                            <a href="UserController?action=perfil" id="dropdownColor"><i class="fa fa-fw fa-user"></i> Perfil</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="UserController?action=sair" id="dropdownColor"><i class="fa fa-fw fa-power-off"></i> Sair</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse" >
                <ul class="nav navbar-nav side-nav" id="asideColor">
                    <li>
                        <a href="UserController?action=inicio" id="faColor"><i class="fa fa-home" ></i> Início</a>
                    </li>
                    <li>
                        <a href="UserController?action=cadastro" id="faColor"><i class="fa fa-fw fa-edit"></i> Cadastro de Servidor</a>
                    </li>
                    <li>
                        <a href="UserController?action=edit" id="faColor"><i class="fa fa-fw fa-edit" ></i> Modificar / Listar Servidor</a>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo" id="faColor"><i class="fa fa-file-text-o" ></i> Relatórios <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                            <li>
                                <a href="UserController?action=relatorio&type=coordenadores" id="faColor">Coordenadores</a>
                            </li>
                            <li>
                                <a href="UserController?action=relatorio&type=tecnicos" id="faColor">Técnicos</a>
                            </li>
                             <li>
                                 <a href="javascript:;" data-toggle="collapse" data-target="#mult2" id="faColor">Ex Servidores <i class="fa fa-fw fa-caret-down"></i></a>
                                 <ul id="mult2" class="collapse">
                                        <li>
                                            <a href="UserController?action=relatorio&type=exprofessores" id="faColor">Professores</a>
                                        </li>
                                        <li>
                                            <a href="UserController?action=relatorio&type=extecnicos" id="faColor">Técnicos</a>
                                        </li>
                                 </ul>
                            </li>
                            <li>
                                 <a href="javascript:;" data-toggle="collapse" data-target="#mult" id="faColor">Professores <i class="fa fa-fw fa-caret-down"></i></a>
                                 <ul id="mult" class="collapse">
                                        <li>
                                            <a href="UserController?action=relatorio&type=porcurso" id="faColor"> Por Curso</a>
                                        </li>
                                        <li>
                                            <a href="UserController?action=relatorio&type=substituto" id="faColor">Substituto</a>
                                        </li>
                                        <li>
                                            <a href="UserController?action=relatorio&type=voluntario" id="faColor">Voluntário</a>
                                        </li>
                                        <li>
                                            <a href="UserController?action=relatorio&type=grade" id="faColor">Grade</a>
                                        </li>
                                        <li>
                                            <a href="UserController?action=relatorio&type=todos"  id="faColor">Todos</a>
                                        </li>
                                 </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">
                <c:if test="${pageContent !=  NULL}">
                    <c:import url = "${pageContent}"/>
                </c:if> 
                
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    
    
        <!-- Main Footer 
            <footer  id="footer1">
               
                <strong>Copyright &copy; 2017 <a href="#" >| Desenvolvido por <strong>EMP</strong> TEAM |</a></strong>
              
            </footer>
        -->

    <!-- jQuery -->
    <script src="layout/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="layout/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="layout/js/plugins/morris/raphael.min.js"></script>
    <script src="layout/js/plugins/morris/morris.min.js"></script>
    <script src="layout/js/plugins/morris/morris-data.js"></script>

</body>

</html>
