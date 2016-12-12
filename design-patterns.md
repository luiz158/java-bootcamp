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





