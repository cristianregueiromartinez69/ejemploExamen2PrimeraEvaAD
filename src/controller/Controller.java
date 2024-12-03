package controller;

import model.Inventariotenda;
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

    public void inserccionesInventarioTenda(HibernateCrud crud, List<Inventariotenda> inventariotendaList){
        crud.insertarDatosInventarioTendaDB(inventariotendaList);
    }


}
