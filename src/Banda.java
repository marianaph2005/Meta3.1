import eventos.*;

public class Banda {
    private final EventBus bus;

    public Banda(EventBus bus) {
        this.bus = bus;
    }

    public void tocarCancion(String nombreBanda, String cancion, int duracion) {
        bus.publicar(new BandaTocandoEvent(nombreBanda, cancion, duracion));
    }
}