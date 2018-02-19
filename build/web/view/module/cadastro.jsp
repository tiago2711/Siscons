<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<section class="content-header">
    <h1>
      Cadastro de Servidor
    </h1>
    <ol class="breadcrumb">
      <li><a href="UserController?action=inicio">Início</a></li>
      <li class="active">Cadastrar Servidor</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <div class="box box-primary">
       
   
    <form class="form-horizontal" action="UserController?action=create" method="post">

        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Nome</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="name" placeholder="Nome" name="name">
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">SIAPE</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="siape" placeholder="SIAPE" name="siape">
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Lotação</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="lotacao" placeholder="Lotação" name="lotacao">
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Cargo</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="cargo" placeholder="Cargo" name="cargo">
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Classe</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="classe" placeholder="Classe" name="classe" maxlength="1">
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Telefone</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="telefone" placeholder="Telefone" name="telefone">
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Ramal</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="ramal" placeholder="Ramal" name="ramal">
          </div>
        </div>
        <div class="form-group">
          <label for="email" class="col-lg-2 control-label">Email</label>
          <div class="col-lg-10">
            <input type="email" class="form-control" id="email" placeholder="E-mail" name="email">
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Lattes</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="lattes" placeholder="Lattes" name="lattes">
          </div>
        </div>
        <div class="form-group">
                <label for="active" class="col-lg-2 control-label">Situação</label>
                <div class="col-lg-10">
                    <input type="radio" name="situacao" value="true" checked><label> &nbsp; Ativo </label>&nbsp;
                    <input type="radio" name="situacao" value="false"><label>&nbsp; Desativo</label><br>
                    <label>Exemplo: Técnico, Ex Técnico </label>
                </div>
        </div>
        <div class="form-group">
                <label for="active" class="col-lg-2 control-label">Afastado</label>
                <div class="col-lg-10">
                    <input type="radio" name="afastado" value="false" checked><label>&nbsp; Afastado</label>&nbsp;
                    <input type="radio" name="afastado" value="true"><label>&nbsp; Não Afastado</label><br>
                </div>
        </div>
        
        <div class="form-group">
          <label for="profile" class="col-lg-2 control-label">Categoria</label>
          <div class="col-lg-3">
            <select id="categoriaid" name="categoria" class="form-control">
                <option>*Categoria</option>
                <option>Tecnico</option>
                <option>Docente</option>
                <option>Substituto</option>
                <option>Voluntario</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Curso</label>
          <div class="col-lg-10">
              <input type="text" class="form-control" id="curso" placeholder="Curso" name="curso" disabled="true">
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Substituicao</label>
          <div class="col-lg-10">
              <input type="text" class="form-control" id="substituicao" placeholder="Substituicao" name="substituicao" disabled="true">
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">IES</label>
          <div class="col-lg-10">
              <input type="text" class="form-control" id="IES" placeholder="IES" name="IES" disabled="true">
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Area</label>
          <div class="col-lg-10">
              <input type="text" class="form-control" id="Area" placeholder="Area" name="Area" disabled="true">
          </div>
        </div>
        
        <div class="form-group">
                <label for="active" class="col-lg-2 control-label">Coordenador</label>
                <div class="col-lg-10">
                    <input type="radio" name="Coordenador" value="true" ><label>&nbsp; Coordenador</label>&nbsp;
                    <input type="radio" name="Coordenador" value="false" checked><label>&nbsp; Não Coordenador</label><br>
                </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">TIT</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="tit" placeholder="TIT" name="tit" disabled="true">
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Início</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="inicio" placeholder="Início" name="inicio" disabled="true">
          </div>
        </div> 
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Término</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="termino" placeholder="Término" name="termino" disabled="true">
          </div>
        </div> 
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Titulação</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="titulacao" placeholder="Titulação" name="titulacao" disabled="true">
          </div>
        </div> 
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Tutor</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="tutor" placeholder="Tutor" name="tutor" disabled="true">
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Disciplina</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="disciplina" placeholder="Disciplina" name="disciplina" disabled="true">
          </div>
        </div>
         <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Prorrogacao</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="prorrogacao" placeholder="prorrogaçâo" name="prorrogacao" disabled="true">
          </div>
        </div> 
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Resolução</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="resolucao" placeholder="Resolução" name="resolucao" disabled="true">
          </div>
        </div>
        <div class="form-group">
          <label for="name" class="col-lg-2 control-label">Edital PREG</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="edital" placeholder="Edital PREG" name="edital" disabled="true">
          </div>
        </div> 
         <div class="form-group">
                <label for="active" class="col-lg-2 control-label">Arquivos</label>
                <div class="col-lg-10">
                    <input type="file" id="exampleInputFile"><br>
                    <input type="file" id="exampleInputFile"><br>
                    <input type="file" id="exampleInputFile"><br>
                    <input type="file" id="exampleInputFile"><br>
                    <input type="file" id="exampleInputFile">
                </div>
        </div>
        
        <div class="box-footer">
            <button type="submit" class="btn btn-primary">Salvar</button>
        </div>
    </form>
    </div> 
    
    
</section>
<script>
    // select
    var select = document.getElementById("categoriaid");
    //
    var curso = document.getElementById("curso");
    var tit = document.getElementById("tit");
    var inicio = document.getElementById("inicio");
    var termino = document.getElementById("termino");
    var titulacao = document.getElementById("titulacao");
    var tutor = document.getElementById("tutor");
    var disciplina = document.getElementById("disciplina");
    var resolucao = document.getElementById("resolucao");
    var edital = document.getElementById("edital");
    var prorrogacao = document.getElementById("prorrogacao");
   
    var substituicao = document.getElementById("substituicao");
    var IES = document.getElementById("IES");
    var Area = document.getElementById("Area");
    

    // quando o select muda
    select.onchange = function () {
        var valor = select.options[select.selectedIndex].value;
        switch (valor){
            case "*Categoria":
                curso.disabled=true;
                tit.disabled=true;
                inicio.disabled=true;
                termino.disabled=true;
                titulacao.disabled=true;
                tutor.disabled=true;
                disciplina.disabled=true;
                resolucao.disabled=true;
                edital.disabled=true;
                prorrogacao.disabled=true;
                substituicao.disabled=true;
                IES.disabled=true;
                Area.disabled=true;
                break;
            case "Técnico":
                curso.disabled=true;
                tit.disabled=true;
                inicio.disabled=true;
                termino.disabled=true;
                titulacao.disabled=true;
                tutor.disabled=true;
                disciplina.disabled=true;
                resolucao.disabled=true;
                edital.disabled=true;
                prorrogacao.disabld=true;
                substituicao.disabled=true;
                IES.disabled=true;
                Area.disabled=true;
                break;
            case "Docente":
                curso.disabled=false;
                tit.disabled=false;
                inicio.disabled=true;
                termino.disabled=true;
                titulacao.disabled=true;
                tutor.disabled=true;
                disciplina.disabled=true;
                resolucao.disabled=true;
                edital.disabled=true;
                prorrogacao.disabld=true;
                substituicao.disabled=false;
                IES.disabled=false;
                Area.disabled=false;
                break;
            case "Substituto":
                curso.disabled=false;
                tit.disabled=true;
                inicio.disabled=false;
                termino.disabled=false;
                titulacao.disabled=false;
                tutor.disabled=false;
                disciplina.disabled=true;
                resolucao.disabled=false;
                edital.disabled=false;
                prorrogacao.disabled=true;
                substituicao.disabled=false;
                IES.disabled=true;
                Area.disabled=true;
                break;
            case "Voluntário":
                curso.disabled=false;
                tit.disabled=true;
                inicio.disabled=false;
                termino.disabled=false;
                titulacao.disabled=false;
                tutor.disabled=false;
                disciplina.disabled=false;
                resolucao.disabled=true;
                prorrogacao.disabled=false;
                edital.disabled=true; 
                substituicao.disabled=true;
                IES.disabled=true;
                Area.disabled=true;
                break;
        }
    }
</script>    
