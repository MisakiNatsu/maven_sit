<%@page import="modeloDTO.RutaDTO"%>
<%@page import="modeloDTO.UsuarioDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modelo.Usuario"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="icon" type="image.png" href="../img/buss.png">
  <title>Sistema integrado de Transporte - Devlex</title>
  <!--CSS-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/administrar.css">
  <!--font awesome con CDN-->  
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">  

</head>

<body>
  <!--Cabezera-->
  <header class="d-flex justify-content-between" id="header">
    <div class="d-flex align-items-center">
      <img src="../img/buss.png" alt="logo buss" width="60">
    </div>
    <nav class="d-flex align-items-center">
      <a href="../../index.html">Inicio</a>
      <a href="administrar_viajes.jsp">PROGRAMAR RUTAS</a>
    </nav>
  </header>

  <!--Pagina principal-->
  <main class="d-flex flex-column justify-content-center align-items-center">


    <div class="mb-3">
      <h3>ADMINISTRACION DE RUTAS</h3>
    </div>
    <section class="my-4 d-flex">
      <a href="./administrar_usuario.jsp" class="sidebar-link">
        Usuarios
      </a>
      <a href="./administrar_transportistas.jsp" class="sidebar-link">
        Conductores
      </a>
        <a href="./administrar_unidad_transportes.jsp" class="sidebar-link">
        Unidades
      </a>
      <a href="./administrar_rutas.jsp" class="sidebar-link">
        Rutas
      </a>
    </section>
    <section id="tabla">
      <table class="" id="miTabla" style="width:100%;">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">COLOR</th>
            <th scope="col">NOMBRE RUTA</th>
            <th scope="col">ORIGEN</th>
            <th scope="col">DESTINO</th>
            <th scope="col"></th>
            <th scope="col"></th>
          </tr>
        </thead>
        
        
        <tbody>
            <% 
            UsuarioDAO dao = new UsuarioDAO();
            List<RutaDTO> lista = dao.listarCompletoRutas();
            Iterator<RutaDTO> iter = lista.iterator();
            RutaDTO uni = null;
            while(iter.hasNext()){
                uni = iter.next();
          %>
          <tr>
            <td style="background-color:#1e1e20;"><%= uni.getId()%></td>
            <td style="background-color:#1e1e20;"><%= uni.getColor()%></td>
            <td style="background-color:#1e1e20;"><%= uni.getNombre_ruta()%></td>
            <td style="background-color:#1e1e20;"><%= uni.getOrigen()%></td>
            <td style="background-color:#1e1e20;"><%= uni.getDestino()%></td>
            
            <td style="background-color:#1e1e20;"><a href="../../RutaServlet?accion=editar&idUni=<%=uni.getId()%>">Editar</a></td>
            <td style="background-color:#1e1e20;"><a href="../../RutaServlet?accion=eliminar&idUni=<%=uni.getId()%>">Eliminar</a></td>
          </tr>
          <%}%>
        </tbody>
        
      </table>
    </section>

    <section class="my-4 d-flex">
      <button type="button" class="botones" id="botonAgregar">Agregar</button>
      <button type="button" class="botones" id="botonReactivar">Reactivar</button>
      
    </section>
      <button type="button" class="botones" id="botonProgramar">PROGRAMAR RUTA</button>

      
      
      
      <script>
        // Seleccionar el bot�n por su ID
        var boton = document.getElementById('botonAgregar');
        var boton2 = document.getElementById('botonReactivar');
        var boton3 = document.getElementById('botonProgramar');

        // Agregar un controlador de eventos de clic al bot�n
        boton.addEventListener('click', function() {
            // Redirigir a otra p�gina HTML
            window.location.href = 'registroRuta.jsp';
        });
        // Agregar un controlador de eventos de clic al bot�n
        boton2.addEventListener('click', function() {
            // Redirigir a otra p�gina HTML
            window.location.href = 'reactivar_Rutas.jsp';
        });
        
        boton3.addEventListener('click', function() {
            // Redirigir a otra p�gina HTML
            window.location.href = 'reactivar_Rutas.jsp';
        });
    </script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>

    
    
    <!-- jQuery, Popper.js, Bootstrap JS -->
    <script src="jquery/jquery-3.3.1.min.js"></script>
    <script src="popper/popper.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
      
<!-- datatables JS -->
    <script type="text/javascript" src="../datatables/datatables.min.js"></script>  

<!-- para usar botones en datatables JS -->  
    <script src="../datatables/Buttons-1.5.6/js/dataTables.buttons.min.js"></script>  
    <script src="../datatables/JSZip-2.5.0/jszip.min.js"></script>    
    <script src="../datatables/pdfmake-0.1.36/pdfmake.min.js"></script>    
    <script src="../datatables/pdfmake-0.1.36/vfs_fonts.js"></script>
    <script src="../datatables/Buttons-1.5.6/js/buttons.html5.min.js"></script>
    <script src="main_tablas.js"></script>
  </main>
</body>

</html>