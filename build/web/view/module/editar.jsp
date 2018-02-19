<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<section class="content-header">
    <h1>
      Editar Servidor
    </h1>
    <ol class="breadcrumb">
      <li><a href="UserController?action=inicio">Início</a></li>
      <li class="active">Editar Servidor</li>
    </ol>
</section>
<form class="form-horizontal" action="UserController?action=editar" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Nome</label>
    <input type="text" class="form-control" id="nome" placeholder="Nome" name="nome">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">SIAPE</label>
    <input type="text" class="form-control" id="siape" placeholder="SIAPE" name="siape">
  </div>
    <div class="form-group">
    <label for="exampleInputEmail1">Categoria</label>
    <select id="categoriaid" name="categoria" class="form-control">
                <option>*Categoria</option>
                <option>tecnico</option>
                <option>docente</option>
                <option>substituto</option>
                <option>voluntario</option>
                <option>docente_afastado</option>
    </select>
  </div>
  
  <button type="submit" class="btn btn-default">Procurar</button>
</form>



    <section class="content">

        <div class="box box-primary">
        
        <table class="table table-hover">
          <thead>
            <tr>
              <th>Nome</th>
              <th>SIAPE</th>
              <th>Lotação</th>
              <th>Cargo</th>
              <th>Classe</th>
              <th>Telefone</th>
              <th>Ramal</th>
              <th>Email</th>
              <th>Opções</th>
            </tr>
          </thead>
          <tbody>
                <c:forEach items="${servidores}" var="servidor"> 
                    <!--Parte de Baixo aqui dentro, só esta assim para os button aparecer. -->
                 
                    <tr>
                        <td><c:out value="${servidor.getNome()}" /></td>
                        <td><c:out value="${servidor.getSiape()}" /></td>
                        <td><c:out value="${servidor.getLotacao()}" /></td>
                        <td><c:out value="${servidor.getCargo()}" /></td>
                        <td><c:out value="${servidor.getClasse()}" /></td>
                        <td><c:out value="${servidor.getTelefone()}" /></td>
                        <td><c:out value="${servidor.getRamal()}" /></td>
                        <td><c:out value="${servidor.getEmail()}" /></td>
                        <td>
                            <a href="UserController?action=editar&siape=${servidor.getSiape()}&categoria=${servidor.getCategoria()}"><button type="button" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-edit"></span></button></a>
                            <button id="myBtn" type="button" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-file"></span></button>
                        </td>
                    </tr>
                    <!-- The Modal -->
                    <div id="myModal" class="modal">
                      <!-- Modal content -->
                      <div class="modal-content">
                        <span class="close">&times;</span>
                        <p>Nome: <c:out value="${servidor.getNome()}" /></p>
                        <p>SIAPE: <c:out value="${servidor.getSiape()}" /></p>
                        <p>Lotação: <c:out value="${servidor.getLotacao()}" /></p>
                        <p>Cargo: <c:out value="${servidor.getCargo()}" /></p>
                        <p>Classe: <c:out value="${servidor.getClasse()}" /></p>
                        <p>Telefone: <c:out value="${servidor.getTelefone()}" /></p>
                        <p>Ramal: <c:out value="${servidor.getRamal()}" /></p>
                        <p>Email: <c:out value="${servidor.getEmail()}" /></p>
                        <p>Lattes: <c:out value="${servidor.getEmail()}" /></p>
                        <p>Situação: <c:out value="${servidor.getEmail()}" /></p>
                        <p>Afastado: <c:out value="${servidor.getEmail()}" /></p>
                        <p>Categoria: <c:out value="${servidor.getEmail()}" /></p>
                        <p>Curso: <c:out value="${servidor.getEmail()}" /></p>
                        <p>TIT: <c:out value="${servidor.getEmail()}" /></p>
                        <p>Inicio: <c:out value="${servidor.getEmail()}" /></p>
                        <p>Término: <c:out value="${servidor.getEmail()}" /></p>
                        <p>Titulação: <c:out value="${servidor.getEmail()}" /></p>
                        <p>Tutor: <c:out value="${servidor.getEmail()}" /></p>
                        <p>Disciplina: <c:out value="${servidor.getEmail()}" /></p>
                        <p>Resolução: <c:out value="${servidor.getEmail()}" /></p>
                        <p>Edital PREG: <c:out value="${servidor.getEmail()}" /></p>
                      </div>
                    </div>    
                    <!-- The Modal -->
                    
                    </c:forEach>
          </tbody>
        </table>
        </div>
</section>                  
                       
<script>
    // Get the modal
    var modal = document.getElementById('myModal');

    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks on the button, open the modal 
    btn.onclick = function() {
        modal.style.display = "block";
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>    

<style>
    /* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 7%;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 15% auto; /* 15% from the top and centered */
    padding: 20px;
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button */
.close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
}
</style>    
                        