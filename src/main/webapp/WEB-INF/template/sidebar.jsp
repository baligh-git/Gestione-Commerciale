
    <ul l class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <c:url value="/home/" var="home"/>
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${home}">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3" ><spring:message code="sidebar.menu.titolo.label" /><sup></sup></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item">
       <c:url value="/home/" var="home"/>
        <a class="nav-link" href="${home}">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span><spring:message code="sidebar.menu.panello.label" /></span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Interfaccia
      </div>

      <li class="nav-item">
        
        <a class="nav-link collapsed" href="home/" data-toggle="collapse" data-target="#collapseClienti" aria-expanded="true" aria-controls="collapseClienti">
          <i class="fas fa-fw fa-table"></i>
          <span><spring:message code="sidebar.menu.clienti.label" /></span></a>
          <div id="collapseClienti" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header"><spring:message code="sidebar.menu.clienti.componenti.label" />:</h6>
            <c:url value="/clienti/" var="clienti"/>
             <a class="collapse-item" href="${clienti}"><spring:message code="sidebar.menu.clienti.liste.label" /></a>
             <c:url value="/clienti/aggiungi/" var="aggiungi"/>
            <a class="collapse-item" href="${aggiungi}"><spring:message code="sidebar.menu.clienti.aggiungi.label" /></a>
            
          </div>
        </div>
          
      </li>
      
      <li class="nav-item">
       
        <a class="nav-link collapsed" href="home/" data-toggle="collapse" data-target="#collapseArticoli" aria-expanded="true" aria-controls="collapseArticoli">
          
          <i class="fas fa-fw fa-table"></i>
          <span><spring:message code="sidebar.menu.articoli.label" /></span></a>
          <div id="collapseArticoli" class="collapse" aria-labelledby="headingArticoli" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header"><spring:message code="sidebar.menu.articoli.componenti.label"/>:</h6>
            <c:url value="/articoli/" var="art"/>
             <a class="collapse-item" href="${art}"><spring:message code="sidebar.menu.articoli.liste.label"/></a>
             <c:url value="/articoli/aggiungi/" var="art"/>
            <a class="collapse-item" href="${art}"><spring:message code="sidebar.menu.articoli.aggiungi.label" /></a>
           
          </div>
        </div>
          
      </li>

     

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Impostazione
      </div>
 <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Components</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Components:</h6>
            <a class="collapse-item" href="buttons.html">Buttons</a>
            <a class="collapse-item" href="cards.html">Cards</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span>Utilities</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Utilities:</h6>
            <a class="collapse-item" href="utilities-color.html">Colors</a>
            <a class="collapse-item" href="utilities-border.html">Borders</a>
            <a class="collapse-item" href="utilities-animation.html">Animations</a>
            <a class="collapse-item" href="utilities-other.html">Other</a>
          </div>
        </div>
      </li>
      

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

     
    </ul>