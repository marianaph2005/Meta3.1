# La Taberna del Gólem Alquímico - Patrón Event Bus

Este proyecto es la implementación de la Meta 3.1 para la clase de **Análisis y Diseño de Sistemas**, enfocado en resolver problemas de acoplamiento de software mediante la arquitectura basada en eventos (**Event Bus**).

## Descripción del Problema
El dueño de la taberna tenía un sistema donde la barra, la cocina, la banda de música y el panel de anuncios estaban directamente conectados. Agregar una nueva función era mucho problema.

**La solución:** Rediseñar la taberna utilizando un Bus de Eventos. Ahora, ningún componente sabe de la existencia del otro, sino que todos se comunican publicando y escuchando eventos en un canal central.

## Características y Mejoras Implementadas

- **Desacoplamiento Total:** Los publicadores (`SistemaDePedidos`, `Banda`) y los suscriptores (`Barra`, `Cocina`, `PanelLED`) interactúan exclusivamente a través del `EventBus`.
- **Eventos Inmutables:** La información viaja segura. Clases como `PedidoRealizadoEvent` encapsulan la información y previenen modificaciones accidentales.
- **Multihilos y Concurrencia:** Se utilizaron hilos (`Threads`) para simular los tiempos de preparación reales de la cocina y la barra. Para soportar esto sin que el sistema colapse, el `EventBus` utiliza colecciones seguras para hilos (`ConcurrentHashMap` y `CopyOnWriteArrayList`).
- **BONUS (Extensibilidad):** Se agregó un componente `SistemaDeHumo` que reacciona a una canción épica específica, demostrando que el sistema puede crecer sin modificar ni una sola línea del código original.

## Cómo ejecutar el proyecto

### Desde un IDE (Recomendado - IntelliJ IDEA / Eclipse / NetBeans)
1. Clona este repositorio en tu máquina local:
   ```bash
   git clone [https://github.com/marianaph2005/Meta3.1.git](https://github.com/marianaph2005/Meta3.1.git)
   
2. Abre la carpeta del proyecto en tu IDE preferido.
3. Localiza el archivo (`Main.java`) y presiona el botón de **Run** (Ejecutar).