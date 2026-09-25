/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaarreglo;
import java.util.Iterator;

/**
 *
 * @author labitson
 */
public class ArrayList<T> implements IList<T>, Iterable<T> {

    protected int nElementos;
    private final int tamLista;
    private final T lista[];
    
    public ArrayList(Class<T> tipoDato, int tamLista){
        this.tamLista = tamLista;
        nElementos = 0;
        lista = (T[]) java.lang.reflect.Array.newInstance(tipoDato,tamLista);
    }
    
    
    @Override
    public void append(T elemento) throws ListException {
        if (nElementos >= tamLista){
            throw new ListException("Lista llena");
        }
        lista[nElementos] = elemento;
        nElementos++;
    }

    @Override
    public void insert(T elemento, int index) throws ListException {
        if (nElementos >= tamLista) {
            throw new ListException("Lista Llena");
    }
            if (index < 0 || index > nElementos) {
               throw new ListException("Index fuera de limites");
    }
           for(int j = nElementos; j > index; j--){
             lista[j] = lista[j - 1];
            }
            lista [index] = elemento; 
            nElementos++;
}

    @Override
    public T remove(int index) throws ListException {
          T o = get(index);

    for (int j = index; j < nElementos - 1; j++) {
        lista[j] = lista[j + 1];
    }

    lista[nElementos - 1] = null;
    nElementos--;

    return o;
    }

    @Override
    public boolean removeObj(T elemento) throws ListException {
    int index = indexOf(elemento);

    if (index == -1) {
        return false;
        }

    remove(index);
    return true;
    }
    
    
    @Override
    public int indexOf(T elemento) {
        for (int i = 0; i < nElementos; i++) {
        if (lista[i].equals(elemento)) {
            return i;
        }
      }

    return -1;
    }

    @Override
    public T get(int index) throws ListException {
        if (index < 0 || index >= nElementos) {
        throw new ListException("Index fuera de limites");
    }

    return lista[index];
}
    

    @Override
    public void set(T elemento, int index) throws ListException {
       if (index < 0 || index >= nElementos){
        throw new ListException("Index fuera de limites");
    }

    lista[index] = elemento;
}

    @Override
    public void clear() {
       for (int i = 0; i < nElementos; i++) {
        lista[i] = null;
        }
    nElementos = 0;
    }
    
    @Override
    public boolean empty() {
        return nElementos == 0; 
    }

    @Override
    public int size() {
        return nElementos;
    }

    @Override
    public java.util.Iterator<T> Iterator() {
        return new Iterator<T>() {

        private int posicion = 0;

        @Override
        public boolean hasNext() {
            return posicion < nElementos;
        }

        @Override
        public T next() {
            return lista[posicion++];
        }
    };
}

    @Override
    public java.util.Iterator<T> iterator() {
        return Iterator();
       } 
    
    @Override
    public String toString() {
    String cadena = "[";

    for (int i = 0; i < nElementos; i++) {
        cadena += lista[i];

        if (i < nElementos - 1) {
            cadena += ", ";
        }
    }

    cadena += "]";

    return cadena;
    }
}
