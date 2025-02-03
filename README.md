# Java_TP_Boliche
Aqui desarrollaremos el trabajo practico integrador de la materia electiva Lenguaje de programación Java.

**![](https://lh4.googleusercontent.com/ptjW-3iL9bTm5-C0QnpPKPrbyWRCVwPkUOvZBuJr4xk9ARJoB-mCguPI2OWRdajDE_Clo8_EcuzgCgXgnpppYL8HTSKqTSLk_Xk02xyIznusYUBmW0DocNbAnecqq-M3hW8DsDbdrfFq3C99JKxl_Qs)**

## Boliche

 Integrantes:
 

 - GLOCER MARTÍN 48165
   
  *  SPINI SANTIAGO 49799

# Tema

Descripción: (2 a 6 líneas describiendo el negocio)

*Sistema de gestión de un boliche*

Esta aplicación Java facilita la gestión integral de un boliche, permitiendo a los usuarios comprar entradas para eventos de manera sencilla a través de una integración con Spark. Los usuarios también pueden interactuar con la comunidad a través de comentarios y acceder a información actualizada sobre los eventos. La plataforma está diseñada para optimizar la experiencia del boliche y sus asistentes, mejorando la gestión de eventos y brindando una forma ágil de adquirir entradas online.

El proyecto tiene como objetivo mejorar la experiencia de los usuarios, agilizar la compra de entradas, y fomentar la interacción entre el boliche y su comunidad a través de funcionalidades como la compra de entradas, la gestión de eventos y la interacción mediante comentarios.

# Modelo de Datos (D-E-R)

<span>![</span><span>img_DER.png</span><span>]</span><span>(</span><span>https://raw.githubusercontent.com/Spini03/Java_TP_Boliche/main/img/img_DER.png</span><span>)</span>

# Modelo de Datos 

<span>![</span><span>img_Modelo_de_Datos.png</span><span>]</span><span>(</span><span>https://raw.githubusercontent.com/Spini03/Java_TP_Boliche/main/img/img_Modelo_de_Datos.png</span><span>)</span>

# Alcance

| Requerimiento | Detalle |
|----------|----------|
| ABMC Simple | 1. ABMC Asistente 2. ABMC Fiesta 3. ABMC Lugar |
| ABMC Dependiente   | 1. ABMC Fiesta_lugar { depende de } ABMC Fiesta, ABMC Lugar  | 
| Listado + detalle  | 1. Asistentes de la fiesta: listado de asistentes filtrado por fiesta. Muestra datos de asistentes ⇒ detalle ABMC Asistente 2. Fiestas asistidas: listado de las fiestas asistidas filtrado por asistente. Muestra datos de las fiestas ⇒ detalle ABMC Fiesta  |
| CUU/Epic | 1. Asistente compra entrada para una fiesta. 2. Asistente hace un comentario sobre un evento |

# Credenciales

Para login siendo asistente usar mail juliarob@gmail.com y contraseña julia123

Para login siendo administrador usar mail johndoe@gmail.com y contraseña P@ssword 
