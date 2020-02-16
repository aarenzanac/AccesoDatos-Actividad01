/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad01accesodatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import clasesIncidencias.Incidencia;
import clasesIncidencias.Incidencias;
import clasesIncidencias.*;

/**
 *
 * @author alex
 */
public class Traspaso {
    
    public static ArrayList<MiIncidencia> leerArchivoIncidencias(String rutaActividad){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<MiIncidencia> listadoIncidencias = new ArrayList<MiIncidencia>();
        String incidencia;
        
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(rutaActividad, "incidencias.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            MiIncidencia in = null;   
            while((linea = br.readLine()) != null) {
                 
                if(linea.startsWith("%")){
                    String[] fechaOrigenDestino = new String[5];
                    fechaOrigenDestino = linea.split(" ");
                    in = new MiIncidencia();
                    in.setFechaHora(fechaOrigenDestino[1] + " " + fechaOrigenDestino[2]);
                    in.setOrigen(fechaOrigenDestino[3]);
                    in.setDestino(fechaOrigenDestino[4]);
                                        
                }else if(linea.equals("Normal") || linea.equals("Urgente")){
                    in.setTipo(linea);
                    listadoIncidencias.add(in);
                }else{
                    in.setDetalle(linea);   
                }  
            }      
                       
        } catch (Exception e) {
            e.printStackTrace();
                   
        } finally {
         // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
    return listadoIncidencias;
    }
     
    public static Incidencias leerArchivoIncidenciasJAXB(String rutaActividad){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<Incidencia> listadoIncidenciasJAXB = new ArrayList<Incidencia>();
        Incidencias inJAXB = new Incidencias();
                
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(rutaActividad, "incidencias.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            Incidencia in = null;   
            while((linea = br.readLine()) != null) {
                 
                if(linea.startsWith("%")){
                    String[] fechaOrigenDestino = new String[5];
                    fechaOrigenDestino = linea.split(" ");
                    in = new Incidencia();
                    in.setFechahora(fechaOrigenDestino[1] + " " + fechaOrigenDestino[2]);
                    in.setOrigen(fechaOrigenDestino[3]);
                    in.setDestino(fechaOrigenDestino[4]);
                                        
                }else if(linea.equals("Normal") || linea.equals("Urgente")){
                    in.setTipo(linea);
                    inJAXB.getIncidencia().add(in);
                    //listadoIncidenciasJAXB.add(in);
                }else{
                    in.setDetalle(linea);   
                }  
            }      
                       
        } catch (Exception e) {
            e.printStackTrace();
                   
        } finally {
         // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
    return inJAXB;
    } 
     
    public static void marshallIncidencias(Incidencias inJAXB, String rutaActividad){
         // Creamos el contexto JAXBContext para nuestra clase incidencias
            JAXBContext contexto;
            
         try {
            contexto = JAXBContext.newInstance(Incidencias.class);
             // Declaramos el serializador
            Marshaller m = contexto.createMarshaller();
            // Fichero que vamos a generar
            File f = new File(rutaActividad + "nuevo_fichero_incidencias.xml");
            // Con esta propiedad hacemos que escriba el texto con formato xml, en vez de todo en una línea
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                        
            m.marshal(inJAXB, f);
            
             System.out.println("Archivo creado con éxito.\n");
         } catch (JAXBException ex) {
             Logger.getLogger(Traspaso.class.getName()).log(Level.SEVERE, null, ex);
         }
            
    
    }
    
}
