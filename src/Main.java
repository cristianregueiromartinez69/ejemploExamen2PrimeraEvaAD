import controller.Controller;
import service.crud.HibernateCrud;
import service.metodosclases.MetodosXogo;

public class Main {
    public static void main(String[] args) {
        MetodosXogo metodosXogo = new MetodosXogo();
        HibernateCrud crud = new HibernateCrud();
        Controller controller = new Controller();

        //controller.inserccionesXogos(crud, metodosXogo.xogosList());
        controller.listarIdsXogos(crud, metodosXogo);

    }
}