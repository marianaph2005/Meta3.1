import eventos.*;

public class SistemaDeSonido implements Subscriber {
    public SistemaDeSonido(EventBus bus) {
        bus.suscribir(BandaTocandoEvent.class, this);
    }

    @Override
    public void onEvent(Object event) {
        if (event instanceof BandaTocandoEvent) {
            BandaTocandoEvent e = (BandaTocandoEvent) event;
            System.out.println("Ajustando ecualizador para: [" + e.nombreCancion + "]");
        }
    }
}