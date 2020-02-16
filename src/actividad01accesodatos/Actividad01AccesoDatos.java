/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad01accesodatos;

import java.util.ArrayList;
import clasesIncidencias.Incidencia;
import clasesIncidencias.Incidencias;
import clasesIncidencias.*;
import java.io.File;

/**
 *
 * @author alex
 */
public class Actividad01AccesoDatos {
    
        private static final String rutaProyecto = System.getProperty("user.dir");
        private static final String separador = File.separator;
        private static final String directorio = "src" + separador + "actividad01accesodatos";
        private static final String rutaActividad = rutaProyecto + separador + directorio + separador;
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //System.out.println(rutaActividad);
                
        //EJERCICIO 3
        
        System.out.println("Creación de objetos Mi_incidencia desde el archivo txt.\n");
        Traspaso tp = new Traspaso();
        String resultadoConsulta = "";
        
        ArrayList<MiIncidencia> listadoIncidencias = tp.leerArchivoIncidencias(rutaActividad);
        System.out.println("Numero de incidencias: " + listadoIncidencias.size() + "\n");
        for( MiIncidencia i : listadoIncidencias){
            System.out.println(i.toString());
        }
        
        System.out.println("\n**********************************************\n");
        
        //EJERCICIO 4
        
        System.out.println("Creación de objetos Incidencia Jaxb desde el archivo txt.\n");
        Incidencias inJAXB = tp.leerArchivoIncidenciasJAXB(rutaActividad);
         System.out.println("Numero de incidencias: " + inJAXB.getIncidencia().size() + "\n");
        for(Incidencia i : inJAXB.getIncidencia()){
            System.out.println("Fecha: " + i.getFechahora() + " -- Origen: " + i.getOrigen() + " -- Destino: " + i.getDestino() + " -- Detalle: " + i.getDetalle() + " -- Tipo: " + i.getTipo());
        }
        
        System.out.println("\n**********************************************\n");
        
        Traspaso.marshallIncidencias(inJAXB, rutaActividad);
        
        
        //EJERCICIO 5
        
        ConsultaXpath cxPath = new ConsultaXpath();
        
        if(cxPath.abrir_file_DOM() == 0){
            String consulta = "/incidencias/incidencia/@fechahora[../destino='jramirez']|/incidencias/incidencia/*[../destino='jramirez']";
            //(cxPath.Ejecutar_XPath(consulta));
            //System.out.println("OK");
            
            resultadoConsulta = (cxPath.Ejecutar_XPath(consulta));
            System.out.println(resultadoConsulta);          
        }
    }
    
}
