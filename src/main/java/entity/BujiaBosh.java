package entity;

public class BujiaBosh implements Bujia{

    @Override
    public void generarChispa() {
        System.out.println("generando chispa alemana......");
    }
    public BujiaBosh(){
        generarChispa();
    }
}
