/******************************************************************************
 * simuladorBatallas.java
 * 
 * @author Sofía Salguero
 * @version 28/09/2021 
 * Clase simuladorBatallas, se encarga de mantener los métodos necesarios para 
 * que los jugadores interactuen con los enemigos y se de la batalla
 ******************************************************************************/

import java.util.ArrayList;

public class simuladorBatallas {
    private int turno = 0;

    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();

    
    /** 
     * @param jugador
     */
    public void setJugadores(Jugador jugador) {
        jugadores.add(jugador);
    }

    
    /** 
     * @param enemigo
     */
    public void setEnemigos(Enemigo enemigo) {
        enemigos.add(enemigo);
    }

    
    /** 
     * @return int
     */
    public int nuevoTurno() {
        turno++;

        if(turno + 1 > jugadores.size() || turno + 1 > enemigos.size()){
            turno = 0;
        }
        return turno;
    }

    
    /** 
     * @return ArrayList<Jugador>
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    
    /** 
     * @return ArrayList<Enemigo>
     */
    public ArrayList<Enemigo> getEnemigos() {
        return enemigos;
    }

    
    /** 
     * @return int
     */
    public int getTurno() {
        return turno;
    }
    
    public void ataqueJugador(){
        jugadores.get(turno).atacar(enemigos.get(turno));
    }

    public void ataqueEnemigo(){
        enemigos.get(turno).atacar(jugadores.get(turno));
    }

}
