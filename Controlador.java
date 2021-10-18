/******************************************************************************
 * Controlador.java
 * 
 * @author Sofía Salguero
 * @version 28/09/2021 
 * Clase controlador, se encarga de ser el main y realizar
 * las acciones necesarias para tener una interacción entre los modelos y la vista
 ******************************************************************************/
import java.util.Random;

public class Controlador {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Vista view = new Vista();
            simuladorBatallas simulador = new simuladorBatallas();
            int opcionInicio = 0;
            int cantidadJugadores;
            int cantidadEnemigos = 0;

            view.bienvenida();

            while (opcionInicio != 3) {
                opcionInicio = view.menuInicio();

                switch (opcionInicio) {
                    case 1: // Ingresar nuevos jugadores
                        cantidadJugadores = view.cantidadJugadores(); // pregunta cuantos jugadores desean jugar

                        // ingresar datos de cada jugador
                        for (int i = 0; i < cantidadJugadores; i++) {
                            view.Jugador(i);
                            String nombre = view.nombre();
                            int tipo = view.tipoJugador();

                            if (tipo == 1) {
                                // Guerrero
                                Guerrero guerrero = new Guerrero(nombre, 500, 30, i, 1);
                                simulador.setJugadores(guerrero);

                            } else if (tipo == 2) {
                                // Explorador
                                Explorador explorador = new Explorador(nombre, 200, 10, i, 3);
                                simulador.setJugadores(explorador);

                            } else {
                                view.opcionInvalida();
                            }
                        }

                        view.Jugadores(simulador.getJugadores());

                        break;

                    case 2:// Comenzar nueva batalla
                        cantidadEnemigos = view.cantidadEnemigos(); // pregunta cuantos jugadores desean jugar

                        for (int i = 0; i < cantidadEnemigos; i++) {
                            Random random = new Random();
                            int tipo = random.nextInt((2 - 1) + 1) + 1;

                            if (tipo == 1) {

                                String[] nombres = { "Anzati", "Ewok", "Gand", "Dug", "Ortolan" };
                                Alienigena alienigena = new Alienigena(nombres[i], 500, 40, i, 3);
                                simulador.setEnemigos(alienigena);
                                view.Alien(nombres[i]);

                            } else if (tipo == 2) {

                                String[] nombres = { "Elly Kedward", "Alice Kyteler", "Joan Wytte", "Madame Blavatsky",
                                        "Cordelia Foxx" };
                                Bruja bruja = new Bruja(nombres[i], 700, 50, i, 5);
                                simulador.setEnemigos(bruja);
                                view.bruja(nombres[i]);

                            } else {
                                view.opcionInvalida();
                            }
                        }

                        view.inicioBatalla();

                        view.chart(simulador.getTurno(), simulador.getJugadores(), simulador.getEnemigos());
                        view.turnoJugador(simulador.getTurno(), simulador.getJugadores(), simulador.getEnemigos());
                        int op3 = view.opcionesJugador();
                        switch (op3) {
                            case 1: // atacar al enemigo
                                simulador.ataqueJugador();
                                break;
                            case 2: // Usar un item
                                if (simulador.getJugadores().get(simulador.getTurno()).getItems() < 0) {
                                    int item = view.itemsJugador();

                                    simulador.getJugadores().get(simulador.getTurno()).items(item,
                                            simulador.getEnemigos().get(simulador.getTurno()));

                                } else {
                                    view.noItems();
                                }

                            default:
                                break;
                        }

                        view.chart(simulador.getTurno(), simulador.getJugadores(), simulador.getEnemigos());

                        view.turnoEnemigos(simulador.getTurno(), simulador.getJugadores(), simulador.getEnemigos());
                        simulador.ataqueEnemigo();
                        view.chart(simulador.getTurno(), simulador.getJugadores(), simulador.getEnemigos());

                        int op2 = 0;

                        while (op2 != 2) {
                            op2 = view.menuJuego();
                            if (op2 == 1) {
                                simulador.nuevoTurno();
                                view.chart(simulador.getTurno(), simulador.getJugadores(), simulador.getEnemigos());
                                view.turnoJugador(simulador.getTurno(), simulador.getJugadores(),
                                        simulador.getEnemigos());
                                int op4 = view.opcionesJugador();
                                switch (op4) {
                                    case 1: // atacar al enemigo
                                        simulador.ataqueJugador();
                                        break;
                                    case 2: // Usar un item
                                        int item = view.itemsJugador();

                                        simulador.getJugadores().get(simulador.getTurno()).items(item,
                                                simulador.getEnemigos().get(simulador.getTurno()));

                                    default:
                                        break;
                                }
                                view.chart(simulador.getTurno(), simulador.getJugadores(), simulador.getEnemigos());

                                view.turnoEnemigos(simulador.getTurno(), simulador.getJugadores(),
                                        simulador.getEnemigos());
                                simulador.ataqueEnemigo();
                                view.chart(simulador.getTurno(), simulador.getJugadores(), simulador.getEnemigos());
                            }
                        }
                        break;
                    case 3:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
        }
    }
}
