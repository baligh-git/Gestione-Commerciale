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

<title>Nuovo Articolo</title>


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
							<h6 class="m-0 font-weight-bold text-primary">Nuovo Articoli</h6>
						</div>
						<div class="card-body">


							<div class="portlet-body form">
								<form:form method="POST" modelAttribute="newArticolo"
									>
									<form:errors path="*" cssClass="alert alert-danger"
										element="div" />
										
									<div class="form-body">
									<form:hidden path="id"/>
									
  
										<div class="form-group">
											<label for="codArt"><spring:message
													code="aggiungi.articolo.codart" /></label>
											<form:input id="codArt" path="codArt" type="text"
												class="form-control" placeholder="Codice Articolo" />
											<form:errors path="codArt" cssClass="text-danger" />
										</div>

										<div class="form-group">
											<label for="descrizione"><spring:message
													code="aggiungi.articolo.descrizione" /></label>
											<form:input id="descrizione" path="descrizione" type="text"
												class="form-control" placeholder="Descrizione Articolo" />
											<form:errors path="descrizione" cssClass="text-danger" />
										</div>


										<div class="form-row">
											<div class="form-group col-md-4">
												<label for="um"><spring:message
														code="aggiungi.articolo.unita" /></label>
												<form:select path="um" class="form-control">
													<form:option value="PZ" label="Pezzi" />
													<form:option value="LT" label="Litri" />
													<form:option value="KG" label="Kilogrammi" />
												</form:select>
												<form:errors path="um" cssClass="text-danger" />
											</div>
											<div class="form-group col-md-4">
												<label for="prezzo"><spring:message
														code="aggiungi.articolo.prezzo" /></label>
												<form:input id="prezzo" path="prezzo" type="text"
													class="form-control" />
												<form:errors path="prezzo" cssClass="text-danger" />
											</div>

											<div class="form-group col-md-4">
												<label for="pesoNetto"><spring:message
														code="aggiungi.articolo.pesoNetto" /></label>
												<form:input id="pesoNetto" path="pesoNetto" type="text"
													class="form-control" />
												<form:errors path="pesoNetto" cssClass="text-danger" />
											</div>


										</div>



									</div>

									<hr class="line-form">

									<div class="form-actions">
										<input type="submit" id="btnAdd"
											class="btn btn-primary form-buttons"
											value=<spring:message code="aggiungi.articolo.aggiungi.button"/> />
										<a href="<spring:url value="/articoli/" /> " id="btnAbort"
											class="btn btn-default form-buttons"> <spring:message
												code="aggiungi.articolo.annula.button" />
										</a>
									</div>

								</form:form>
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


</body>

</html>
