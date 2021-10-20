
/******************************************************************************
 * Acompañante.java
 * 
 * @author Sofía Salguero
 * @version 19/10/2021 
 * Clase abstracta Acompañamte, se encarga de tener los métodos necesarios
 * para las mascotas
 ******************************************************************************/

public abstract class Acompanante extends Combatiente{

    protected String lider; 

    /**
     * 
     * @param nombre
     * @param puntosVida
     * @param poderAtaque
     * @param turno
     * @param items
     * @param lider
     */
    public Acompanante(String nombre, int puntosVida, int poderAtaque, int turno, int items, String lider) {
        super(nombre, puntosVida, poderAtaque, turno, items);
        //TODO Auto-generated constructor stub
    }
    /**
     * 
     * @param enemigo
     * @param jugador
     */
    public abstract void items(Enemigo enemigo, Jugador jugador);


    
}
