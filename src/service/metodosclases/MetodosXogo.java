package service.metodosclases;

import model.Xogo;

import java.util.ArrayList;
import java.util.List;

public class MetodosXogo {

    public List<Xogo> xogosList(){
        List<Xogo> xogos = new ArrayList<>();

        Xogo xogo1 = new Xogo("zelda: ocarina of time", "nintendo", "aventura épica onde link viaxa no tempo para salvar hyrule");
        Xogo xogo2 = new Xogo("cyberpunk 2077", "cd projekt red", "rpg ambientado nun futuro de megacorporacións cada vez menos distópico");
        Xogo xogo3 = new Xogo("outer wilds", "mobius digital", "x mellor xogo, non se deben facer spoilers");
        Xogo xogo4 = new Xogo("space marine 2", "focus entertainment", "xogo de acción no universo warhammer, faltanlle as sororitas");
        Xogo xogo5 = new Xogo("pokemon rojo", "game freak", "o xogo que o resto de versions de pokemon queren ser");

        xogos.add(xogo1);
        xogos.add(xogo2);
        xogos.add(xogo3);
        xogos.add(xogo4);
        xogos.add(xogo5);

        return xogos;
    }
}
