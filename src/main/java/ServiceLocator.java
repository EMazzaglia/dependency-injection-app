import java.util.List;

public class ServiceLocator {/*Es como un repositrorio de depdendencias , las conoce a todas y debe darlas cuando se las pidan*/
  /*Le pongo un singleton*/
  private ServiceLocator instance;
 public List<Dependencia> dependencias;

  private ServiceLocator() {
  }

  public ServiceLocator getInstance() {
    if (this.instance == null) {
      this.instance = new ServiceLocator();
      return this.instance;
    } else {
      return this.instance;
    }
  }

}
