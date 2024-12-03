package service.crud;

import config.HibernateConfig;
import model.Xogo;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateCrud {

    public void insertarDatosXogosDb(List<Xogo> xogosList){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            for(Xogo xogo : xogosList){
                session.save(xogo);
            }
            transaction.commit();
            System.out.println("Xogos, guardados correctamente en la base de datos");
        }
    }
}
