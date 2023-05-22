
/***************************************************************

CONCEPTOS

1.La herencia permite que una clase adquiera los atributos y métodos de otra clase 
=verdadera. La herencia en la programación orientada a objetos permite que una clase adquiera los atributos y métodos de otra clase, lo que permite la reutilización de código y la creación de jerarquías de clases. 

2.El polimorfismo permite que un objeto se comporte de diferentes formas según el contexto.
=verdadero. el poliforfismo permite que un objeto pueda comportarse de diferentes formas según el contexto en el que se utilice.

3.En Java, una clase puede heredar de múltiples clases al mismo tiempo.
 =falso. En Java, una clase puede heredar de una sola clase a la vez

 4. El método “super()” se utiliza en una clase hija para llamar al constructor de la clase padre
=verdadero. El método "super()" se utiliza en una clase hija para llamar al constructor de la clase padre

5. En el polimorfismo, se puede utilizar una referencia de la clase padre para referirse a un objeto de la clase hija.
=verdadera. puedes declarar una variable de tipo de la clase padre y asignarle un objeto de la clase hija. A través de esta referencia, puedes acceder a los métodos y propiedades comunes de la clase padre. 

6. ¿Cuál de las siguientes opciones describe correctamente la herencia en programación orientada a objetos?
= A)  La capacidad de una clase de heredar propiedades y métodos de otra clase.

7. ¿Cuál de las siguientes opciones describe mejor el polimorfismo en Java?
=D) La capacidad de un objeto de ser tratado como uno de varios tipos posibles. 

8. ¿Cuál de las siguientes afirmaciones sobre las clases abstractas es correcta?
= D) Se utilizan como plantillas para crear subclases concretas. la A no puede ser ser debido a que una de las cosas que se destaca en las clases abstractas es que no se pueden instanciar. la B tampoco seria debido a que en java no permite herencia multiple y la C no porque las clases abstractas pueden contener métodos abstractos, que son métodos declarados pero no implementados en la clase abstracta. 

9. ¿Cuál de las siguientes opciones describe mejor el concepto de sobreescritura de métodos en Java?
=A) La capacidad de una subclase de proporcionar una implementación diferente para un método heredado de la clase padre. 

10. ¿Cuál de las siguientes afirmaciones sobre las interfaces en Java es correcta?
=D) Se utilizan para definir un contrato que una clase debe cumplir.

  *************************************************************/
import java.util.*;

//1. Clase `ConjuntoDeDatos`

//se crea la clase abstracta
 abstract class ConjuntoDeDatos { 
  
    protected String nombre;  //sus atributos
    protected int tamaño;

    public ConjuntoDeDatos(String nombre, int tamaño) { //el constructor
        this.nombre = nombre;
        this.tamaño = tamaño;
    }

   public String getNombre(){ return nombre; }

    public abstract String describir(); //el metodo abstracto 
}

//2. Clase `ConjuntoDeDatosTabular`

//se crea la clase conjuntoDeDatosTabular y se hereda la clase ConjuntoDeDatos
 class ConjuntoDeDatosTabular extends ConjuntoDeDatos { 
    private int numeroDeColumnas; //los atributos de la clase
    private int numeroDeFilas;

    public ConjuntoDeDatosTabular(String nombre, int tamaño, int numeroDeColumnas, int numeroDeFilas) { //el constructor
      //llama al constructor de la clase padre ConjuntoDeDatos.
        super(nombre, tamaño);
        this.numeroDeColumnas = numeroDeColumnas;
        this.numeroDeFilas = numeroDeFilas;
    }

  //sobre escribe el metodo describir
    @Override
    public String describir() {
      // retorna nombre, tamaño, tabular, filas, columnas; 
        return "Nombre: " + nombre +
               "\nTamaño: " + tamaño +
               "\nTabular" +
               "\nFilas: " + numeroDeFilas +
               "\nColumnas: " + numeroDeColumnas;
    }
}

//3. Clase ConjuntoDeDatosImagen

//se crea la clase padre que hereda de ConjuntoDeDatos
 class ConjuntoDeDatosImagen extends ConjuntoDeDatos { 
    private int ancho; //atributos de la clase
    private int alto;

    public ConjuntoDeDatosImagen(String nombre, int tamaño, int ancho, int alto) {  //constructor 
        super(nombre, tamaño);
        this.ancho = ancho;
        this.alto = alto;
    }

  //se sobre escribe el metodo, para ello se utiliza la anotación @Override
    @Override
    public String describir() {
        //se retorna el nombre, tamaño (estos dos atributos están en la clase ConjuntoDeDatos, pero como se heredó se pueden usar en esta clase), se imprime "Imagen", el ancho y el alto. Todo esto se guarda en una variable llamada descripcion, que al final se retorna.
        String descripcion = "Nombre: " + this.nombre + "\n";
        descripcion += "Tamaño: " + this.tamaño + "\n";
        descripcion += "Imagen\n";
        descripcion += "Ancho: " + this.ancho + "\n";
        descripcion += "Alto: " + this.alto;
        return descripcion;
    }
}

//4. Clase AnalizadorDeDatos
//se crea la clase
 class AnalizadorDeDatos { 
    private ArrayList<ConjuntoDeDatos> conjuntosDeDatos; //se crea el ArrayList de tamaño ConjuntoDeDatos con el nombre conjuntosDeDatos 
 
    public AnalizadorDeDatos() {  //constructor 
        conjuntosDeDatos = new ArrayList<>();
    }

  //metodo para añadir al ArrayList los conjutosDeDatos
    public void añadirConjuntoDeDatos(ConjuntoDeDatos conjuntoDeDatos) {
        conjuntosDeDatos.add(conjuntoDeDatos); //los agrega
    }

  //un metodo para eliminar del ArrayList el conjunto de datos basandose en su nombre 
    public void eliminarConjuntoDeDatos(String nombre) {
      
      //se declara una variable conjuntoEliminado de tipo ConjuntoDeDatos e inicialízala con el valor null
        ConjuntoDeDatos conjuntoEliminado = null;
      
      //Inicia un bucle for-each que recorre cada elemento conjunto en la lista conjuntosDeDatos
        for (ConjuntoDeDatos conjunto : conjuntosDeDatos) {
          
     // se verifica si el nombre del conjunto de datos actual (conjunto.getNombre()) es igual al nombre pasado como argumento al método (nombre).     

          
            if (conjunto.getNombre().equals(nombre)) {

    //Si los nombres coinciden, se asigna el conjunto actual a la variable conjuntoEliminado y se sale del bucle usando la instrucción break
                conjuntoEliminado = conjunto;
                break;
            }
        }
      //se verifica si la variable conjuntoEliminado no es null, lo que significa que se encontró un conjunto de datos con el nombre especificado
        if (conjuntoEliminado != null) {

          //si el conjunto no es null se llama el metodo remover y se elimina del ArrayList conjuntosDeDatos
            conjuntosDeDatos.remove(conjuntoEliminado);
        }
    }

    public ArrayList<String> describirConjuntosDeDatos() {

      //se declara la variable descrpcion que es un ArrayList de tipo String, e inicialízala como un nuevo objeto ArrayList
        ArrayList<String> descripciones = new ArrayList<>();
      
   // se crea un for each que recorre cada elemento conjunto en la lista conjuntosDeDatos    
        for (ConjuntoDeDatos conjunto : conjuntosDeDatos) {
          
          //se llama al método describir(). La descripción obtenida se agrega a la lista descripciones 
            descripciones.add(conjunto.describir());
        }
     // se retorna la lista descripciones
        return descripciones;
    }
}


//5. Opcional: Main para validar el funcionamiento de las clases anteriores.


public class Main {
    public static void main(String[] args) {
System.out.println("holaa");

      
        // Crear conjuntos de datos
        ConjuntoDeDatosTabular conjuntoTabular = new ConjuntoDeDatosTabular("Datos de estudiantes", 1000, 200, 5);
        ConjuntoDeDatosImagen conjuntoImagen1 = new ConjuntoDeDatosImagen("Imágenes de satélite", 2000, 1080, 720);
        ConjuntoDeDatosImagen conjuntoImagen2 = new ConjuntoDeDatosImagen("Imágenes de satélite", 2000, 1080, 720);

        // Crear analizador de datos
        AnalizadorDeDatos analizador = new AnalizadorDeDatos();

        // Añadir conjuntos de datos al analizador
        analizador.añadirConjuntoDeDatos(conjuntoTabular);
        analizador.añadirConjuntoDeDatos(conjuntoImagen1);
        analizador.añadirConjuntoDeDatos(conjuntoImagen2);

        // Describir conjuntos de datos
        ArrayList<String> descripciones = analizador.describirConjuntosDeDatos();

        // Imprimir descripciones
        for (String descripcion : descripciones) {
            System.out.println(descripcion);
            System.out.println("------------------------------");
        }

    }

}



