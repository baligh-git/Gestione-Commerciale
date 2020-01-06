<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="it">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Articoli</title>


<link
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"
	rel="stylesheet">
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






					<table id="example" class="display" style="width: 100%">
						<thead>
							<tr>

								<th><spring:message code="table.articoli.codart.label"/></th>
								<th><spring:message code="table.articoli.descrizione.label"/></th>
								<th><spring:message code="table.articoli.pesoNetto.label"/></th>
								<th><spring:message code="table.articoli.unita.label"/></th>
								<th><spring:message code="table.articoli.prezzo.label"/></th>
								<th><spring:message code="table.articoli.dataCreaz.label"/></th>
								<th><spring:message code="table.articoli.mdificaElimia.label"/></th>
								

							</tr>
						</thead>

						<tbody>
							<c:forEach items="${articoli}" var="Articoli">
								<tr>
									<td>${Articoli.codArt}</td>
									<td>${Articoli.descrizione}</td>
									<td>${Articoli.pesoNetto}</td>
									<td>${Articoli.um}</td>
									<td>${Articoli.prezzo}</td>
									<td>${Articoli.dataCreaz}</td>

									


										
									<td><a 	href="<spring:url value="/articoli/modifica/${Articoli.id}" />" 
									       class="btn btn-info btn-circle">
											<i class="fas fa-info-circle"></i>
									</a> <a href="<spring:url value="/articoli/elimina/${Articoli.id}" />"
									 class="btn btn-danger btn-circle"> <i
											class="fas fa-trash"></i>
									</a></td>




								</tr>
							</c:forEach>





						</tbody>

					</table>







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

	<script src="https://code.jquery.com/jquery-3.3.1.js" /></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" /></script>

	<script>
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>

</body>

</html>
