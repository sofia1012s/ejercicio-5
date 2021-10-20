/******************************************************************************
 * Mascota.java
 * 
 * @author Sofía Salguero
 * @version 19/10/2021 
 * Clase Mascota, se encarga de tener los métodos necesarios para la mascota
 * del jugador de tipo cazador
 ******************************************************************************/

public class Mascota extends Acompanante {

    /**
     * 
     * @param nombre
     * @param puntosVida
     * @param poderAtaque
     * @param turno
     * @param items
     * @param lider
     */
    public Mascota(String nombre, int puntosVida, int poderAtaque, int turno, int items, String lider) {
        super(nombre, puntosVida, poderAtaque, turno, items, lider);
        // TODO Auto-generated constructor stub
    }

    
    /** 
     * @param enemigo
     * @param (items
     */
    public void items(Enemigo enemigo, Jugador jugador) { // Habilidades propias del acompañante (se escoge una
                                                          // al azar)
        switch (items) {
            case 1: // Restaurar 10 puntos de vida a su lider
                puntosVida = jugador.getPuntosVida();
                int puntos = puntosVida + 10;
                jugador.setPuntosVida(puntos);
                items = items - 1;
                break;
            case 2: // Atacar con el doble de daño al enemigo del lider
                int poderBonus = poderAtaque * 2;
                int vidaEnemigo = enemigo.getPuntosVida();
                vidaEnemigo = vidaEnemigo - poderBonus;
                enemigo.setPuntosVida(vidaEnemigo);
                items = items - 1;
                break;

            case 3: // Se ataca al enemigo con su mismo poder de ataque
                vidaEnemigo = enemigo.getPuntosVida();
                int ataqueEnemigo = enemigo.getPoderAtaque();
                vidaEnemigo = vidaEnemigo - ataqueEnemigo;
                enemigo.setPuntosVida(vidaEnemigo);
                items = items - 1;
                break;

            default:
                break;
        }
    }

    
    /** 
     * @param puntos
     */
    public void setPuntosVida(int puntos) {
        puntosVida = puntos;
    }

    
    /** 
     * @return int
     */
    public int getItems() {
        return items;
    }

    
    /** 
     * @param enemigo
     */
    public void atacar(Enemigo enemigo) {
        int vidaEnemigo = enemigo.getPuntosVida();
        vidaEnemigo = vidaEnemigo - poderAtaque;
        enemigo.setPuntosVida(vidaEnemigo);
    }
}
