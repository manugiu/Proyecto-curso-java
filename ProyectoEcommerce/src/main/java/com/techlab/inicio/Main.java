package com.techlab.inicio;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) throws CantidadInvalidaException {
            abrirMenu();
        }

        public static void abrirMenu() throws CantidadInvalidaException {
            int opcion;
            System.out.println("===================================");
            System.out.println("SISTEMA DE GESTIÓN DE TECHLAB");
            System.out.println("===================================");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar/actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear un pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("7) Salir");
            System.out.print("Su elección: ");
            Scanner scanner = new Scanner(System.in);
            opcion = scanner.nextInt();
            while ((opcion) < 1 | opcion > 7){
                abrirMenu();
            }
            if (opcion == 1) agregarProducto();
            if (opcion == 2) listarProductos();
            if (opcion == 3) buscarProducto();
            //if (opcion == 4) eliminarProducto();
            //if (opcion == 5) creadPedido();
            //if (opcion == 6) listarPedidos();
            if (opcion == 7) {return;}
        }

         public static void agregarProducto() throws CantidadInvalidaException {
            String nombre;
            double precio;
            int stock;
            int contID = 0;

            System.out.print("Nombre del producto: ");
            Scanner n = new Scanner(System.in);
            nombre = n.nextLine();

            System.out.print("Precio del producto: ");
            Scanner p = new Scanner(System.in);
            precio = p.nextDouble();

            System.out.print("Stock del producto: ");
            Scanner s = new Scanner(System.in);
            stock = s.nextInt();


            Producto prod = new Producto(nombre, precio, stock);

            productos.add(prod);

            abrirMenu();

        }


    public static void listarProductos() throws CantidadInvalidaException {
        for (Producto p : productos) {
            p.mostrarInfo(p);
        }
        abrirMenu();
    }

   public static void buscarProducto() throws CantidadInvalidaException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto a buscar: ");
        int idBuscado = scanner.nextInt();
        try {
             System.out.println("Tu producto es: " + productos.get(idBuscado - 1).getNombre());
            }
            catch (Exception e){
                System.out.println("No existe un producto con ese ID. Intente denuevo.");
                buscarProducto();
            }
       System.out.println("1) Modificar precio.");
       System.out.println("2) Modificar stock.");
       System.out.println("3) Volver al menu.");
       Scanner opc = new Scanner(System.in);
       int opcion = opc.nextInt();
       if (opcion == 1){
           Scanner scanner3 = new Scanner(System.in);
           System.out.print("Ingrese el nuevo precio: ");
           int prec = scanner3.nextInt();
           if (prec < 0) {
               throw new CantidadInvalidaException("Debe ser mayor a 0");
           }
           productos.get(idBuscado-1).setPrecio(prec);
       } else if (opcion == 2){
           Scanner scanner4 = new Scanner(System.in);
           System.out.print("Ingrese el nuevo stock: ");
           int st = scanner4.nextInt();
           if (st < 0) {
               throw new CantidadInvalidaException("Debe ser mayor a 0");
           }
           productos.get(idBuscado-1).setStock(st);
       }
       abrirMenu();
       }



    public static void eliminarProducto(){}

    }