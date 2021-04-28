package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.EmpleadoDAO;
import pojos.Empleado;
import util.HibernateUtil;

/**
 * Servlet implementation class MostrarEmpleados
 */
@WebServlet("/MostrarEmpleados")
public class MostrarEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LogManager.getLogger(MostrarDepartamentos.class);
	
	static SessionFactory sessionFactory;
	Session session;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarEmpleados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();
		logger.info("Se ha iniciado la sesión");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Empleado> listaEmp = EmpleadoDAO.getAllEmpleados(session);
		printEmpleados(out, listaEmp);
		logger.info("Se han mostrado los empleados");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private PrintWriter printEmpleados(PrintWriter out, List<Empleado> lista) {
		
		PrintWriter res = out;
		
		res.println("<html>");
		res.println("<title>Servlet de pruebas :)</title>");
		res.println("<body>");
		res.println("<div><h1>EMPLEADOS</h1></div>");
		res.print("<table border=\"2\">");
		for (Empleado d : lista) {
			res.print("<tr>");
			res.print("<td>"+d.getCodigo()+"</td>");
			res.print("<td>"+d.getNombre()+"</td>");
			res.print("<td>"+d.getApellido1()+"</td>");
			res.print("<td>"+d.getApellido2()+"</td>");
			res.print("<td>"+d.getLugarNacimiento()+"</td>");
			res.print("<td>"+d.getFechaNacimiento()+"</td>");
			res.print("<td>"+d.getDireccion()+"</td>");
			res.print("<td>"+d.getTelefono()+"</td>");
			res.print("<td>"+d.getPuesto()+"</td>");
			res.print("<td>"+d.getCodDepartamento()+"</td>");
			res.println("</tr>");
		}
		res.print("<table>");
		res.println("</body>");
		res.println("</html>");
		
		
		return res;
	}

}
