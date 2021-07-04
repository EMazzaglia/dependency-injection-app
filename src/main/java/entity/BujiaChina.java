package entity;

public class BujiaChina implements Bujia{
    @Override
    public void generarChispa() {
        System.out.println("La chispa china...");
    }
    public BujiaChina(){
        generarChispa();
    }
}
