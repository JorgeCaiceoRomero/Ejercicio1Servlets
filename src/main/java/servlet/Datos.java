package servlet;

import java.io.IOException;
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

import util.HibernateUtil;

/**
 * Servlet implementation class Datos
 */
@WebServlet("/Datos")
public class Datos extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static Logger logger = LogManager.getLogger(MostrarDepartamentos.class);
	
	static SessionFactory sessionFactory;
	Session session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Datos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//session = HibernateUtil.getSessionFactory().openSession();
		logger.info("Se ha iniciado la sesión");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Escriba MostrarEmpleados o MostrarDepartamentos en la consulta");
		
		String parametro = request.getParameter("Pagina");
		if(parametro!=null){
			request.getRequestDispatcher(parametro).forward(request, response);
		}
		else {
			//response.getWriter().append("Página no encontrada");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
