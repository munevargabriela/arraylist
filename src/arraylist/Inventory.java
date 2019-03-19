/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import arraylist.empleado;

/**
 *
 * @author jtumialan
 */
public class Inventory {//implements Serializable {
    ArrayList<empleado> listaempleado;
    File file;//declara variable una memoria

    public Inventory(){//costructor
        listaempleado = new ArrayList<empleado>();//la inicializa dentro de la clase inventario
        file = new File("datos.txt");//instancio(reservar un espacio de memoria)

        if(!file.exists()){//si no existe
            try {//try execciones evita que se cierre y manda un mensaje de error
             ///   file.getParentFile().mkdirs();
                file.createNewFile();//se crea 

            } catch (IOException ex) {//existe un error 
                      System.out.println("fgfh");
                Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
          
            }        
        }

        if(file.length() !=0){//ya existe
            loadFile(file);//lo abre//carga el archivo funcion que esta abajo
        }
    }

    public void addProduct(empleado empleado){
        listaempleado.add(empleado);//le pasa el producto del arraylist
        saveFile(this.file);
    }

    public void saveFile(File file){   //salvar el archivo             
        try{    
            FileOutputStream fos = new FileOutputStream(file);//apuntar donde esta el file
            ObjectOutputStream out = new ObjectOutputStream(fos);//apunta al otro --tres apuntandose uno al otr--
            out.writeObject(listaempleado);//array lis de productos
            out.close();//cerrar
            fos.close();//cerrar
        } catch(FileNotFoundException ex){System.out.println("FileNotFoundException");}
           catch(IOException ex){System.out.println("InputException");}                   
    }

    public void loadFile(File file){//cargar archivo
            try{

            FileInputStream fis = new FileInputStream(file);//solo de lectura tienen input
                ObjectInputStream in = new ObjectInputStream(fis);
                listaempleado=(ArrayList<empleado>)in.readObject();//caragar todo el array list de n dimenciones a la memoria
                in.close();//cerrar
                fis.close();//cerrar
            } catch(FileNotFoundException ex){ System.out.println("FileNotFoundException"); }
               catch(IOException ex){System.out.println("OutputException");} 
                catch(ClassNotFoundException ex){System.out.println("ClassNotFoundException");}

    }
    
    public int buscar(int cedula){
        for(int i=0; i<listaempleado.size(); i++){
            if (cedula == listaempleado.get(i).getID()){
                
                return i;
            }
           
        }
        return -1;
    }
     public void Actualizar(){
        listaempleado.remove(this); /* */
        saveFile(this.file);
    }
    public void limpiar(){
        listaempleado.clear();
        saveFile(this.file);
    }
}