import eventos.*;

public class PanelLED implements Subscriber {
    public PanelLED(EventBus bus) {
        bus.suscribir(BebidaServidaEvent.class, this);
        bus.suscribir(ComidaPreparadaEvent.class, this);
    }

    @Override
    public void onEvent(Object event) {
        if (event instanceof BebidaServidaEvent) {
            BebidaServidaEvent e = (BebidaServidaEvent) event;
            System.out.println("[PANEL LED] ¡Nueva " + e.bebida + " servida en la " + e.mesaId + "!");
        } else if (event instanceof ComidaPreparadaEvent) {
            ComidaPreparadaEvent e = (ComidaPreparadaEvent) event;
            System.out.println("[PANEL LED] ¡" + e.plato + " lista para el pedido " + e.pedidoId + "!");
        }
    }
}