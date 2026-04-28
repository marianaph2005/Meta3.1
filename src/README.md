# La Taberna del Gólem Alquímico - Event Bus
 Meta para la clase de Análisis y Diseño de Sistemas sobre el patrón de arquitectura Event Bus.

## Cómo ejecutar el proyecto:
1. Asegurarse de tener instalado Java .
2. Clona este repositorio: `git clone <https://github.com/marianaph2005/Meta3.1>`
3. Compila los archivos:
4. Ejecuta la clase principal: `java Main`

## Sobre la implementación:
- **Desacoplamiento:** Los componentes (Barra, Cocina, Banda, etc.) no se conocen entre sí y toda la comunicación pasa por el `EventBus`.
- **Eventos:** Se usan clases inmutables para transportar la información de los pedidos y la música.
