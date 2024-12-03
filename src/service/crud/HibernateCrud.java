package service.crud;

import config.HibernateConfig;
import model.Inventariotenda;
import model.Xogo;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    public List<Integer> xogosIdList(){
        List<Integer> xogosIdList = new ArrayList<>();

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            xogosIdList = session.createQuery("SELECT id FROM Xogo", Integer.class).getResultList();

            transaction.commit();


        }

        return xogosIdList;
    }



    public Xogo getXogoFromDb(int id){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Xogo xogo = session.get(Xogo.class, id);
            transaction.commit();

            return xogo;
        }
    }

    public Inventariotenda getInventariotendaFromDb(int id){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Inventariotenda xogo = session.get(Inventariotenda.class, id);

            transaction.commit();

            return xogo;
        }
    }

    public List<Xogo> getXogosFromDb(){
        List<Xogo> xogosList = new ArrayList<>();

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            xogosList = session.createQuery("from Xogo", Xogo.class).getResultList();

            transaction.commit();

        }
        return xogosList;
    }

    public void insertarDatosInventarioTendaDB(List<Inventariotenda> inventariotendaList){
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            for(Inventariotenda xogo : inventariotendaList){
                session.save(xogo);
            }

            transaction.commit();

            System.out.println("Juego metido en la base de datos de inventario tienda correctamente");
        }
    }

    public void updatePrezoOfertaInventarioTenda(Integer id, Integer newPrezoPorcentaxeOferta){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Inventariotenda xogo = session.get(Inventariotenda.class, id);

            if(xogo != null){
                int oldPorcentaxeOferta = xogo.getPorcentaxeoferta();
                xogo.setPorcentaxeoferta(oldPorcentaxeOferta + newPrezoPorcentaxeOferta);
            }
            transaction.commit();

            System.out.println("precio oferta del juego de la tienda modificado correctamnete");
        }
    }

    public void restartOfertaInventarioTenda(Integer id, Integer newPrezoPorcentaxeOferta){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.createQuery("UPDATE Inventariotenda p SET p.porcentaxeoferta = :newPrezoPorcentaxeOferta WHERE p.idxogo = :id")
                            .setParameter("id", id)
                            .setParameter("newPrezoPorcentaxeOferta", newPrezoPorcentaxeOferta)
                            .executeUpdate();

            transaction.commit();

            System.out.println("Precio oferta de xogo restaurado correctamente");
            System.out.println("FIN OFERTAS DE STEAM");
        }
    }




}
