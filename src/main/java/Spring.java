import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Spring {
  public List<Class[]> tipos;

  public void armarSubarbol(Class clase) {/*Ahi hay que ver la interfaz del tipo class para ver como se le sacan los atributos
  y que cosas sacarle , en https://docs.oracle.com/javase/8/docs/api/allclasses-noframe.html estan las de todos los tipos de JAVA 8*/
    Class[] clases = clase.getClasses();
    if (clases.length == 0) {
      return;
    }
    ServiceLocator.getInstance().addNode(new Node(clase.getAnnotations(), clases));
    this.tipos.add(clases);
    Arrays.stream(clases).collect(Collectors.toList()).forEach(c -> this.armarSubarbol(c));
  }
}
