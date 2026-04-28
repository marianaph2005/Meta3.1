package eventos;

public class BandaTocandoEvent {
    public final String nombreBanda;
    public final String nombreCancion;
    public final int duracionSegundos;

    public BandaTocandoEvent(String nombreBanda, String nombreCancion, int duracionSegundos) {
        this.nombreBanda = nombreBanda;
        this.nombreCancion = nombreCancion;
        this.duracionSegundos = duracionSegundos;
    }
}