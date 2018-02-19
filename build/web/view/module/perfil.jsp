<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<section class="content-header">
    <h1>
      Perfil
    </h1>
    <ol class="breadcrumb">
      <li><a href="UserController?action=inicio">Inicio</a></li>
      <li class="active">Perfil</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <div class="box box-primary">
       
   
    <form class="form-horizontal" action="UserController?action=add" method="post">

        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Nome</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="name" placeholder="Nome" name="name">
          </div>
        </div>
        <div class="form-group">
          <label for="email" class="col-lg-2 control-label">Email</label>
          <div class="col-lg-10">
            <input type="email" class="form-control" id="email" placeholder="E-mail" name="email">
          </div>
        </div>
        <div class="form-group">
          <label for="email" class="col-lg-2 control-label">Senha</label>
          <div class="col-lg-10">
            <input type="password" class="form-control" id="email" placeholder="Antiga senha" name="email">
          </div>
        </div>
        <div class="form-group">
          <label for="email" class="col-lg-2 control-label">Nova Senha</label>
          <div class="col-lg-10">
            <input type="password" class="form-control" id="email" placeholder="Nova senha" name="email">
          </div>
        </div>
        <div class="box-footer">
            <button type="submit" class="btn btn-primary">Salvar</button>
        </div>
    </form>
    </div> 
    
    
</section>