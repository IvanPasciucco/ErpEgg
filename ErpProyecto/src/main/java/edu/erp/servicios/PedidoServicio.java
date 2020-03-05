package edu.erp.servicios;

import edu.erp.entidades.Empleado;
import edu.erp.entidades.Pedidos;
import edu.erp.entidades.Producto;
import edu.erp.entidades.errores.ErrorServicio;
import edu.erp.repositorios.EmpleadosRepositorio;
import edu.erp.repositorios.ProductoRepositorio;
import edu.erp.repositorios.VehiculoRepositorio;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private EmpleadosRepositorio empleadosRepositorio;
    @Autowired
    private VehiculoRepositorio vehiculoRepositorio;
    /*
    arena común,arena fina,ripio grueso,ripio fino
    ,piedra,cemento Holcim,cal sublime,yeso Yemaco,
    hierro de 10mmx12m,hierro de 12mmx12m,
    hierro de 6mmx12m,metal desplegado x5 hojas
  */ 
    public Pedidos EjecutarPedido(Integer AC, Integer AF, Integer RG, Integer RF, Integer Piedra, Integer cemento, Integer cal, Integer yeso, Integer hierro10x12,
    Integer hierro12x12,Integer hierro6x12, Integer metalD) throws ErrorServicio{
        List<Producto> productoPedido = AnalizarPedido(AC,AF,RG,RF,Piedra,cemento,cal,yeso,hierro10x12,hierro12x12,hierro6x12,metalD);
        Pedidos pedidos = new Pedidos();
        pedidos.setProductos(productoPedido);
        pedidos.setFechaAutomatica(new Date());
        pedidos.setEmpleados(new Empleado());
        //agregar empleados

    }
    
    
    public List<Producto> AnalizarPedido(Integer AC, Integer AF, Integer RG, Integer RF, Integer Piedra, Integer cemento, Integer cal, Integer yeso, Integer hierro10x12,
    Integer hierro12x12,Integer hierro6x12, Integer metalD)throws ErrorServicio{
    ArrayList<Producto> list = new ArrayList();
    Producto prod = new Producto();
        for (int i = 0; i < 12; i++) {
            switch(i){
                case 0:
                    if (AC!=null || AC==0){
                    prod.setNombre("Arena Común");
                    prod.setStock(AC);
                    list.add(i,prod);}
                break;
                case 1:
                        if (AF!=null || AF==0){
                    prod.setNombre("Arena Fina");
                    prod.setStock(AF);
                    list.add(i,prod);}
                break;
                case 2:
                         if (RG!=null || RG==0){
                    prod.setNombre("Ripio Grueso");
                    prod.setStock(RG);
                    list.add(i,prod);}
                break;
                case 3:
                         if (RF!=null || RF==0){
                    prod.setNombre("Ripio Fino");
                    prod.setStock(RF);
                    list.add(i,prod);}
                break;
                case 4:
                         if (Piedra!=null || Piedra==0){
                    prod.setNombre("Piedra");
                    prod.setStock(Piedra);
                    list.add(i,prod);}
                break;
                case 5:
                    if (cemento!=null || cemento==0){
                    prod.setNombre("Cemento");
                    prod.setStock(cemento);
                    list.add(i,prod);}
                break;
                case 6:
                if (cal!=null || cal==0){
                    prod.setNombre("Cal");
                    prod.setStock(cal);
                    list.add(i,prod);}
                break;
                case 7:
                    if (yeso!=null || yeso==0){
                    prod.setNombre("Yeso");
                    prod.setStock(yeso);
                    list.add(i,prod);}
                break;
                case 8:
                         if (hierro10x12!=null || hierro10x12==0){
                    prod.setNombre("Hierro 10mmx12mm");
                    prod.setStock(hierro10x12);
                    list.add(i,prod);}
                break;
                case 9:
                         if (hierro12x12!=null || hierro12x12==0){
                    prod.setNombre("Hierro 12mmx12mm");
                    prod.setStock(hierro12x12);
                    list.add(i,prod);}
                break;
                case 10:
                         if (hierro6x12!=null || hierro6x12==0){
                    prod.setNombre("Hierro 6mmx12mm");
                    prod.setStock(hierro6x12);
                    list.add(i,prod);}
                break;
                case 11:
                         if (metalD!=null || metalD==0){
                    prod.setNombre("Hierro desplegado x5 hojas");
                    prod.setStock(metalD);
                    list.add(i,prod);}
                break;
                    }
                 List<Producto> retorno = AnalizarStock(list);
            }
                   
            
        }
    
   
    
    public List<Producto> AnalizarStock(List<Producto> list) throws ErrorServicio{
        Optional lprod= productoRepositorio.BuscarProductos();
        List<Producto> retorno = new ArrayList<Producto>();
        try{
           
        for (int i = 0; i < list.size()+1; i++) {
            if (list.get(i).getStock()<lprod.get().getStock()){
                lprod.get().setStock((lprod.get().getStock())-list.get(i).getStock());
                retorno.add(i,list.get(i));
        }else{   
                if (lprod.get(i).getStock()==0){
                    retorno.add(i,null);
                    throw new ErrorServicio("No hay stock del producto");
                }
                else{
                    list.get(i).setStock(lprod.get(i).getStock());
                    lprod.get(i).setStock(0);
                    retorno.add(i,list.get(i));
                    throw new ErrorServicio("Se enviara menos del solicitado Stock del producto");
               lprod.
                }
            }
        
        }}catch(ErrorServicio e){
        }
        return retorno;
}}
    