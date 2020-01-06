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

<title>SB Admin 2 - Blank</title>

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

				<!-- Topbar -->
				<%@ include file="/WEB-INF/template/topbar.jsp"%>
				<!-- End of Topbar -->


				<!-- Begin Page Content -->
				<div class="container-fluid">


					<div class="container">

						<!-- Outer Row -->
						<div class="row justify-content-center">

							<div class="col-xl-10 col-lg-12 col-md-9">

								<div class="card o-hidden border-0 shadow-lg my-5">
									<div class="card-body p-0">
										<!-- Nested Row within Card Body -->
										<div class="row">
											<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
											<div class="col-lg-6">
												<div class="p-5">
													<div class="text-center">
														<h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
													</div>
													<c:url var="loginUrl" value="/login" />
													<form action="${loginUrl}" method="post" class="user">

														<c:if test="${param.error != null}">
															<div class="alert alert-danger">
																<p>
																	<spring:message code="login.form.errmsg" />
																</p>
															</div>
														</c:if>

														<c:if test="${param.forbidden != null}">
															<div class="alert alert-danger">
																<p>
																	<spring:message code="login.form.forbiddenmsg" />
																</p>
															</div>
														</c:if>

														<c:if test="${param.logout != null}">
															<div class="alert alert-success">
																<p>
																	<spring:message code="login.form.logoutmsg" />
																</p>
															</div>
														</c:if>
														<div class="form-group">

															<input type="userid"
																class="form-control form-control-user" name="userId"
																id="userId" aria-describedby="emailHelp"
																placeholder="Utente...">
														</div>
														<div class="form-group">
															<input type="password"
																class="form-control form-control-user" id="password"
																name="password" placeholder="Password">
														</div>
														<div class="form-group">
															<div class="custom-control custom-checkbox small">
																<label class="mt-checkbox mt-checkbox-outline">
																	<input type="checkbox" id="ricordami" name="ricordami">Ricordami
																</label>
															</div>
														</div>
														<input type="hidden" name="${_csrf.parameterName}"
															value="${_csrf.token}" /> <input type="submit"
															class="btn btn-primary btn-user btn-block" value="Log in">

													</form>

												</div>
											</div>
										</div>
									</div>
								</div>

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
						<span>Copyright &copy; Your Website 2019</span>
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

	<!-- Bootstrap core JavaScript-->
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

