
<nav
	class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">



	<!-- Topbar Navbar -->
	<ul class="navbar-nav ml-auto">



		<li class="nav-item dropdown no-arrow"><a
			class="nav-link dropdown-toggle" href="?language=it"> <span
				class="mr-2 d-none d-lg-inline text-gray-600 small"><spring:message
						code="topbar.linguaggio.label" /></span> <img
				class="img-profile rounded-circle"
				src="<c:url value="/static/img/IT.png" />">

		</a></li>
		<li class="nav-item dropdown no-arrow"><a
			class="nav-link dropdown-toggle" href="?language=en"> <img
				class="img-profile rounded-circle"
				src="<c:url value="/static/img/US.png" />">
		</a></li>


		<div class="topbar-divider d-none d-sm-block"></div>

		<!-- Nav Item - User Information -->
		<li class="nav-item dropdown no-arrow"><a
			class="nav-link dropdown-toggle" href="#" id="userDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <i
				class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>

		</a> <!-- Dropdown - User Information -->
			<div
				class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
				aria-labelledby="userDropdown">


				<c:choose>
					<c:when test="${User != null}">
						<a class="dropdown-item disabled" href="#"> <i
							class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Login
						</a>
					</c:when>
					<c:otherwise>
						<a class="dropdown-item" href="<spring:url value="login/form" /> ">
							<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Login
						</a>
					</c:otherwise>
				</c:choose>
				



				<div class="dropdown-divider"></div>


				<c:choose>
					<c:when test="${User != null}">
						<form id="myHiddenFormId"
							action="/gestionemagazzino/login/form?logout " method="post"
							style="display: none">
							<input type="hidden" name="logout" value="${User}"> <input
								type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>

						<a class="dropdown-item " href=""
							onclick="$('#myHiddenFormId').submit(); return false;"
							title="Logout"> <i
							class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
							${User}
						</a>

					</c:when>
					<c:otherwise>

						<a class="dropdown-item disabled" href="#" data-toggle="modal"
							data-target="#logoutModal"> <i
							class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
							Logout
						</a>
					</c:otherwise>
				</c:choose>

			</div></li>

	</ul>

</nav>