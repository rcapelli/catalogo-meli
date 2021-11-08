# Catálogo MeLi, por Ricardo Capelli
El objetivo de esta aplicación desarrollada para dispositivos móviles Android es: 
* Realizar un buscador de productos 
* Poder elegir uno de ellos
* Obtener más información sobre el mismo

Para esto, se consume un [endpoint público de la API de Mercado Libre](https://developers.mercadolibre.com.ar/es_ar/items-y-busquedas).


## Requerimientos
Para desarrollarla, se tuvieron en cuenta los siguientes requerimientos:

* Cada pantalla deberíamos poder rotarla y debería mantenerse el estado de la vista.
* Entrega del proyecto:
Repositorio de código (GitHub público o similar).
* Manejo de casos de error desde el punto de vista del developer.
Cómo se gestionan los casos de error inesperados, la consistencia a lo largo de toda la
app, uso de logs, etc.
* Manejo de casos de error desde el punto de vista del usuario.
Priorizar una experiencia fluida dando feedback al usuario adecuadamente.


## ¿A nivel técnico, qué se puede encontrar dentro de la app?

La aplicación está desarrollada en el lenguaje Kotlin, puede correr en dispositivos que tengan como mínimo, Android 5.0 (Lollipop). <br/>
Dentro de la misma, cuenta con distintos patrones de diseño, como el Singleton y el Repository<br/>
Para poder rotar la pantalla manteniendo vivo el estado de la app, se aplicó el uso de la arquitectura MVVM<br/>
La navegación entre fragments se realizó con Navigation Component<br/>
Contenido de Material Components dentro de Layouts<br/>
Test Unitario utilizando JUnit<br/>
Para el consumo de la API Rest, se utiliza Retrofit<br/>
Las imágenes de los productos se muestran gracias a Picasso<br/>
Manejo de errores<br/>
Logs<br/>

## Contacto

Para comunicarte conmigo, no dudes en hacerlo vía [LinkedIn](https://www.linkedin.com/in/ricardo-capelli-90001875/)
