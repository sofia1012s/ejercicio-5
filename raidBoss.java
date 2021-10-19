public class raidBoss extends Enemigo {

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
