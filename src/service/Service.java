package service;

import java.util.ArrayList;
import java.util.Scanner;

import entidad.Edificio;
import entidad.Oficina;
import entidad.Polideportivo;
import enumeraciones.TipoInstalacion;

// Por ultimo, en el main vamos a crear un ArrayList de tipo Edificio. El ArrayList debe
// contener dos polideportivos y dos edificios de oficinas. Luego, recorrer este array
// y ejecutar los métodos calcularSuperficie y calcularVolumen en cada Edificio. Se
// deberá mostrar la superficie y el volumen de cada edificio.

// Además de esto, para la clase Polideportivo nos interesa saber cuantos
// polideportivos son techados y cuantos abiertos. Y para la clase EdificioDeOficinas
// deberemos llamar al método cantPersonas() y mostrar los resultados de cada
// edificio de oficinas.
public class Service {

    private ArrayList<Edificio> agregarPolideportivos(ArrayList<Edificio> edificios) {
        Polideportivo nuevo = new Polideportivo();
        for (int i = 0; i < 2; i++) {
            nuevo = nuevo.crearPolideportivo();
            edificios.add(nuevo);
        }
        return edificios;
    }

    private ArrayList<Edificio> agregarOficinas(ArrayList<Edificio> edificios) {
        Oficina nuevo = new Oficina();
        for (int i = 0; i < 2; i++) {
            nuevo = nuevo.crearOficina();
            edificios.add(nuevo);
        }
        return edificios;
    }

    private void mostrarDetallesOficinas(ArrayList<Edificio> edificios) {
        System.out.println("Las personas del edificio son: ");
             for (Edificio edificio : edificios) {
                if (edificio instanceof Oficina) {
                    Oficina oficina = (Oficina)edificio;
                    System.out.println("La cantidad de personas por piso son: "+oficina.getCantidadPersonas());
                    System.out.println("La cantidad de personas que entran en este edificio son: "+oficina.cantidadPersonas(oficina));
                } 
            }
    }

    private void mostrarDetallePolideportivos(ArrayList<Edificio> edificios) {
        int techados = 0;
        int abiertos = 0;
        for (Edificio edificio : edificios) {
            if(edificio instanceof Polideportivo){
                Polideportivo polideportivo = (Polideportivo)edificio;
                if(polideportivo.getTipoDeInstalacion().name().equalsIgnoreCase(TipoInstalacion.ABIERTO.name())){
                    abiertos++;
                } else if(polideportivo.getTipoDeInstalacion().name().equalsIgnoreCase(TipoInstalacion.TECHADO.name())){
                    techados++;
                }
            }
        }
        System.out.println("La cantidad de polideportivos techados son: " + techados);
        System.out.println("La cantidad de polideportivos abiertos son: " + abiertos);
    }

    public void menu() {
        Scanner read = new Scanner(System.in);
        ArrayList<Edificio> edificios = new ArrayList<Edificio>();
        int op;
        int op2 = 0;

        do {
            System.out.println("MENU");
            System.out.println("1.Crear 2 Polideportivos");
            System.out.println("2.Crear 2 Oficinas");
            System.out.println("3.Mostrar lista de edificios");
            System.out.println("4.Mostrar Superficie de edificios");
            System.out.println("5.Mostrar volumen de edificios");
            System.out.println("6.Mostrar detalles de oficias");
            System.out.println("7.Mostrar detalles de polideportivos");
            System.out.println("8.Salir");
            System.out.println("Ingrese una opcion: ");

            op = read.nextInt();
            while (op < 0 || op > 9) {
                System.out.println("Opcion incorrecta, elija la opcion 1 y 8");
                op = read.nextInt();
            }

            switch (op) {
                case 1:
                    edificios = agregarPolideportivos(edificios);
                    System.out.println("Polideportivos agregados!");
                    break;
                case 2:
                    edificios = agregarOficinas(edificios);
                    System.out.println("Oficinas agregadas!");
                    break;
                case 3:
                    System.out.println("Lista de edificios");
                    for (Edificio edificio : edificios) {
                        System.out.println(edificio.toString());
                    }
                    break;
                case 4:
                    System.out.println("Superficie de edificios");
                    for (Edificio edificio : edificios) {
                        System.out.println("La superficie del edificio es: " + edificio.calcularSuperficie(edificio)+"mts 2");
                    }
                    break;
                case 5:
                    System.out.println("Volumen de edificios");
                    for (Edificio edificio : edificios) {
                        System.out.println("El volumen del edificio es: "+edificio.calcularVolumen(edificio)+"mts 3");
                    }
                    break;
                case 6:
                    mostrarDetallesOficinas(edificios);
                    break;
                case 7:
                    mostrarDetallePolideportivos(edificios);
                    break;
                case 8:
                    System.out.println("Esta seguro que desea salir?");
                    System.out.println("1.Si");
                    System.out.println("2.No");
                    op2 = read.nextInt();
                    while (op2 != 1 && op2 != 2) {
                        System.out.println("Ingrese una opcion correcta");
                        op2 = read.nextInt();
                    }
            }
        } while (op2 != 1);
    }
}
