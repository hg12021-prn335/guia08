/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Meta;

/**
 * Jersey REST client generated for REST resource:MetaResource [Meta]<br>
 * USAGE:
 * <pre>
 *        Client client = new Client();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author luis
 */

@Named("meta")
@ViewScoped
public class Cliente implements Serializable{

    Client cliente;
    WebTarget target;
    String tar;
    List<Meta> salida;
    
    
    
    
    
    public Cliente(){
        try{
            cliente = (Client) ClientBuilder.newClient();
            target = cliente.target("http://localhost:8080/Web/webresources/Meta/allRegistro");
        }catch(Exception ex){
            
        }
    }
 
    public List<Meta> findAll(){
        
        salida=null;
        try{
            
            if (tar!=null&&tar!=" ") {
                if(tar.length()==0){
                 salida = new ArrayList<>();
                 System.out.println(tar+"vacio");
            }else{
                
            
           List <Meta> encontrado;
           encontrado = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Meta>>(){});
            salida =new ArrayList<>();
            for (Meta meta : encontrado) {
               
                if (meta.getNombre()!= null && meta.getNombre().matches("(.*)" + tar +"(.*)")) {
                    salida.add(meta);
                }
            }
            salir();
            
            }}
            
        }catch(Exception ex){
            
        } finally {
            if(salida == null){
                salida = new ArrayList();
            }
        }
        return salida;
    }

    public String getTar() {
        return tar;
    }

    public void setTar(String tar) {
        this.tar = tar;
    }
    
    
    public String salir(){
        if (""==salida.toString()) {
            return "no se encontrado datos";
        }
        return "";
    }
    
}
