
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Tarjeta;
import modelo.Usuario;
import modeloDAO.TarjetaDAO;


@WebServlet(name = "TarjetaServlet", urlPatterns = {"/TarjetaServlet"})
public class TarjetaServlet extends HttpServlet {

    
    Tarjeta tar = new Tarjeta();
    TarjetaDAO daoTar = new TarjetaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        HttpSession session = request.getSession();
        Usuario user=(Usuario) session.getAttribute("user");
        //4,4,'2023-10-08 02:36:40','2023-10-08',1,1,2
        if(accion.equalsIgnoreCase("Comprar")){            
           
             String codigo_tarjeta = request.getParameter("codigo_tarjeta");
             String numero_tarjeta = request.getParameter("numero_tarjeta");
             //String fecha_activacion =request.getParameter("fecha_activacion");
             //String fecha_vencimiento =  request.getParameter("fecha_activacion");
             int estado = 1;
             double saldo = 0.0;
             int idUsuario = user.getId();
             
             tar.setCodigo_tarjeta(codigo_tarjeta);
             tar.setNumero_tarjeta(numero_tarjeta);
             tar.setSaldo(saldo);
             tar.setIdUsuario(idUsuario);
            
            daoTar.add(tar);
            session.setAttribute("tarjeta", tar);
           
            response.sendRedirect("./assets/vistas/RecargaTarjeta.jsp");
            
        }else if(accion.equalsIgnoreCase("Recargar")){
            
            double monto = Double.parseDouble(request.getParameter("saldo"));
            System.out.println("SERVLET SALDOS:"+ monto);
            
            
            Tarjeta tarrr = daoTar.listarId(tar.getId());
            monto = tarrr.getSaldo()+ monto;
            daoTar.recargar(monto,tarrr.getId());
            
            
            response.sendRedirect("./assets/vistas/RecargaTarjeta.jsp");
            session.setAttribute("tarjeta", tarrr);
        }
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
