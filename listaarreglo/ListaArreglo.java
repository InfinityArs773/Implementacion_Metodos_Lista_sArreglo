package listaarreglo;

public class ListaArreglo {

    public static void main(String[] args) {

        ArrayList<String> array = new ArrayList<String>(String.class, 10);

       
        array.append("Japon");
        array.append("España");
        array.append("Mexico");

        System.out.println("Lista inicial: " + array);

        
        System.out.println("Indice de Mexico: " + array.indexOf("Mexico"));
        System.out.println("Indice de China: " + array.indexOf("China"));

     
        System.out.println("Se elimino Japon?: " + array.removeObj("Japon"));
        System.out.println("Lista despues de removeObj: " + array);

        
        array.insert("China", 0);
        System.out.println("Lista despues de insert: " + array);

       
        array.set("Corea", 1);
        System.out.println("Lista despues de set: " + array);

        
        System.out.println("Elemento en el indice 1: " + array.get(1));


        System.out.println("Numero de elementos: " + array.size());

        // Probarmos el Iterator
        System.out.println("Elementos usando Iterator:");
        for (String elemento : array) {
            System.out.println(elemento);
        }

       
        array.clear();
        System.out.println("Lista despues de clear: " + array);
        System.out.println("Numero de elementos: " + array.size());
        System.out.println("La lista esta vacia?: " + array.empty());
    }
}