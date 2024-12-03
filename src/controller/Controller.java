package controller;

import model.Xogo;
import service.crud.HibernateCrud;
import service.metodosclases.MetodosXogo;

import java.util.List;

public class Controller {

    public void inserccionesXogos(HibernateCrud crud, List<Xogo> xogoList){
        crud.insertarDatosXogosDb(xogoList);
    }

    public void listarIdsXogos(HibernateCrud crud, MetodosXogo metodosXogo){
        metodosXogo.listarIdXogos(crud.xogosIdList());
    }
}
