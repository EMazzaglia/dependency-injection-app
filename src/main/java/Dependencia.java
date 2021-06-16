public class Dependencia {
  public Class tipo;
  public Class tipoDuenio; /*El tipo del obejto que tiene a la dependencia*/

  public Dependencia(Class tipo){
    this.tipo = tipo;
  }
  public Class getTipo(){
    return  this.tipo;
  }
}
