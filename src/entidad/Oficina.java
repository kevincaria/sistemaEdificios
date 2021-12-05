package entidad;
// • Clase EdificioDeOficinas con sus atributos número de oficinas, cantidad de
// personas por oficina y numero de pisos. Esta clase implementará los dos
// métodos abstractos y los atributos del padre.

import java.util.Scanner;

public final class Oficina extends Edificio{
    private int numeroOficinas;
    private int cantidadPersonas;
    private int numeroPisos;

    public Oficina() {
    }

    public Oficina(double ancho, double alto, double largo, int numeroOficinas, int cantidadPersonas, int numeroPisos) {
        super(ancho, alto, largo);
        this.numeroOficinas = numeroOficinas;
        this.cantidadPersonas = cantidadPersonas;
        this.numeroPisos = numeroPisos;
    }

    public int getNumeroOficinas() {
        return numeroOficinas;
    }

    public void setNumeroOficinas(int numeroOficinas) {
        this.numeroOficinas = numeroOficinas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(int numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    @Override
    public String toString() {
        return super.toString()+", cantidadPersonas=" + cantidadPersonas + ", numeroOficinas=" + numeroOficinas + ", numeroPisos="
                + numeroPisos + "]";
    }

    @Override
    public double calcularSuperficie(Edificio edificio) {
        double superficie = edificio.getLargo() * edificio.getAncho();
        return superficie;
    }

    @Override
    public double calcularVolumen(Edificio edificio) {
        double volumen = edificio.getAlto() * edificio.getAncho() * edificio.getLargo();
        return volumen;
    }

// De esta clase nos interesa saber cuantas personas pueden trabajar en todo el
// edificio, el usuario dirá cuantas personas entran en cada oficina, cuantas
// oficinas y el numero de piso (suponiendo que en cada piso hay una oficina).
    public Oficina crearOficina(){
        Scanner read = new Scanner(System.in);
        System.out.println("Ingrese el alto: ");
        double alto = read.nextDouble();
        System.out.println("Ingrese el ancho: ");
        double ancho = read.nextDouble();
        System.out.println("Ingrese el largo: ");
        double largo = read.nextDouble();
        System.out.println("Ingrese el numero de oficinas: ");
        int numeroOficinas = read.nextInt();
        System.out.println("Ingrese la cantidad de personas por oficina : ");
        int cantidadPersonas = read.nextInt();
        System.out.println("Ingrese el numero de pisos del edificio: ");
        int numeroPisos = read.nextInt();
        System.out.println("Oficina ingresada ! ");
        System.out.println("");
        return new Oficina(ancho, alto, largo, numeroOficinas, cantidadPersonas, numeroPisos);
    }
// Crear el método cantPersonas(), que muestre cuantas personas entrarían en
// un piso y cuantas en todo el edificio.
    public int cantidadPersonas(Oficina oficina) {
        int cantidadPersonas = oficina.getCantidadPersonas();
        int numeroPisos = oficina.getNumeroPisos();
        int cantidadPersonasTotal = cantidadPersonas*numeroPisos;
        return cantidadPersonasTotal;
    }
    
}
