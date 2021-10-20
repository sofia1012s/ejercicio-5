/******************************************************************************
 * raidBoss.java
 * 
 * @author Sofía Salguero
 * @version 19/10/2021 Clase raidBoss, se encarga de tener los métodos
 *          necesarios para realizar un pelea de tipo Raid
 ******************************************************************************/

public class raidBoss extends Enemigo {

    /**
     * 
     * @param nombre
     * @param puntosVida
     * @param poderAtaque
     * @param turno
     * @param items
     */
    public raidBoss(String nombre, int puntosVida, int poderAtaque, int turno, int items) {
        super(nombre, puntosVida, poderAtaque, turno, items);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param puntos
     */
    public void setPuntosVida(int puntos) {
        puntosVida = puntos;
    }

    /**
     * @param jugador
     */
    public void atacar(Jugador jugador) {
        int vidaJugador = jugador.getPuntosVida();
        vidaJugador = vidaJugador - poderAtaque;
        jugador.setPuntosVida(vidaJugador);
    }
}
