
/******************************************************************************
 * Vista.java
 * 
 * @author Sofía Salguero
 * @version 28/09/2021 
 * Clase Vista que se encarga de ofrecer la interfaz al usuario para que pueda
 * interactuar con el programa
 ******************************************************************************/

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Vista {
    private Scanner scan = new Scanner(System.in);

    public void bienvenida() {
        System.out.println(
                "\n****************************************** Simulador de Batallas ******************************************");
        System.out.println("Bienvenid@ ! A continuacion encontrara distintas opciones para comenzar con la partida ");
    }

    /**
     * @return int
     */
    public int menuInicio() {
        int opcion = 0;
        String s = "\nQue desea hacer?\n" + "1. Ingresar nuevos Jugadores\n" + "2. Comenzar nueva batalla\n"
                + "3. Salir\n"
                + "\n**********************************************************************************************************";

        System.out.println(s);

        opcion = scan.nextInt();

        return opcion;
    }

    public void inicioBatalla() {
        System.out.println("**********************************************************");
        System.out.println("\nQue comience el juego!\n");
        System.out.println("**********************************************************");
    }

    /**
     * @param turno
     * @param jugadores
     * @param enemigos
     */
    public void turnoJugador(int turno, ArrayList<Jugador> jugadores, ArrayList<Enemigo> enemigos) {
        System.out.println("\nEs el turno " + turno);
        System.out.println(
                "\nEl jugador " + jugadores.get(turno).getNombre() + " luchara con " + enemigos.get(turno).getNombre());
    }

    /**
     * @param turno
     * @param jugadores
     * @param enemigos
     */
    public void turnoEnemigos(int turno, ArrayList<Jugador> jugadores, ArrayList<Enemigo> enemigos) {
        System.out.println("\nEs el turno " + turno);
        System.out.println(
                "\nEl enemigo " + enemigos.get(turno).getNombre() + " luchara con " + jugadores.get(turno).getNombre());
    }

    /**
     * @return int
     */
    public int cantidadJugadores() {
        int cantidadJugadores = 0;
        System.out.println("\nIngrese la cantidad de jugadores que participaran: \n");
        cantidadJugadores = scan.nextInt();

        return cantidadJugadores;
    }

    /**
     * @return int
     */
    public int cantidadEnemigos() {
        int min = 1;
        int max = 3;

        Random random = new Random();

        int cantidadEnemigos = random.nextInt(max + min) + min;
        System.out.println("\nEn esta partida, debe derrotar a " + cantidadEnemigos + " enemigos");

        return cantidadEnemigos;
    }

    /**
     * @return String
     */
    public String nombre() {
        System.out.println("\nIngrese el nombre del jugador: ");
        String nombre = scan.next();

        return nombre;
    }

    /**
     * @param num
     */
    public void Jugador(int num) {
        System.out.println("\nIngrese los datos del jugador " + num);
    }

    /**
     * @return int
     */
    public int tipoJugador() {
        String s = "\nQue tipo de jugador desea?\n" + "\n1) Guerrerx: \n" + "-Puntos de vida: 500\n"
                + "-Puntos de ataque: 30\n" + "-Items para usar: 1 \n" + "\n2) Exploradorx: \n"
                + "-Puntos de vida: 200\n" + "-Puntos de ataque: 10\n" + "-Items para usar: 3\n";
        System.out.println(s);

        int opcion = scan.nextInt();

        return opcion;
    }

    public void opcionInvalida() {
        System.out.println("Ha elegido una opcion invalida.");
    }

    /**
     * @param jugadores
     */
    public void Jugadores(ArrayList<Jugador> jugadores) {
        System.out.println("Estos son los jugadores que participaran en la batalla:");

        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println("\nJugador " + i + " - " + jugadores.get(i).getNombre());
        }
    }

    /**
     * @param nombre
     */
    public void Alien(String nombre) {
        String s = "\n" + nombre + "\nTipo: Alienigena" + "\n-Puntos Vida: 500" + "\n-Puntos ataque: 40";
        System.out.println(s);
    }

    /**
     * @param nombre
     */
    public void bruja(String nombre) {
        String s = "\n" + nombre + "\nTipo: Bruja" + "\n-Puntos Vida: 700" + "\n-Puntos ataque: 50";
        System.out.println(s);
    }

    /**
     * @param turno
     * @param jugadores
     * @param enemigos
     */
    public void chart(int turno, ArrayList<Jugador> jugadores, ArrayList<Enemigo> enemigos) {
        System.out.println("\n-------- Tablero -------");
        System.out.println("\n**Jugadores**");

        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println("\n" + jugadores.get(i).getNombre() + " :");
            System.out.println("-Puntos de vida: " + jugadores.get(i).getPuntosVida());
            System.out.println("-Items disponibles: " + jugadores.get(i).getItems());
        }
        System.out.println("\n**Enemigos**");

        for (int j = 0; j < enemigos.size(); j++) {
            System.out.println("\n" + enemigos.get(j).getNombre() + " :");
            System.out.println("-Puntos de vida: " + enemigos.get(j).getPuntosVida());
        }
        System.out.println("\n-----------------------");

    }

    /**
     * @return int
     */
    public int menuJuego() {
        int opcion = 0;
        String s = "\nQue desea hacer?\n" + "1. Pasar al siguiente turno\n" + "2. Regresar al menu principal\n";

        System.out.println(s);

        opcion = scan.nextInt();

        return opcion;
    }

    /**
     * @return int
     */
    public int opcionesJugador() {
        int opcion = 0;
        String s = "\nQue desea hacer?\n" + "1. Atacar\n" + "2. Usar Item\n";

        System.out.println(s);

        opcion = scan.nextInt();

        return opcion;
    }

    /**
     * @return int
     */
    public int itemsJugador() {
        int opcion = 0;
        String s = "\nCual item desea utilizar?\n" + "1. Restaurar 10 puntos de vida\n"
                + "2. Atacar con el doble de daño\n" + "3. Atacar al enemigo con su mismo poder de ataque";

        System.out.println(s);

        opcion = scan.nextInt();

        return opcion;
    }

    public void noItems() {
        System.out.println("--------Ya no posee items para utilizar.-------");
    }

}
