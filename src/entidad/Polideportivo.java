package entidad;

import java.util.Scanner;

import enumeraciones.TipoInstalacion;

// • Clase Polideportivo con su nombre y tipo de instalación que puede ser
// Techado o Abierto, esta clase implementará los dos métodos abstractos y los
// atributos del padre.

public final class Polideportivo extends Edificio{
    private String nombre; 
    private TipoInstalacion tipoDeInstalacion;
    
    public Polideportivo() {
    }

    public Polideportivo(double ancho, double alto, double largo, String nombre, TipoInstalacion tipoDeInstalacion) {
        super(ancho, alto, largo);
        this.nombre = nombre;
        this.tipoDeInstalacion = tipoDeInstalacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoInstalacion getTipoDeInstalacion() {
        return tipoDeInstalacion;
    }

    public void setTipoDeInstalacion(TipoInstalacion tipoDeInstalacion) {
        this.tipoDeInstalacion = tipoDeInstalacion;
    }

    @Override
    public String toString() {
        return super.toString() + ", nombre=" + nombre + ", tipoDeInstalacion=" + tipoDeInstalacion + "]";
    }
// Crear una superclase llamada Edificio con los siguientes atributos: ancho, alto y
// largo. 
// • Clase Polideportivo con su nombre y tipo de instalación que puede ser
// Techado o Abierto
    public Polideportivo crearPolideportivo() {
        Scanner read = new Scanner(System.in);
        System.out.println("Ingrese el alto: ");
        double alto = read.nextDouble();
        System.out.println("Ingrese el ancho: ");
        double ancho = read.nextDouble();
        System.out.println("Ingrese el largo: ");
        double largo = read.nextDouble();
        System.out.println("Ingrese el nombre del polideportivo: ");
        String nombre = read.next();
        read.next();
        
        System.out.println("Ingrese el tipo de instalacion: ");
        System.out.println("1.Techado.");
        System.out.println("2.Abierto.");
        int tipo = read.nextInt();
        while (tipo!=1 && tipo!=2){
            System.out.println("Opcion incorrecta, ingrese el tipo de instalacion: ");
            System.out.println("1.Techado.");
            System.out.println("2.Abierto.");
            tipo = read.nextInt();
        }
        TipoInstalacion tipoDeInstalacion = TipoInstalacion.values()[tipo-1];
        System.out.println("Polideportivo ingresado!" );
        System.out.println("");
        return new Polideportivo(alto,ancho,largo,nombre,tipoDeInstalacion);
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
}
