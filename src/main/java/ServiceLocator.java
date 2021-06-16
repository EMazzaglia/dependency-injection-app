import java.util.List;

public class ServiceLocator {/*Es como un repositrorio de depdendencias , las conoce a todas y debe darlas cuando se las pidan*/
  /*Le pongo un singleton*/
  private final static ServiceLocator instance = new ServiceLocator();
 public List<Node> nodos;

  private ServiceLocator() {
  }

  public static ServiceLocator getInstance() {return instance;}

  public void addNode(Node node){
    this.nodos.add(node);
  }

}
