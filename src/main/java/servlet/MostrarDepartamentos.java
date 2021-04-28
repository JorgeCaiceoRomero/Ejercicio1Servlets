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


import dao.DepartamentoDAO;
import pojos.Departamento;
import util.HibernateUtil;


/**
 * Servlet implementation class MostrarDepartamentos
 */
@WebServlet("/MostrarDepartamentos")
public class MostrarDepartamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	private static Logger logger = LogManager.getLogger(MostrarDepartamentos.class);
	
	static SessionFactory sessionFactory;
	Session session;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDepartamentos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().openSession();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Departamento> lista = DepartamentoDAO.getAllDepartamentos(session);		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		printDeptos(out, lista);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private PrintWriter printDeptos(PrintWriter out, List<Departamento> lista) {
			
		PrintWriter res = out;
		
		res.println("<html>");
		res.println("<title>Servlet de pruebas :)</title>");
		res.println("<body>");
		res.println("<div><h1>DEPARTAMENTOS</h1></div>");
		res.print("<table border=\"2\">");
		for (Departamento d : lista) {
			res.print("<tr>");
			res.print("<td>"+d.getCodigo()+"</td>");
			res.print("<td>"+d.getNombre()+"</td>");
			res.print("<td>"+d.getCodResponsable()+"</td>");
			res.println("</tr>");
		}
		res.print("<table>");
		res.println("</body>");
		res.println("</html>");
		
		
		return res;
	}
}
