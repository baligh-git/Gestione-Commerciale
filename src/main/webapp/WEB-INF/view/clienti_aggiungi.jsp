<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Clienti</title>


<!-- Custom fonts for this template-->
<link
	href="<%=request.getContextPath()%>/static/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<%=request.getContextPath()%>/static/css/sb-admin-2.min.css"
	rel="stylesheet">


</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="/WEB-INF/template/sidebar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">


				<%@ include file="/WEB-INF/template/topbar.jsp"%>


				<!-- Begin Page Content -->

				<div class="container-fluid">



					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<ul class="nav nav-tabs" id="myTab" role="tablist">
								<li class="nav-item"><a class="nav-link active"
									id="home-tab" data-toggle="tab" href="#home" role="tab"
									aria-controls="home" aria-selected="true"><spring:message
											code="tab.clienti.clienti.label" /></a></li>
								<li class="nav-item"><a class="nav-link" id="utente-tab"
									data-toggle="tab" href="#utente" role="tab"
									aria-controls="utente" aria-selected="false"><spring:message
											code="tab.clienti.utenti.label" /></a></li>

								<li class="nav-item"><a class="nav-link" id="profili-tab"
									data-toggle="tab" href="#profili" role="tab"
									aria-controls="profili" aria-selected="false"><spring:message
											code="tab.clienti.profili.label" /></a></li>

							</ul>

						</div>
						<div class="card-body">
							<div class="tab-content" id="myTabContent">

								<!--           tab 1-->

								<c:if test="${saved}">
									<div class="alert alert-success" role="alert">
										<spring:message code="inscliente.form.alert.label" />
									</div>
								</c:if>
								<div class="tab-pane fade show active" id="home" role="tabpanel"
									aria-labelledby="home-tab">



									<div class="portlet-body form">

										<!--           Form modifica Cliente                          -->
										<form:form method="POST" modelAttribute="cliente">
											<form:errors path="*" cssClass="alert alert-danger"
												element="div" />

											<div class="form-body">
												<form:hidden path="idClienti" />

												<div class="form-row">
													<div class="form-group col-md-4">
														<label for="nome"><spring:message
																code="aggiungi.clienti.nome" /></label>
														<form:input id="nome" path="nome" type="text"
															class="form-control" placeholder="Nome" />
														<form:errors path="nome" cssClass="text-danger" />
													</div>

													<div class="form-group col-md-4">
														<label for="cognome"><spring:message
																code="aggiungi.clienti.cognome" /></label>
														<form:input id="cognome" path="cognome" type="text"
															class="form-control" placeholder="Cognome " />
														<form:errors path="cognome" cssClass="text-danger" />
													</div>
												</div>


												<div class="form-row">
													<div class="form-group col-md-4">
														<label for="indirizzo"><spring:message
																code="aggiungi.clienti.indirizzi" /></label>
														<form:input id="indirizzo" path="indirizzo" type="text"
															class="form-control" placeholder="Indirizzo" />
														<form:errors path="indirizzo" cssClass="text-danger" />
													</div>
													<div class="form-group col-md-4">
														<label for="comune"><spring:message
																code="aggiungi.clienti.comune" /></label>
														<form:input id="comune" path="comune" type="text"
															class="form-control" placeholder="Comune" />
														<form:errors path="comune" cssClass="text-danger" />
													</div>

													<div class="form-group col-md-4">
														<label for="prov"><spring:message
																code="aggiungi.clienti.prov" /></label>
														<form:input id="prov" path="prov" type="text"
															class="form-control" placeholder="Provincia" />
														<form:errors path="prov" cssClass="text-danger" />
													</div>


												</div>
												<div class="form-group">
													<label for="mail"><spring:message
															code="aggiungi.clienti.mail" /></label>
													<form:input id="mail" path="mail" type="text"
														class="form-control" placeholder="Mail" />
													<form:errors path="mail" cssClass="text-danger" />
												</div>




											</div>

											<hr class="line-form">

											<div class="form-actions">
												<input type="submit" id="btnAdd"
													class="btn btn-primary form-buttons"
													value=<spring:message code="aggiungi.clienti.aggiungi.button"/> />
												<a href="<spring:url value="/clienti/" /> " id="btnAbort"
													class="btn btn-default form-buttons"> <spring:message
														code="aggiungi.clienti.annula.button" />
												</a>
											</div>

										</form:form>
									</div>




								</div>

								<!--           tab 2   -->

								<div class="tab-pane fade" id="utente" role="tabpanel"
									aria-labelledby="utente-tab">


									<div class="portlet-body form">
										<!--           Form modifica utenti                          -->
										<form:form method="POST" modelAttribute="utente">
											<form:errors path="*" cssClass="alert alert-danger"
												element="div" />

											<div class="form-body">
												



												<div class="form-row">
													<div class="form-group col-md-4">
														<label for="user"><spring:message
																code="aggiungi.utenti.user" /></label>
														<form:input id="user" path="user" type="text"
															class="form-control" placeholder="User" />
														<form:errors path="user" cssClass="text-danger" />
													</div>
													<div class="form-group col-md-4">
														<label for="pwd"><spring:message
																code="aggiungi.utenti.pwd" /></label>
														<form:input id="pwd" path="pwd" type="text"
															class="form-control" placeholder="pwd" />
														<form:errors path="pwd" cssClass="text-danger" />
													</div>



												</div>




											</div>

											<hr class="line-form">

											<div class="form-actions">
												<input type="submit" id="btnAdd"
													class="btn btn-primary form-buttons"
													value=<spring:message code="aggiungi.articolo.aggiungi.button"/> />
												<a href="<spring:url value="/clienti/" /> " id="btnAbort"
													class="btn btn-default form-buttons"> <spring:message
														code="aggiungi.articolo.annula.button" />
												</a>
											</div>

										</form:form>
									</div>





								</div>


								<!--          tab 3                          -->
								<div class="tab-pane fade" id="profili" role="tabpanel"
									aria-labelledby="profili-tab">


									<div class="portlet-body form">
										<!--           Form modifica profili                          -->
										<form:form method="POST" modelAttribute="profili">
											<form:errors path="*" cssClass="alert alert-danger"
												element="div" />

											<div class="form-body">
												<form:hidden path="idProfili" />


												<div class="form-group">
													<label for="tipo"><spring:message code="aggiungi.profili.label"/>:</label>
													<form:select path="tipo" class="form-control">
														<form:option value="USER" label="Utente" />
														<form:option value="COMM" label="Commerciale" />
														<form:option value="ADMIN" label="Amministratore" />
													</form:select>
												</div>


												<table id="profili"
													class="table table-striped table-bordered">
													<thead>
														<tr>
															<th><spring:message code="aggiungi.profili.table.id"/></th>
															<th><spring:message code="aggiungi.profili.table.profilo"/></th>
															<th></th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${cliente.utenti.profili}" var="prof">
															<tr>
																<td>${prof.idProfili}</td>
																<td>${prof.tipo}</td>
																<td><a
																	href="<c:url value='delprofilo/${cliente.idClienti}/${prof.idProfili} ' />"
																	class="btn btn-danger">Elimina</a></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>



											</div>

											<hr class="line-form">

											<div class="form-actions">
												<input type="submit" id="btnAdd"
													class="btn btn-primary form-buttons"
													value=<spring:message code="aggiungi.articolo.aggiungi.button"/> />
												<a href="<spring:url value="/clienti/" /> " id="btnAbort"
													class="btn btn-default form-buttons"> <spring:message
														code="aggiungi.articolo.annula.button" />
												</a>
											</div>

										</form:form>
									</div>





								</div>





								<!-- fin tabbbbbbb -->

							</div>

						</div>


					</div>
				</div>



				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; BALIGH 2019</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>


	<script
		src="<%=request.getContextPath()%>/static/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<%=request.getContextPath()%>/static/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="<%=request.getContextPath()%>/static/js/sb-admin-2.min.js"></script>

	<script>
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
			'use strict';
			window.addEventListener('load',
					function() {
						// Fetch all the forms we want to apply custom Bootstrap validation styles to
						var forms = document
								.getElementsByClassName('needs-validation');
						// Loop over them and prevent submission
						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {
										if (form.checkValidity() === false) {
											event.preventDefault();
											event.stopPropagation();
										}
										form.classList.add('was-validated');
									}, false);
								});
					}, false);
		})();
	</script>

</body>

</html>
