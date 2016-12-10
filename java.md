# Java

Lenguaje fuertemente tipado (todas las variables tienen que tener tipo de dato declarado).

program.java -> lo compilo y se transforma en bytcode en program.class -> se ejecuta en la JVM, que lo transforma en codigo nativo de la plataforma

Al ser un lenguaje compilado, hay errores en tiempo de compilacion y en tiempo de ejecucion (runtime, compiler).

Recolector de basura: Java runtime mata instancias que no se seguiran utilizando

*Main*: public static void main(String[] args)

foreach:

```java
for (String s: args) {
            System.out.println(s);
        }
```

En tiempo de ejecucion un proceso se divide en:

- Code segment: donde se localizan las instrucciones del programa
- Data segmnent: almacena variables globales, tamanio fijo determinado al comenzar ejecucion
- Stack segment: almacena contenido de variables locales en cada invocacion de los metodos. Tamanio fijo.
- Heap: se utiliza para las peticines dinamicas de memoria, tamanio no fijo

*Operador new* reserva memoria que es asignada dinamicamente para alojar la nueva instancia creada. Toda instancia es alojada en el heap. 

Los archivos .class son portables y no necesitan ser recompilados.

Es de tipado estatico, necesito indicar tipo de dato (vs. Python que es tipado dinamico).

## Ventajas de la POO

- Modularidad: objetoss pueden ser mantenidos independientemente de otros
- Ocultamiento de informacion
- Reutilizacion de codigo
- Pluggability, puede remover el objeto que causa fallas en mi codigo y reemplazarlo sin tocar el resto del sistema

## Type casting

```java
double d = 5.5;
int i;
i = (int) d;
```

## Visibilidad

- public: todos
- privada: solo la misma clase
- protected: visible en package

- static: clase no necesita ser instanciada para llamar método o variable. No pueden hacer referencias a variables de instancia.

- abstract, final

## String

str.

- charAt(3)
- substring(x,y) // inclusivo
- length()
- indexOf()
- split(‘,’)
- concat(otroStr)
- trim // borra espacios en blanco

## Excepciones

```java
try { 
  ...
} catch( IOException | SQLException ex ) { 
  ...
}

try {
        System.out.println("Entering" + " try statement");

        out = new PrintWriter(new FileWriter("OutFile.txt"));
        for (int i = 0; i < SIZE; i++) {
            out.println("Value at: " + i + " = " + list.get(i));
        }
    } catch (IndexOutOfBoundsException e) {
        System.err.println("Caught IndexOutOfBoundsException: "
                           +  e.getMessage());
                                 
    } catch (IOException e) {
        System.err.println("Caught IOException: " +  e.getMessage());
                                 
    } finally {
        if (out != null) {
            System.out.println("Closing PrintWriter");
            out.close();
        } 
        else {
            System.out.println("PrintWriter not open");
        }
    }

public void writeList() throws IOException, IndexOutOfBoundsException {

// throw exception:

if (size == 0) {
        throw new EmptyStackException();
    }

```

## Arrays

```java
data[10] = {10,20,30,40,50,60,71,80,90,91};

int[] data;
data = new int[] {10,20,30,40,50,60,71,80,90,91};

## ArrayList (listas)

```
import java.util.ArrayList;
```

Algunos metodos:

- add
- contains
- listIterator -> devuelve iterador
- remove
- size
- sublist
- toArray
- trimToSize
- clear
- isEmpty

## Comparativa estructuras de datos

En ArrayList es barato add/remove al final y get/set, ya que es indexado.

En LinkedList es barato add/remove al final o al frente.

## Iterar

```java

// empezar iterador desde indice especifado

ListIterator x = list.listIterator(1);

Iterator<String> crunchifyIterator = crunchifyList.iterator();
		while (crunchifyIterator.hasNext()) {
			System.out.println(crunchifyIterator.next());

// con enhanced for

for (E element : list) {
    . . .
}

// en java 8 es posible lo siguiente

crunchifyList.forEach((temp) -> {
			System.out.println(temp);
		});
		}
```

Algunos metods: hasNext, next, nextIndex (devuelve int), remove

## Stacks

## Queue

```java

```

## Sets

## Diccionarios

### HashMap<K,V> (no ordenado)

- size
- get(key)
- put(k,v)
- remove(k)
- containsValue(v)
- keyset

### TreeMap<K,V> (ordenado)

## Clases

Son blueprints desde las cuelas se crean objetos.

- toString

*Clases y metodos abstractos*: clase abstract puede incluir o no metodo abstractos, no puede ser instanciada. Un metodo abstracto esta declarado sin implementacion.

```java
abstract void moveTo(double deltaX, double deltaY);
```

*Clase abstracta vs. interfaces*: son similares porque ambas no se puede instanciar y pueden contener un mix de metodos declarados con y sin implementacion. Pero en una clase abstracta se pueden declarar campos que no son static o final y definir visibilidad de los metodos.

Conviene usar clase abstracta si quiero compartir codigo entre clases relacionadas, que heredan de la clase abstracta, usar modificadores de visibilidad o campos no static ni finales.

Conviene usar interfaces si creo que clases no relacionadas pueden llegar a implementarla, quieor especificar el comportamiento de un tipo de dato en particular, quiero aprovechar herencia multiple.

### Constructor

```java
public Fraction(Integer num, Integer den) {
    this.num = num;
    this.den = den;

 // This is the basic constructor: initialize the radius
public Circle(double r) { this.r = r; }
// This constructor uses this() to invoke the constructor above public Circle() { this(1.0); }
}
```

### Herencia

```java
public class Fraction extends Number
```

*super.atributo/metodo* para llamar a la clase padre

### Jerarquia

```java
List list = new ArrayList();  
```

Padre padre = new Hija();

Conviene para migrar de forma sencilla.

### Nested classes

Clases dentro de otras. Pueden ser o no static. Sirve para agrupar logica, incremente encapsulacion y generar codigo legible y mantenible.

### Clase anonima

```java
HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };
```

## Interfaces

Por ejemplo, para hacer clase comparable y luego definir metodos:

```java
public class Fraction extends Number implements Comparable<Fraction> {
    ...
}

interface Centered {
void setCenter(double x, double y);
```

Todos sus metodos son abstractos aunque no hay que aclarlo. Todos sus metodos son publicos y es convencion no escribirlo. No define variables. Desde Java 8, pueden contener metodos static.

## Annotations

No modifican codigo, dan informacion al compilador y herramientas en tiempo de compilacion  o ejecucion.

@Override, @SuppressWarnings

## Generics

Hace posible detectar mas bugs en tiempo de compilacion.

Java generics enable programmers to specify, with a single method or class declaration, functionality that can be applied to multiple different data types. Generics also provide compile-time type safety that allows programmers to catch invalid types at compile time.



```java
public <E> void printArray( E[] inputArray ) {
    // Display array elements              
    for ( E element : inputArray ) {        
        System.out.printf( "%s ", element );
    }
    System.out.println();
}
```

## Expresiones regulares

java.util.regex.*

@@

## Enum

Constantes predefinidas

```java
public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY 
}

public class EnumTest {
    Day day;
    
    public EnumTest(Day day) {
        this.day = day;
    }
    
    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
                    
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
                         
            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;
                        
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }
```

## Input/Output

### Leer de consola

```java
InputStreamReader cin = new InputStreamReader(System.in);
```

Scanner is used for parsing tokens from the contents of the stream while BufferedReader just reads the stream and does not do any special parsing.

In fact you can pass a BufferedReader to a scanner as the source of characters to parse.

### java.io.file

- Path: maneja paths
- Files: copiar, mover, borrar, modificar atributos de archivos
- FileSystem

## Concurrency

Ejecutar multiples procesos al mismo tiempo.

Proceso -> contiene varios threads

## Fechas

java.time

```java
LocalDate today = LocalDate.now();
LocalDate payday = today.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
```

## TODO

- XML
















