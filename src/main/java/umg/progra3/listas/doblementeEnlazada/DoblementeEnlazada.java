package umg.progra3.listas.doblementeEnlazada;

public class DoblementeEnlazada {
    int zice;
    private Nodo head;
    private Nodo tail;

    public DoblementeEnlazada() {
        this.head = null;
        this.tail = null;
        zice = 0;
    }

    public void insertAtEnd(int data) {
        Nodo newNode = new Nodo(data);
        if (tail == null) {
            head = tail = newNode;
            zice++;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            zice++;
        }
    }

    public void insertAtBeginning(int data) {
        Nodo newNode = new Nodo(data);
        if (head == null) {
            head = tail = newNode;
            zice++;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            zice++;
        }
    }

    public boolean delete(int data) {
        Nodo current = head;
        while (current != null) {
            if (current.data == data) {
                if (current == head) {
                    head = current.next;
                    if (head != null)
                        head.prev = null;
                } else if (current == tail) {
                    tail = current.prev;
                    if (tail != null)
                        tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                zice--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean search(int data) {
        Nodo current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void displayForward() {
        Nodo current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("null");
            return;
        }

        Nodo current = tail;
        while (current != null) {
            // Imprime el dato del nodo actual
            System.out.print(current.data);

            // Si hay un nodo anterior, imprime "<->", si no, imprime " -> null"
            if (current.prev != null) {
                System.out.print(" <-> ");
            } else {
                System.out.print(" -> null");
            }

            current = current.prev;
        }
        System.out.println(); // Salto de línea al final
    }

    // Método 1: Contar el número de nodos en la lista
    public int zice(){
        return zice;
    }

    // Método 2: Insertar un nodo después de un valor específico
    public void insertAfterValue(int data, int value){
        Nodo current = head;
        Nodo newNode = new Nodo(value);

        while (current != null && current.data != data) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("No se encontro el dato");
            return;
        }
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        zice++;
    }

    // Método 3: Revertir la lista doblemente enlazada
    public void reverseList(){
        Nodo current = head;
        Nodo prev = null;
        Nodo next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

}
