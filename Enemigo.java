/******************************************************************************
 * Enemigo.java
 * 
 * @author Sofía Salguero
 * @version 28/09/2021 
 * Clase Enemigo, se encarga de mantener los métodos necesarios para que el 
 * enemigo ataque, además de mantener sus propios valores 
 ******************************************************************************/

public class Enemigo extends Combatiente {

    /**
     * 
     * @param nombre
     * @param puntosVida
     * @param poderAtaque
     * @param turno
     * @param items
     */
    public Enemigo(String nombre, int puntosVida, int poderAtaque, int turno, int items) {
        super(nombre, puntosVida, poderAtaque, turno, items);
    }

    
    /** 
     * @param puntos
     */
    public void setPuntosVida(int puntos){
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
