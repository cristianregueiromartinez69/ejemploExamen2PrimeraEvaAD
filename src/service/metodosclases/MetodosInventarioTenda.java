package service.metodosclases;

import model.Inventariotenda;
import model.Xogo;
import service.crud.HibernateCrud;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MetodosInventarioTenda {

    public List<Inventariotenda> inventariotendaList(HibernateCrud crud){
        List<Inventariotenda> inventariotendas = new ArrayList<>();

        Inventariotenda inventariotenda1 = new Inventariotenda(crud.getXogoFromDb(crud.xogosIdList().getFirst()), BigDecimal.valueOf(40.00), BigDecimal.valueOf(60.00), 10);
        Inventariotenda inventariotenda2 = new Inventariotenda(crud.getXogoFromDb(crud.xogosIdList().get(1)), BigDecimal.valueOf(50.00), BigDecimal.valueOf(70.00), 15);
        Inventariotenda inventariotenda3 = new Inventariotenda(crud.getXogoFromDb(crud.xogosIdList().get(2)), BigDecimal.valueOf(30.00), BigDecimal.valueOf(45.00), 5);

        inventariotendas.add(inventariotenda1);
        inventariotendas.add(inventariotenda2);
        inventariotendas.add(inventariotenda3);

        return inventariotendas;

    }
}
