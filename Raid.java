import java.util.ArrayList;

public class Raid extends simuladorBatallas {
    protected int turno = 0;

    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

    /**
     * @return int
     */
    public int nuevoTurno() {
        turno++;

        if (turno + 1 > jugadores.size()) {
            turno = 0;
        }
        return turno;
    }

    public void ataqueEnemigo() {
        for (int i = 0; i < enemigos.size(); i++) {
            enemigos.get(i).atacar(jugadores.get(turno));
        }
    }

}
