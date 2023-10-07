/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modeloDAO.UsuarioDAO;


@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    String listar = "./assets/vistas/listar.jsp";
    String add = "./assets/vistas/add.jsp";
    String edit = "./assets/vistas/edit.jsp";
    Usuario usuario = new Usuario();
    UsuarioDAO usuDao = new UsuarioDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        if(accion.equalsIgnoreCase("Login")){
            System.out.println("LLEGASTE A LOGIN");
            
            String username = request.getParameter("username");
            String contrasenia = request.getParameter("contrasenia");
            
            Usuario user = usuDao.listarUsername(username);
            System.out.println("llego al dao"+user.getContrasenia()+user.getUsername()+user.getId());
            if (user != null && user.isPasswordCorrect(contrasenia)) {
            // Credenciales válidas, crea una sesión
            
            RequestDispatcher vista = request.getRequestDispatcher("ComprarTarjeta.html");
            vista.forward(request, response);
            
        } else {
            // Credenciales incorrectas, muestra un mensaje de error
            request.setAttribute("error", "Credenciales incorrectas");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
            
        }
        
        /*
        System.out.println("LLEGO");
        if(accion.equalsIgnoreCase("listar")){
            acceso= listar;
            System.out.println("LISTAR");
        }else if(accion.equalsIgnoreCase("add")){
            acceso = add;
        }else if(accion.equalsIgnoreCase("Agregar")){
            
            
            String username = request.getParameter("username");
            String contrasenia = request.getParameter("cantrasenia");
            String nombre = request.getParameter("nombre");
            String apellido_p = request.getParameter("apellido_paterno");
            String apellido_m = request.getParameter("apellido_materno");
            String correo = request.getParameter("correo");
            String contrasena = request.getParameter("contrasena");
            
            usuario.setNombre(nombre);
            usuario.setApellido_paterno(apellido_p);
            usuario.setApellido_materno(apellido_m);
            usuario.setCorreo(correo);
            usuario.setContrasena(contrasena);
            usuDao.add(usuario);
            acceso = listar;
            
        }else if(accion.equalsIgnoreCase("editar")){
            request.setAttribute("id_usu", request.getParameter("id"));
            acceso = edit;
        }else if(accion.equalsIgnoreCase("Actualizar")){
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellido_p = request.getParameter("apellido_paterno");
            String apellido_m = request.getParameter("apellido_materno");
            String correo = request.getParameter("correo");
            String contrasena = request.getParameter("contrasena");
            
            usuario.setId(id);
            usuario.setNombre(nombre);
            usuario.setApellido_paterno(apellido_p);
            usuario.setApellido_materno(apellido_m);
            usuario.setCorreo(correo);
            usuario.setContrasena(contrasena);
            usuDao.editar(usuario);
            acceso = listar;
        }else if(accion.equalsIgnoreCase("eliminar")){
            int id = Integer.parseInt(request.getParameter("id"));
            usuario.setId(id);
            usuDao.eliminar(id);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
*/
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
