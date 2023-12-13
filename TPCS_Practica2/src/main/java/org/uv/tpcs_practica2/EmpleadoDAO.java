/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tpcs_practica2;

/**
 *
 * @author Ideapad
 */
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class EmpleadoDAO {

    public void agregarEmpleado(Empleado empleado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(empleado);
        session.getTransaction().commit();
        session.close();
    }

    public Empleado obtenerEmpleado(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Empleado empleado = session.get(Empleado.class, id);
        session.close();
        return empleado;
    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Empleado> query = session.createQuery("FROM Empleado", Empleado.class);
        List<Empleado> empleados = query.list();
        session.close();
        return empleados;
    }

    public void actualizarEmpleado(Empleado empleado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(empleado);
        session.getTransaction().commit();
        session.close();
    }

    public void eliminarEmpleado(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Empleado empleado = session.get(Empleado.class, id);
        if (empleado != null) {
            session.delete(empleado);
        }
        session.getTransaction().commit();
        session.close();
    }
}
