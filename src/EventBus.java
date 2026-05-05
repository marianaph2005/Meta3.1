import java.util.*;
import java.util.concurrent.*;

public class EventBus {
    // Mapa que relaciona un tipo de evento con la lista de Suscriptores interesados
    private final Map<Class<?>, List<Subscriber>> suscriptores = new ConcurrentHashMap<>();

    public void suscribir(Class<?> tipoDeEvento, Subscriber suscriptor) {
        suscriptores.computeIfAbsent(tipoDeEvento, k -> new CopyOnWriteArrayList<>()).add(suscriptor);
    }

    public void desuscribir(Class<?> tipoDeEvento, Subscriber suscriptor) {
        List<Subscriber> lista = suscriptores.get(tipoDeEvento);
        if (lista != null) {
            lista.remove(suscriptor);
        }
    }

    public void publicar(Object evento) {
        List<Subscriber> lista = suscriptores.get(evento.getClass());
        if (lista != null) {
            // notificamos a cada suscriptor registrado para este evento
            for (Subscriber s : lista) {
                s.onEvent(evento);
            }
        }
    }
}