package service.ficheros;

import model.Inventariotenda;
import model.Xogo;
import service.crud.HibernateCrud;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LecturaEscrituraXML {

    public void writeXmlXogo(List<Xogo> xogoList, String path){
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

        try{
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter(path));
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement("xogos");

            for (Xogo xogo : xogoList) {
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("xogo");
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("id");
                xmlStreamWriter.writeCharacters(String.valueOf(xogo.getId()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("nome");
                xmlStreamWriter.writeCharacters(xogo.getNome());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("estudio");
                xmlStreamWriter.writeCharacters(xogo.getEstudio());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeStartElement("descricion");
                xmlStreamWriter.writeCharacters(xogo.getDescripcion());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();

            System.out.println("Fichero xml de xogos escrito correctamente");
        } catch (XMLStreamException e) {
            System.out.println("Ups, error al escribir en el xml el archivo de xogos");
        } catch (IOException e) {
            System.out.println("Ups, error durante la ejecución de escritura de fichero xml de xogos");
        }
    }

    public List<Xogo> getXogosList(String path){
        List<Xogo> xogoList = new ArrayList<>();

        String elementoActual = "";
        Integer id = 0;
        String nombre = "";
        String estudio = "";
        String descricion = "";

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try{
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(path));
            int element;

            while(xmlStreamReader.hasNext()){
                element = xmlStreamReader.next();

                if(element == XMLStreamConstants.START_ELEMENT){
                    elementoActual = xmlStreamReader.getLocalName();

                }
                else if(element == XMLStreamConstants.CHARACTERS){
                    String text = xmlStreamReader.getText().trim();
                    if("id".equals(elementoActual) && !text.isEmpty()){
                        id = Integer.parseInt(text);
                    }
                    else if("nome".equals(elementoActual) && !text.isEmpty()){
                        nombre = text;

                    } else if ("estudio".equals(elementoActual) && !text.isEmpty()) {
                        estudio = text;
                    }
                    else if("descricion".equals(elementoActual) && !text.isEmpty()) {
                        descricion = text;
                    }
                }
                else if(element == XMLStreamConstants.END_ELEMENT){
                    if("xogo".equals(xmlStreamReader.getLocalName())){
                        xogoList.add(new Xogo(id, nombre, estudio, descricion));
                    }
                }
            }
        } catch (XMLStreamException e) {
            System.out.println("Ups, error al leer el archivo xml de xogos");
        } catch (FileNotFoundException e) {
            System.out.println("Ups, no se encontró el archivo xml de xogos");
        }
        return xogoList;
    }





}
