package edu.erp.servicios;

import edu.erp.entidades.Producto;
import java.util.*;

public class PedidoServicio {
/*
    arena común,arena fina,ripio grueso,ripio fino
    ,piedra,cemento Holcim,cal sublime,yeso Yemaco,
    hierro de 10mmx12m,hierro de 12mmx12m,
    hierro de 6mmx12m,metal desplegado x5 hojas
  */  
    public void EjecutarPedido(Integer AC, Integer AF, Integer RG, Integer RF, Integer Piedra, Integer cemento, Integer cal, Integer yeso, Integer hierro10x12,
    Integer hierro12x12,Integer hierro6x12, Integer metalD){
    ArrayList<Producto> list = new ArrayList();
    Producto prod = new Producto();
        for (int i = 0; i < 12; i++) {
            switch(i){
                case 0:
                    if (AC!=null || AC==0){
                    prod.setNombre("Arena Común");
                    prod.setStock(AC);
                    list.add(prod);}
                break;
                case 1:
                        if (AF!=null || AF==0){
                    prod.setNombre("Arena Fina");
                    prod.setStock(AF);
                    list.add(prod);}
                break;
                case 2:
                         if (RG!=null || RG==0){
                    prod.setNombre("Ripio Grueso");
                    prod.setStock(RG);
                    list.add(prod);}
                break;
                case 3:
                         if (RF!=null || RF==0){
                    prod.setNombre("Ripio Fino");
                    prod.setStock(RF);
                    list.add(prod);}
                break;
                case 4:
                         if (Piedra!=null || Piedra==0){
                    prod.setNombre("Piedra");
                    prod.setStock(Piedra);
                    list.add(prod);}
                break;
                case 5:
                    if (cemento!=null || cemento==0){
                    prod.setNombre("Cemento");
                    prod.setStock(cemento);
                    list.add(prod);}
                break;
                case 6:
                if (cal!=null || cal==0){
                    prod.setNombre("Cal");
                    prod.setStock(cal);
                    list.add(prod);}
                break;
                case 7:
                    if (yeso!=null || yeso==0){
                    prod.setNombre("Yeso");
                    prod.setStock(yeso);
                    list.add(prod);}
                break;
                case 8:
                         if (hierro10x12!=null || hierro10x12==0){
                    prod.setNombre("Hierro 10mmx12mm");
                    prod.setStock(hierro10x12);
                    list.add(prod);}
                break;
                case 9:
                         if (hierro12x12!=null || hierro12x12==0){
                    prod.setNombre("Hierro 12mmx12mm");
                    prod.setStock(hierro12x12);
                    list.add(prod);}
                break;
                case 10:
                         if (hierro6x12!=null || hierro6x12==0){
                    prod.setNombre("Hierro 6mmx12mm");
                    prod.setStock(hierro6x12);
                    list.add(prod);}
                break;
                case 11:
                         if (metalD!=null || metalD==0){
                    prod.setNombre("Hierro desplegado x5 hojas");
                    prod.setStock(metalD);
                    list.add(prod);}
                break;
                    }
            }
                   
            
        }
    
    
    
    public void AnalizarStock(List<Producto> list){
        for (int i = 0; i < list.size()+1; i++) {
            ;
            
        }
    }
        
}
