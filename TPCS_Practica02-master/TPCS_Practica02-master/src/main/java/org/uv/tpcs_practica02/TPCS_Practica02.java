/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.tpcs_practica02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TPCS_Practica02 {

    public static void main(String[] args) {
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        //Creación de Empleado
        Empleado emp = new Empleado();
        emp.setNombre("Danup");
        emp.setDireccion("fondo de vikiny");
        emp.setTelefono(Long.valueOf("0180069989"));
        
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
