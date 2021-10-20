/******************************************************************************
 * Jugador.java
 * 
 * @author Sofía Salguero
 * @version 28/09/2021 Clase Jugador, se encarga de mantener los métodos y
 *          propiedades de los jugadores, para luego utilizarlos en sus subtipos
 ******************************************************************************/

public abstract class Jugador extends Combatiente {
    /**
     * 
     * @param nombre
     * @param puntosVida
     * @param poderAtaque
     * @param turno
     * @param items
     */

    public Jugador(String nombre, int puntosVida, int poderAtaque, int turno, int items, int tipoJugador) {
        super(nombre, puntosVida, poderAtaque, turno, items);
        //Tipos de Jugadores:
        // 1. Explorador
        // 2. Guerrero
        // 3. Cazador
    }

    /**
     * @param op
     * @param enemigo
     */
    public abstract void items(int op, Enemigo enemigo);

    /**
     * @param puntos
     */
    public abstract void setPuntosVida(int puntos);

    /**
     * @param enemigo
     */
    public abstract void atacar(Enemigo enemigo);

    /**
     * @return int
     */
    public abstract int getItems();

    /**
     * 
     * @return int
     */
    public abstract int getTipo();


}
