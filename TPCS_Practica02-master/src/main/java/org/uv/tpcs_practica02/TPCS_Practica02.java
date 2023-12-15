/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.tpcs_practica02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ian
 */
public class TPCS_Practica02 {

    public static void main(String[] args) {
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        //Creación de Empleado
        Empleado emp = new Empleado();
        emp.setNombre("Ian");
        emp.setDireccion("caoba 4 Mariano");
        emp.setTelefono(Long.valueOf("123456789"));
        
        //Conexión a Postgres
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        
        //Guardado de Empleado
        session.save(emp);
        t.commit();
        
        //Cierre de conexión
        session.close();
    }
}
