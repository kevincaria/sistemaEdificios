package entidad;
// Crear una superclase llamada Edificio con los siguientes atributos: ancho, alto y
// largo. 

public abstract class Edificio {

    protected double ancho;
    protected double alto;
    protected double largo;
    
    public Edificio() {
    }

    public Edificio(double ancho, double alto, double largo) {
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    @Override
    public String toString() {
        return "Edificio [alto=" + alto + ", ancho=" + ancho + ", largo=" + largo + "]";
    }

 //   La clase edificio tendrá como métodos:
// • Método calcularSuperficie(): calcula la superficie del edificio.

    public abstract double calcularSuperficie(Edificio edificio);

// • Método calcularVolumen(): calcula el volumen del edifico.
// Estos métodos serán abstractos y los implementarán las siguientes clases.

    public abstract double calcularVolumen(Edificio edificio);
    

}
