package com.techlab.inicio;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private ArrayList productos;
    private int id;
    private static int ultID = 0;

    Producto(String nombre, double precio, int stock){
        this.id= ++ultID;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {this.nombre = nombre;}

    public double getPrecio() {return precio;}

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {return stock;}

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void mostrarInfo(Producto p){
        System.out.println("ID: " + p.id + " - Producto: " + p.nombre + " - Precio: $" + p.precio + " - Stock: " + p.stock);
    }





}
