<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<head>
<link href="bootstrap/css/home.css" rel="stylesheet">
</head>

<section class="content-header">
    <h1>
      Relatórios Professores na grade
    </h1>
    <ol class="breadcrumb">
      <li><a href="UserController?action=inicio">Início</a></li>
      <li class="active">Relatórios</li>
    </ol>
</section>



<div id="page-wrapper">

            <div class="container-fluid">

                    <div class="row">
                    <div class="col-lg-6">
                        <h2></h2>
                        <div class="table-responsive" id="tabela">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th>SIAPE</th>
                                        <th>Lotação</th>
                                        <th>Cargo</th>
					<th>CLASSE</th>
					<th>TELEFONE</th>
					<th>EMAIL</th>
					<th>RAMAL</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                    <c:forEach items="${servidores}" var="servidor">  
                                        
                                         <tr>
                        <td><c:out value="${servidor.getNome()}" /></td>
                        <td><c:out value="${servidor.getSiape()}" /></td>
                        <td><c:out value="${servidor.getLotacao()}" /></td>
                        <td><c:out value="${servidor.getCargo()}" /></td>
                        <td><c:out value="${servidor.getClasse()}" /></td>
                        <td><c:out value="${servidor.getTelefone()}" /></td>
                        <td><c:out value="${servidor.getEmail()}" /></td>
                        <td><c:out value="${servidor.getRamal()}" /></td>
                        
                    </tr>
                                       
                                       
                                    </c:forEach>        
                                   
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
<button id="btGerarPDF">gerar PDF</button>
<script>
    var doc = new jsPDF();
    var specialElementHandlers = {
        '#editor': function (element, renderer) {
            return true;
        }
    };

    $('#btGerarPDF').click(function () {
        doc.fromHTML($('#conteudo').html(), 15, 15, {
            'width': 170,
                'elementHandlers': specialElementHandlers
        });
        doc.save('exemplo-pdf.pdf');
    });
</script>