package computadora.fuente;

public class Segotep implements Fuente {

    private String marca;
    private String voltaje;
    private String potencia;

    public Segotep(String marca, String voltaje, String potencia){
        this.marca = marca;
        this.voltaje = voltaje;
        this.potencia = potencia;
    }

    @Override
    public String voltaje() {
        return "110V/220V";
    }

    @Override
    public String marca() {
        return this.marca;
    }

    public String potencia(){
        return this.potencia;
    }
}
