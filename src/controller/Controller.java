package controller;

import model.Inventariotenda;
import model.Xogo;
import service.crud.HibernateCrud;
import service.ficheros.LecturaEscrituraXML;
import service.metodosclases.MetodosInventarioTenda;
import service.metodosclases.MetodosXogo;

import java.math.BigDecimal;
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


    public void readXMlXogos(LecturaEscrituraXML leXML, String path){
       List<Xogo> xogoList = leXML.getXogosList(path);

       for(Xogo x : xogoList){
           System.out.println(x.toString());
       }
    }

    public void updateXogosTenda(HibernateCrud crud, Integer prezoPorcentaxeOferta){
        for(int i = 1; i < 4; i++){
            crud.updatePrezoOfertaInventarioTenda(i, prezoPorcentaxeOferta);
        }
    }

    public void prezoActualZelda(HibernateCrud crud, MetodosInventarioTenda metodosInventarioTenda){
        System.out.println("Precio actual del Zelda: Ocarina of Time: " + metodosInventarioTenda.getPrezoActualZelda(crud.getInventariotendaFromDb(1)) + "€");
    }

    public void updatePorcentajesOfertasByXml(HibernateCrud crud){

        List<Inventariotenda> idXogos = crud.getInventariotendasFromDb();
        crud.restartOfertaInventarioTenda(idXogos.getFirst().getId(), 10);
        crud.restartOfertaInventarioTenda(idXogos.get(1).getId(), 15);
        crud.restartOfertaInventarioTenda(idXogos.get(2).getId(), 5);

    }

    public void deleteDatos(HibernateCrud crud, String query){
        crud.deletedataDB(query);
    }

}
