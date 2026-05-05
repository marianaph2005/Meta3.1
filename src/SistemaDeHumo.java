import eventos.*;

public class SistemaDeHumo implements Subscriber {
    public SistemaDeHumo(EventBus bus) {
        bus.suscribir(BandaTocandoEvent.class, this);
    }

    @Override
    public void onEvent(Object event) {
        if (event instanceof BandaTocandoEvent) {
            BandaTocandoEvent e = (BandaTocandoEvent) event;
            if (e.nombreCancion.equalsIgnoreCase("Through the Fire and Flames")) {
                System.out.println("[SISTEMA DE HUMO] Canción épica detectada. Activando efectos de humo en el escenario.");
            }
        }
    }
}