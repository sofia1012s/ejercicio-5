
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
        //try {
            Random random = new Random();
            Vista view = new Vista();
            simuladorBatallas simulador = new simuladorBatallas();
            Raid simuladorRaid = new Raid();
            int opcionInicio = 0;
            int cantidadJugadores;
            int cantidadEnemigos = 0;
            int tipoBatalla = 0;

            view.bienvenida();

            while (opcionInicio != 3) {
                opcionInicio = view.menuInicio();

                switch (opcionInicio) {
                    case 1: // Ingresar jugadores
                        cantidadJugadores = view.cantidadJugadores(); // pregunta cuantos jugadores desean jugar

                        // ingresar datos de cada jugador
                        for (int i = 0; i < cantidadJugadores && i < 4; i++) {
                            view.Jugador(i);
                            String nombre = view.nombre();
                            int tipo = view.tipoJugador();

                            if (tipo == 1) {
                                // Guerrero
                                Guerrero guerrero = new Guerrero(nombre, 500, 30, i, 1);
                                simulador.setJugadores(guerrero);
                                simuladorRaid.setJugadores(guerrero);

                            } else if (tipo == 2) {
                                // Explorador
                                Explorador explorador = new Explorador(nombre, 200, 10, i, 3);
                                simulador.setJugadores(explorador);
                                simuladorRaid.setJugadores(explorador);

                            } else if (tipo == 3) {
                                // Cazador
                                String nombreMascota = view.nombreMascota();
                                Cazador cazador = new Cazador(nombre, 100, 5, i, 2, nombreMascota);
                                int puntosVida = (int) (Math.random() * (100 - 50) + 50);
                                
                                int poderAtaque = (int) (Math.random() * (100 - 50) + 50); // Numero aleatorio entre 100 y 50

                                int item = (int) (Math.random() * (3 - 1) + 1); // Numero aleatorio entre 1 y 3

                                Mascota mascota = new Mascota(nombreMascota, puntosVida, poderAtaque, i, item, nombre);
                                view.datosMascota(nombreMascota, puntosVida, poderAtaque, item);
                                simulador.setJugadores(cazador);
                                simuladorRaid.setJugadores(cazador);
                                simulador.setMascotas(mascota);
                                simuladorRaid.setMascotas(mascota);

                            } else {
                                view.opcionInvalida();
                            }
                        }

                        view.Jugadores(simulador.getJugadores());
                        break;

                    case 2:// Comenzar nueva batalla
                        tipoBatalla = view.tipoBatalla();

                        if (tipoBatalla == 1) { // Batalla normal

                            cantidadEnemigos = view.cantidadEnemigos();

                            for (int i = 0; i < cantidadEnemigos; i++) {

                                int tipo = random.nextInt((2 - 1) + 1) + 1;

                                if (tipo == 1) {

                                    String[] nombres = { "Anzati", "Ewok", "Gand", "Dug", "Ortolan" };
                                    Alienigena alienigena = new Alienigena(nombres[i], 500, 40, i, 3);
                                    simulador.setEnemigos(alienigena);
                                    view.Alien(nombres[i]);

                                } else if (tipo == 2) {

                                    String[] nombres = { "Elly Kedward", "Alice Kyteler", "Joan Wytte",
                                            "Madame Blavatsky", "Cordelia Foxx" };
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
                                    break;
                                default:
                                    break;
                            }

                            view.chart(simulador.getTurno(), simulador.getJugadores(), simulador.getEnemigos());

                            view.turnoEnemigos(simulador.getTurno(), simulador.getJugadores(), simulador.getEnemigos());
                            simulador.ataqueEnemigo();
                            if (simulador.getJugadores().get(simulador.getTurno()).getTipo() == 3) {
                                view.ataqueMascota();
                            }
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
                                            break;
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
                        }

                        else if (tipoBatalla == 2) { // Batalla tipo Raid

                            //cantidadEnemigos = view.cantidadEnemigosRaid();

                            raidBoss Diosa = new raidBoss(
                                    "Atenea, Diosa de la sabiduría, la estrategia, la fuerza, el coraje y la valentía, la inspiración, la ley y la justicia.",
                                    1000, 100, 0, 10);

                            //for (int i = 1; i < cantidadEnemigos+1; i++) {
                                simuladorRaid.setEnemigos(Diosa);
                                view.raidBoss();

                                int tipo = (int) (Math.random() * (2 - 1) + 1);

                                if (tipo == 1) {

                                    String[] nombres = { "Anzati", "Ewok", "Gand", "Dug", "Ortolan" };
                                    Alienigena alienigena = new Alienigena(nombres[i], 500, 40, i, 3);
                                    simuladorRaid.setEnemigos(alienigena);
                                    view.Alien(nombres[i]);

                                } else if (tipo == 2) {

                                    String[] nombres = { "Elly Kedward", "Alice Kyteler", "Joan Wytte",
                                            "Madame Blavatsky", "Cordelia Foxx" };
                                    Bruja bruja = new Bruja(nombres[i], 700, 50, i, 5);
                                    simuladorRaid.setEnemigos(bruja);
                                    view.bruja(nombres[i]);

                                } else {
                                    view.opcionInvalida();
                                }
                            //}

                            view.inicioBatalla();

                            view.chart(simuladorRaid.getTurno(), simuladorRaid.getJugadores(),
                                    simuladorRaid.getEnemigos());
                            view.turnoJugador(simuladorRaid.getTurno(), simuladorRaid.getJugadores(),
                                    simuladorRaid.getEnemigos());
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
                                    break;
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
                                            break;
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

                        } else {
                            view.opcionInvalida();
                        }
                        break;
                    case 3:
                        break;
                }
            }
        /*} catch (Exception e) {
            System.out.println("Ha ocurrido un error");
        }*/
    }
}
