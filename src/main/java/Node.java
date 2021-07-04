import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Node { /*Es como un registro de que tiene una cierta clase*/
  public List<Class> dependencias = new ArrayList<>();
  public Annotation[] anotaciones;
  public Class[] clases;

  public Node(Annotation[] anotaciones, Class[] clases) {
    this.anotaciones = anotaciones;
    this.clases = clases;

  }

  private void setDependencias() {
    Arrays.stream(this.clases).collect(Collectors.toList()).forEach(c -> this.dependencias.add(c));
  }
}
