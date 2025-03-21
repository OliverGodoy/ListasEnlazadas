package umg.progra3.listas;

import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;

public class Principal {
    public static void main(String[] args) {

        Lista lista = new Lista();
        lista.insertarCabezaLista(4);
        lista.insertarCabezaLista(14);
        lista.insertarCabezaLista(2);
        lista.insertarCabezaLista(1);
        lista.insertarCabezaLista(6);
        lista.insertarCabezaLista(6);

//        lista.visualizar();
//        System.out.println("\nTamaño " + lista.zice);
//        lista.invertir(lista);
//
//        lista.eliminarDuplicados(lista);
//        System.out.println("\n");
//        lista.visualizar();
//        lista.obtenerElementoDesdeElFinal(4);



        //Ejercicio 1 Ordernar la lista de forma ascendente
        Lista listaOrdenar = new Lista();
        listaOrdenar.insertarCabezaLista(23);
        listaOrdenar.insertarCabezaLista(45);
        listaOrdenar.insertarCabezaLista(1);
        listaOrdenar.insertarCabezaLista(10);
        listaOrdenar.insertarCabezaLista(5);

        System.out.println("\nLista sin ordenar: ");
        listaOrdenar.visualizar();
        listaOrdenar.ordenarAscendente();
        System.out.println("\nLista ordenada");
        listaOrdenar.visualizar();
        System.out.println("\n");


        //Ejercicio 2 Unir dos listas enlazadas
        Lista listaUnir = new Lista();
        Lista listaUnir2 = new Lista();
        Lista listaUnida = new Lista();
        listaUnir.insertarCabezaLista(14);
        listaUnir.insertarCabezaLista(23);
        listaUnir.insertarCabezaLista(200);
        listaUnir.insertarCabezaLista(1);

        listaUnir2.insertarCabezaLista(40);
        listaUnir2.insertarCabezaLista(20);
        listaUnir2.insertarCabezaLista(4);
        listaUnir2.insertarCabezaLista(7);

        for(int i = 0; i < listaUnir.zice; i++){
            int valor = listaUnir.obtenerValor(i);
            listaUnida.insertarCabezaLista(valor);

        }
        for(int j = 0; j < listaUnir2.zice; j++){
            int valor = listaUnir2.obtenerValor(j);
            listaUnida.insertarCabezaLista(valor);

        }

        System.out.println("\nLista numero 1");
        listaUnir.visualizar();
        System.out.println("\nLista numero 2");
        listaUnir2.visualizar();
        System.out.println("\nLista unida");
        listaUnida.visualizar();
        System.out.println("\n");


        //Ejercicio 3 Separa numeros pares e impares en dos listas enlazadas diferentes
        Lista listaPares = new Lista();
        Lista listaImpares = new Lista();
        Lista listaPrincipal = new Lista();

        listaPrincipal.insertarCabezaLista(1);
        listaPrincipal.insertarCabezaLista(2);
        listaPrincipal.insertarCabezaLista(3);
        listaPrincipal.insertarCabezaLista(4);
        listaPrincipal.insertarCabezaLista(5);
        listaPrincipal.insertarCabezaLista(6);
        listaPrincipal.insertarCabezaLista(7);
        listaPrincipal.insertarCabezaLista(8);
        listaPrincipal.insertarCabezaLista(9);
        listaPrincipal.insertarCabezaLista(10);

        int tamanio = listaPrincipal.zice;
        for(int i = 0; i < tamanio; i ++){
            int valor = listaPrincipal.obtenerValor(i);
            if (valor % 2 == 0) {
                listaPares.insertarCabezaLista(valor);
            } else {
                listaImpares.insertarCabezaLista(valor);
            }
        }

        System.out.println("\nLista principal");
        listaPrincipal.visualizar();
        System.out.println("\nLista de pares");
        listaPares.visualizar();
        System.out.println("\nLista impares");
        listaImpares.visualizar();




    }
}
