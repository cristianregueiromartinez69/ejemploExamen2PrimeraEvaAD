package controller;

import model.Inventariotenda;
import model.Xogo;
import service.crud.HibernateCrud;
import service.ficheros.LecturaEscrituraXML;
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

    public void writeXmlXogo(LecturaEscrituraXML leXML, HibernateCrud crud, String path){
        leXML.writeXmlXogo(crud.getXogosFromDb(), path);
    }

    public void updateXogosTenda(HibernateCrud crud, Integer prezoPorcentaxeOferta){
        for(int i = 1; i < 4; i++){
            crud.updatePrezoOfertaInventarioTenda(i, prezoPorcentaxeOferta);
        }
    }


}
