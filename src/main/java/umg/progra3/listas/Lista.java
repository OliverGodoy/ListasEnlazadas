package umg.progra3.listas;

public class Lista {
    private Nodo primero;
    int zice;


    @Override
    public String toString() {
        return "=>" + primero;
    }

    /**
     * Constructor para inicializar una lista
     */
    public Lista() {
        primero = null;
        zice = 0;
    }

    /**
     * Devuelve el nodo inicial
     *
     * @return
     */
    public Nodo leerPrimero() {
        return primero;
    }

    /**
     * Inserta valores a la lista
     *
     * @param entrada
     */
    public void insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;
        zice++;
    }

    /**
     * inserta un elemento a partir de anterior
     *
     * @param anterior
     * @param entrada
     */
    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;
        zice++;
    }

    /**
     * elimina el elemento entrada
     *
     * @param entrada
     */
    public void eliminar(int entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        actual = primero;
        anterior = null;
        encontrado = false;
        // Bucle de búsqueda
        while ((actual != null) && !(actual.dato == entrada)) {
            if (!(actual.dato == entrada)) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        if (actual != null) {
            // Se distingue entre que el nodo sea el cabecera
            // o del resto de la lista
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
        zice--;
    }

    /**
     * busca el elemento destino
     *
     * @param destino
     * @return
     */
    public Nodo buscarLista(int destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (indice.dato == destino) {
                return indice;
            }
        }
        return null;
    }

    /**
     * recorre la lista y muestra cada dato
     */
    public void visualizar() {
        Nodo n;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
    }

    /**
     * Obtener valor en una lista
     * @param valor
     */
    public int obtenerValor(int valor){
        Nodo actual = primero; // Empezar desde el primer nodo
        int contador = 0;

        // Recorrer la lista hasta llegar al índice i
        while (actual != null && contador < valor) {
            actual = actual.enlace; // Mover al siguiente nodo
            contador++;
        }

        // Si el índice es válido, devolver el valor del nodo
        if (actual != null) {
            return actual.dato;
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + valor);
        }
    }

    /**
     * Crear los metodos que se solicitan
     /**

     * 1 - Método para invertir la lista enlazada
     */
    public void invertir(Lista lista){
        for (int i = lista.zice() - 1; i >= 0; i--) {
            System.out.print(lista.obtenerValor(i) + " ");
        }
    }

    /**
     * 2 - Método para obtener el elemento en la posición n desde el final
     */
    public int obtenerElementoDesdeElFinal(int valor) {
        Nodo actual = primero;
        int tamanio = 0;

        // Calcular el tamaño de la lista
        while (actual != null) {
            actual = actual.enlace;
            tamanio++;
        }

        // Verificar si el índice es válido
        if (valor < 0 || valor >= tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + valor);
        }

        // Calcular la posición desde el inicio
        int posicionDesdeInicio = tamanio - 1 - valor;

        // Recorrer la lista hasta la posición deseada
        actual = primero;
        for (int i = 0; i < posicionDesdeInicio; i++) {
            actual = actual.enlace;
        }
        System.out.println("\nElemento = "+ actual.dato);
        return actual.dato;
    }


    /**
     * 3 - Método para eliminar duplicados en una lista enlazada
     */
    public void eliminarDuplicados(Lista lista){
        Nodo actual = primero;

        while (actual != null) {
            Nodo comparador = actual; // Nodo para comparar con los siguientes

            while (comparador.enlace != null) {
                if (comparador.enlace.dato == actual.dato) {
                    // Eliminar el nodo duplicado
                    comparador.enlace = comparador.enlace.enlace;
                    zice--; // Reducir el tamaño de la lista
                } else {
                    comparador = comparador.enlace; // Mover al siguiente nodo
                }
            }
            actual = actual.enlace; // Mover al siguiente nodo
        }
    }

    /**
     * 4 - Método para obtener el tamaño de la lista enlazada
     */
    public int zice(){
        return zice;
    }

    /**
     *  Metodo para ordenar la lista de forma ascendente
     */
    public void ordenarAscendente() {
        if (primero == null || primero.enlace == null) {
            return; // La lista ya está ordenada o vacía
        }

        boolean intercambio;
        do {
            intercambio = false;
            Nodo actual = primero;
            Nodo anterior = null;

            while (actual.enlace != null) {
                if (actual.dato > actual.enlace.dato) {
                    // Intercambiar los valores
                    int temp = actual.dato;
                    actual.dato = actual.enlace.dato;
                    actual.enlace.dato = temp;
                    intercambio = true;
                }
                anterior = actual;
                actual = actual.enlace;
            }
        } while (intercambio);
    }


}
