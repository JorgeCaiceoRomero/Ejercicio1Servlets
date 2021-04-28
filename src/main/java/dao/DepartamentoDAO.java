package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;



import pojos.Departamento;

public class DepartamentoDAO {
	
	public static void insertDepartamentos(Session s, int numDepts) {
	    for (int codigo = 1; codigo <= numDepts; codigo++) {
	      insertDepartamento(s, codigo);
	    }
	  }
	
	public static void insertDepartamento(Session s, int codigo) {	
		System.out.println("Iniciando método");
		int codigoDep = codigo;
		String nombre = "Nombre de "+codigo;
		int codResponsable = codigo+1;
		
		Departamento departamento = new Departamento(codigoDep, nombre, codResponsable);
		s.save(departamento);
		System.out.println("Terminando metodo");
	}
	
	public static List<Departamento> getAllDepartamentos(Session s) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Departamento.class);
		List<Departamento> result = criteria.getExecutableCriteria(s).list();
		return result;
	}
	
	public static Departamento getDepartamento(Session s, int DepartamentoId) {
		// deprecado desde 5.2
		Criteria criteria = s.createCriteria(Departamento.class);
		Departamento result = (Departamento)criteria.add(Restrictions.eq("codigo", DepartamentoId))
											.setMaxResults(1)
											.uniqueResult();
		return result;
	}
	
	public static void actualizarDepartamento(Session s, int id,String nombre) {
        // s.get(Empleado.class, id);
        Departamento d = s.get(Departamento.class, id);
        d.setNombre(nombre);
        
        s.update(d);


    }
	
	public static void borrarDepartamento(Session s, int id) {
        // s.get(Empleado.class, id);
        Departamento d = s.get(Departamento.class, id);     
        s.delete(d);


    }
	
}
