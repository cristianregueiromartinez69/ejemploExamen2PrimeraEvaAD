import controller.Controller;
import service.crud.HibernateCrud;
import service.metodosclases.MetodosInventarioTenda;
import service.metodosclases.MetodosXogo;

public class Main {
    public static void main(String[] args) {
        MetodosXogo metodosXogo = new MetodosXogo();
        MetodosInventarioTenda metodosInventarioTenda = new MetodosInventarioTenda();
        HibernateCrud crud = new HibernateCrud();
        Controller controller = new Controller();

        //controller.inserccionesXogos(crud, metodosXogo.xogosList());
        //controller.listarIdsXogos(crud, metodosXogo);
        //controller.inserccionesInventarioTenda(crud, metodosInventarioTenda.inventariotendaList(crud));
    }
}