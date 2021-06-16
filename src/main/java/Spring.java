import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

public class Spring {

  public void armarSubarbol(Class clase) {/*Ahi hay que ver la interfaz del tipo class para ver como se le sacan los atributos
  y que cosas sacarle , en https://docs.oracle.com/javase/8/docs/api/allclasses-noframe.html estan las de todos los tipos de JAVA 8*/
    Annotation[] anotaciones = clase.getAnnotations();
    Class[] clases = clase.getClasses();

  }
}
