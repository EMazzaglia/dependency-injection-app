public class Dependencia {
  public Class tipo;
  public Class tipoDuenio; /*El tipo del obejto que tiene a la dependencia*/
  public int nivel ; /*Es el nivel de anidamiento del atirbuto en la clase recibida.
  Si es de la misma es nivel 1.Si es un atirbuto de un objeto que es atirbuto de esta , es nivel 2.Si es uno de
  un objeto que es atributo de ese objeto es nivel 3 y asi sucesivamente.*/

  public Dependencia(Class tipo , int nivel){
    this.tipo = tipo;
    this.nivel = nivel;
  }
  public Class getTipo(){
    return  this.tipo;
  }
  public int getNivel(){
    return this.nivel;
  }
}
