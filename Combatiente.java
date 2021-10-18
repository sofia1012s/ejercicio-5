/******************************************************************************
 * Combatiente.java
 * 
 * @author Sofía Salguero
 * @version 28/09/2021 Clase Combatiente, se encarga de tener los métodos
 *          generales para los combatientes, para obtener sus propios valores y
 *          utilizarlos por aparte.
 ******************************************************************************/
public class Combatiente {
    protected String nombre;
    protected int puntosVida;
    protected int poderAtaque;
    protected int turno;
    protected boolean tomarTurno;
    protected int items;

    /**
     * 
     * @param nombre
     * @param puntosVida
     * @param poderAtaque
     * @param turno
     * @param items
     */
    public Combatiente(String nombre, int puntosVida, int poderAtaque, int turno, int items) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.poderAtaque = poderAtaque;
        this.turno = turno;
        this.items = items;
    }

    /**
     * @return boolean
     */
    public boolean tomarTurno() {
        tomarTurno = true;
        return tomarTurno;
    }

    /**
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return int
     */
    public int getPuntosVida() {
        return puntosVida;
    }

    /**
     * @return int
     */
    public int getPoderAtaque() {
        return poderAtaque;
    }

    /**
     * @return int
     */
    public int getTurno() {
        return turno;
    }

}
