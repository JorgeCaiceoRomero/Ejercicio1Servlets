package dao;

import java.util.List;

import org.hibernate.Session;


import pojos.Empleado;

public class EmpleadoDAO {
	public static List<Empleado> getAllEmpleados(Session s) {
        String hQuery = "from Empleado";

        List<Empleado> listaEmpleados = s.createQuery(hQuery, Empleado.class).list();
        return listaEmpleados;
    }
	//Devuelve una lista de empleados pertenecientes a X departamento
	public static List<Empleado> getXEmpleados(Session s, int codDepartamento) {
		  String hQuery = " from Empleado e " +
                  " where e.codDepartamento = :codDepartamento";
		  List<Empleado> e = s.createQuery(hQuery, Empleado.class)
                   .setParameter("clientId", codDepartamento)
                   .list();
		  return e;
    }
	
    public static Empleado getEmpleado(Session s, int id) {
        // s.get(Empleado.class, id);
        Empleado e = s.get(Empleado.class, id);

        return e;

    }

    public static void insertEmpleado(Session s, Empleado e) {

        s.save(e);

    }

    public static void actualizarEmpleado(Session s, int id,String nombre) {
        // s.get(Empleado.class, id);

        Empleado e = s.get(Empleado.class, id);
        e.setNombre(nombre);
        s.update(e);


    }


    public static void borrarEmpleado(Session s, int id) {
        // s.get(Empleado.class, id);
        Empleado e = s.get(Empleado.class, id);

        s.delete(e);

    }
}
