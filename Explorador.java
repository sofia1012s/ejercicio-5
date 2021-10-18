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
        super(nombre, puntosVida, poderAtaque, turno, items);
    }

    
    /** 
     * @return int
     */
    public int setPuntosVida() {
        this.puntosVida = 200;
        return puntosVida;
    }

    
    /** 
     * @return int
     */
    public int setPoderAtaque() {
        this.poderAtaque = 10;
        return poderAtaque;
    }

}
