# BANCO ANDINO - Proyecto Completo (Sesion 1 a Semana 2)

Curso: Desarrollo de Aplicaciones Moviles

Este paquete contiene TODO el avance del proyecto Banco Andino hasta la
Semana 2, en las dos tecnologias que el curso viene enseñando en paralelo:
**Java + XML** (metodo clasico) y **Jetpack Compose** (metodo declarativo
moderno).

Son dos proyectos de Android Studio separados (asi lo exige la
herramienta), pero pertenecen al mismo tema y avanzan juntos semana a
semana. Por eso van organizados aqui dentro de una sola carpeta.

---

## 01_Java_XML/ -> Linea clasica (con Activities y layouts XML)

**Paquete:** `com.example.bancoandino`

| Semana | Que se agrego |
|--------|----------------|
| Sesion 1 | Ejercicio base: EditText + Button + TextView, conexion XML-Java con findViewById (referencia, no incluido como archivo aparte porque el Reto de Semana 2 ya lo integra y mejora) |
| Semana 2 | LoginActivity + PanelActivity + Intent + RecyclerView con movimientos simulados + boton Cerrar sesion |

**Estructura:**
```
app/src/main/java/com/example/bancoandino/
    activities/LoginActivity.java
    activities/PanelActivity.java
    adapter/MovimientoAdapter.java
    model/Movimiento.java
app/src/main/res/layout/
    activity_login.xml
    activity_panel.xml
    item_movimiento.xml
app/src/main/AndroidManifest.xml
```

**Credenciales de prueba:** `cliente1` / `banco2026`

**Pendiente (opcional, reto extra del PDF):** SharedPreferences para
recordar el ultimo usuario y pre-llenar el campo al reabrir la app.

---

## 02_JetpackCompose/ -> Linea Compose (sin XML, todo en Kotlin)

**Paquete:** `com.example.logincomposebasico`

| Semana | Que se agrego |
|--------|----------------|
| Semana 1 | Login basico en Compose: LoginScreen + BienvenidaScreen, navegacion cambiando una variable de estado (sin Intent, sin Activities separadas) |
| Semana 2 | Barra superior tipo menu (Row) en BienvenidaScreen + boton Cerrar sesion (TextButton) + reto: icono de perfil con indicador de notificacion (Box, eje Z) |

**Estructura:**
```
app/src/main/java/com/example/logincomposebasico/
    MainActivity.kt   (contiene TODO: LoginApp, LoginScreen, BienvenidaScreen)
```

**Credenciales de prueba:** `cliente1` / `banco2026`

---

## Como usar este paquete

1. Descomprime el zip.
2. Cada carpeta (`01_Java_XML` y `02_JetpackCompose`) corresponde a un
   proyecto DISTINTO en Android Studio. No copies archivos de una carpeta
   dentro del proyecto de la otra: usan paquetes y arquitecturas distintas.
3. Si ya tienes los proyectos creados en tu maquina, simplemente reemplaza
   los archivos correspondientes por los de aqui (o copia carpeta por
   carpeta si estas empezando de cero).
4. Cada vez que subas el PDF de una semana nueva, este mismo paquete se
   ira actualizando: se conserva todo lo anterior y solo se agrega o
   modifica lo que pida la semana nueva.

---

## Linea de tiempo del avance (para que quede claro en el reporte/entrega)

```
Sesion 1  -----> Semana 2  -----> Semana 3 (pendiente)
   |                 |                  |
   base XML/Java   Reto: RecyclerView   ...
   base Compose    + Menu navegacion    ...
                   + Cerrar sesion
```
