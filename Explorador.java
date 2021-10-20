/******************************************************************************
 * Explorador.java
 * 
 * @author Sofía Salguero
 * @version 28/09/2021 Clase Explorador, se encarga de mantener las propiedades
 *          de un jugador de tipo explorador
 ******************************************************************************/

 public class Explorador extends Jugador {
     /**
      * 
      * @param nombre
      * @param puntosVida
      * @param poderAtaque
      * @param turno
      * @param items
      */
    public Explorador(String nombre, int puntosVida, int poderAtaque, int turno,int items) {
        super(nombre, puntosVida, poderAtaque, turno, items,1);
    }

        
    /** 
     * @param op
     * @param enemigo
     */
    public void items(int op, Enemigo enemigo) {
        switch (op) {
            case 1: // Restaurar 10 puntos de vida
                int puntos = puntosVida + 10;
                setPuntosVida(puntos);
                items = items - 1;
                break;
            case 2: // Atacar con el doble de daño
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
     * @param enemigo
     */
    public void atacar(Enemigo enemigo) {
        int vidaEnemigo = enemigo.getPuntosVida();
        vidaEnemigo = vidaEnemigo - poderAtaque;
        enemigo.setPuntosVida(vidaEnemigo);
    }

    
    /** 
     * @return int
     */
    public int getItems() {
        return items;
    }

    
    
    /** 
     * @return int
     */
    public int getTipo() {
        return 1;
    }
}
