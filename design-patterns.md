# Design patterns

Basado en [este tutorial](http://www.avajava.com/tutorials/categories/design-patterns) y el libro Head First Design Patterns.

## Creationals patterns

### Singleton

Es una clase que se instancia solo una vez. Se guarda como atributo static una instancia de la clase, inicialmente como null, se provee un constructor privado para que no pueda ser instanciada desde afuera, un metodo static getInstance que devuelve la instancia, creandola en caso de que sea null.

Las clases Singleton son utiles para concentrar el acceso a recursos en una sola clase, por ejemplo para acceso a una base de datos, caches, logging.

El modificador _synchronized_ nos asegura que dos threads no intentaran ejecutar getInstance() al mismo tiempo. Usarlo solo cuando sea necesario, porque reduce el rendimiento en un factor de 100. Una alternativa es crear el Singleton y eliminar el _if null_. Ese es codigo thread-safe.

```java
public class SingletonExample {

	private static SingletonExample singletonExample = null;

	private SingletonExample() {
	}

	public static synchronized SingletonExample getInstance() {
		if (singletonExample == null) {
			singletonExample = new SingletonExample();
		}
		return singletonExample;
	}

	public void sayHello() {
		System.out.println("Hello");
	}
}

public class Demo {

	public static void main(String[] args) {
		SingletonExample singletonExample = SingletonExample.getInstance();

		singletonExample.sayHello();
	}
```

### Factory

Devuelve un objeto cuando le pasas datos. Se puede complejizar haciendo que haya dos clases hijas a la abstract SimplePizzaFactory, NYPizzaFactory y BAPizzaFactory, por ejemplo, que cada una implemente su propio metodo crear pizza (otros metodos pueden ser iguales).

Pizza es clase abstracta o interfaz.


```java
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals(“cheese”)) {
            pizza = new CheesePizza();
        }
        }
        else if (type.equals(“pepperoni”)) {
            pizza = new PepperoniPizza();
        }
        }
        else if (type.equals(“clam”)) {
            pizza = new ClamPizza();
        }
        else if (type.equals(“veggie”)) {
            pizza = new VeggiePizza();
        }
         return pizza;
 ```
 
### Abstract Factory

Factory de factories. Por ejemplo:

```java
public class AbstractFactory {

	public SpeciesFactory getSpeciesFactory(String type) {
		if ("mammal".equals(type)) {
			return new MammalFactory();
		} else {
			return new ReptileFactory();
		}
	}

}

public abstract class SpeciesFactory {
	public abstract Animal getAnimal(String type);
}

public class MammalFactory extends SpeciesFactory {

	@Override
	public Animal getAnimal(String type) {
		if ("dog".equals(type)) {
			return new Dog();
		} else {
			return new Cat();
		}
	}

}
```

### Builder

Sirve para crear objetos complejos. El mismo proceso puede ser usado para crear distintos objetos. Tiene cuatro partes principales, Builder, Concrete Builders, Director y Producto.

- Builder: interfaz o clase abstracta que setea los metodos involucrados en crear un Producto.
- Concrete Builder: implementan los Builder.
- Director: es responsable de crear un Product a traves de Builder.
- Product: es la clase que se usara para crear objetos

```java
public class Meal { // Product

	private String drink;
	private String mainCourse;
	private String side;
	
	// getters y setters
	
public interface MealBuilder {
	public void buildDrink();

	public void buildMainCourse();

	public void buildSide();

	public Meal getMeal();
}

public class ItalianMealBuilder implements MealBuilder { // un posible ConcreteBuilder

	private Meal meal;

	public ItalianMealBuilder() {
		meal = new Meal();
	}

	@Override
	public void buildDrink() {
		meal.setDrink("red wine");
	}
	
	// etc
	
public class MealDirector {

	private MealBuilder mealBuilder = null;

	public MealDirector(MealBuilder mealBuilder) {
		this.mealBuilder = mealBuilder;
	}

	public void constructMeal() {
		mealBuilder.buildDrink();
		mealBuilder.buildMainCourse();
		mealBuilder.buildSide();
	}

	public Meal getMeal() {
		return mealBuilder.getMeal();
	}

}
```
### Prototype

Crea clones de objetos. Ahorra subclasas para crear objetos vs. Abstract Factory. 

```java
public interface Prototype {

	public Prototype doClone();

}

public class Person implements Prototype {

	String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public Prototype doClone() {
		return new Person(name);
	}

	public String toString() {
		return "This person is named " + name;
	}
}
```

## Structural Patterns

### Adapter

La clase Adapter traduce requests de otra clase (la _adaptada_). Modifica la interfaz de una clase para que pueda trabajar con otra.

### Composite

In the composite pattern, a tree structure exists where identical operations can be performed on leaves and nodes. A node in a tree is a class that can have children. A node class is a 'composite' class. A leaf in a tree is a 'primitive' class that does not have children. The children of a composite can be leaves or other composites.
 
La clase composite tiene metodos add, remove.

```java
class CompositeGraphic implements Graphic {

    //Collection of child graphics.
    private List<Graphic> childGraphics = new ArrayList<Graphic>();

    //Prints the graphic.
    public void print() {
        for (Graphic graphic : childGraphics) {
            graphic.print();
        }
    }

    //Adds the graphic to the composition.
    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }

    //Removes the graphic from the composition.
    public void remove(Graphic graphic) {
        childGraphics.remove(graphic);
    }
}
```

### Proxy

The proxy pattern is a structural design pattern. In the proxy pattern, a proxy class is used to control access to another class. The reasons for this control can vary. As one example, a proxy may avoid instantiation of an object until the object is needed. This can be useful if the object requires a lot of time or resources to create. Another reason to use a proxy is to control access rights to an object. A client request may require certain credentials in order to access the object.

### Decorator

The decorator pattern is a structural design pattern. Whereas inheritance adds functionality to classes, the decorator pattern adds functionality to objects by wrapping objects in other objects. Each time additional functionality is required, the object is wrapped in another object. JavaSW I/O streams are a well-known example of the decorator pattern.

Permite agregar funcionalidades a un objeto en runtime.

```java
public class LivingAnimal implements Animal {

	@Override
	public void describe() {
		System.out.println("\nI am an animal.");
	}
	
// clase abstract decorator

public abstract class AnimalDecorator implements Animal {

	Animal animal;

	public AnimalDecorator(Animal animal) {
		this.animal = animal;
	}

}

// decorator

public class LegDecorator extends AnimalDecorator {

	public LegDecorator(Animal animal) {
		super(animal);
	}

	@Override
	public void describe() {
		animal.describe();
		System.out.println("I have legs.");
		dance();
	}

	public void dance() {
		System.out.println("I can dance.");
	}

}

}
```

## Behavioral patterns

### Observer

The observer pattern is a behavioral object design pattern. In the observer pattern, an object called the subject maintains a collection of objects called observers. When the subject changes, it notifies the observers. Observers can be added or removed from the collection of observers in the subject. The changes in state of the subject can be passed to the observers so that the observers can change their own state to reflect this change.

### Chain of responsability

Use Chain of Responsibility when

- more than one object may handle a request, and the handler isn't known a priori. The handler should be ascertained automatically
- you want to issue a request to one of several objects without specifying the receiver explicitly
- the set of objects that can handle a request should be specified dynamically

### Strategy

Interfaz Strategy y clases ConcreteStrategy que implementan el algoritmo. Util cuando hay distintos algoritmos o se desea encapsular la informacion.

```java
public interface Strategy {

	boolean checkTemperature(int temperatureInF);

}

public class HikeStrategy implements Strategy {

	@Override
	public boolean checkTemperature(int temperatureInF) {
		if ((temperatureInF >= 50) && (temperatureInF <= 90)) {
			return true;
		} else {
			return false;
		}
	}

}
```

### Iterator

Implementacion de la interfaz Iterator provista por Java para adaptarla a una clase.

```java
public class Menu {

	List<Item> menuItems;

	public Menu() {
		menuItems = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		menuItems.add(item);
	}

	public Iterator<Item> iterator() {
		return new MenuIterator();
	}

	class MenuIterator implements Iterator<Item> {
		int currentIndex = 0;

		@Override
		public boolean hasNext() {
			if (currentIndex >= menuItems.size()) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public Item next() {
			return menuItems.get(currentIndex++);
		}

		@Override
		public void remove() {
			menuItems.remove(--currentIndex);
		}

	}

}
```

## Memento

The memento pattern is a behavioral design pattern. The memento pattern is used to store an object's state so that this state can be restored at a later point. The saved state data in the memento object is not accessible outside of the object to be saved and restored. This protects the integrity of the saved state data.

```java
public class DietInfo {

	String personName;
	int dayNumber;
	int weight;

	public Memento save() {
		return new Memento(personName, dayNumber, weight);
	}

	public void restore(Object objMemento) {
		Memento memento = (Memento) objMemento;
		personName = memento.mementoPersonName;
		dayNumber = memento.mementoDayNumber;
		weight = memento.mementoWeight;
	}

	// memento - object that stores the saved state of the originator
	private class Memento {
		String mementoPersonName;
		int mementoDayNumber;
		int mementoWeight;

		public Memento(String personName, int dayNumber, int weight) {
			mementoPersonName = personName;
			mementoDayNumber = dayNumber;
			mementoWeight = weight;
		}
	}
}
```





