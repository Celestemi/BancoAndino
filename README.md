## Mejoras UI/UX — LoginScreen() (HU-03, Tarea 3 del curso Desarrollo Móvil)

**Módulo:** LoginScreen() — layout adaptativo
**Situación:** QA reportó que el formulario de login se cortaba o se veía apretado en pantallas pequeñas (5.5" o menos), y que el contraste de los bordes en estado de error era insuficiente.

### Cambios realizados

- **Layout adaptativo**: se lee la altura real del dispositivo con `LocalConfiguration.current.screenHeightDp` y se calcula un espaciado dinámico para el formulario (10dp en pantallas ≤ 640dp de alto, 14dp en pantallas más altas), animado con `animateDpAsState` para evitar saltos bruscos. No se usó `BoxWithConstraints` porque dentro de un `item{}` de `LazyColumn` la altura se mide sin acotar (para permitir scroll), por lo que no habría dado un valor útil.
- **Contraste de bordes**: se reforzó `focusedBorderColor` / `unfocusedBorderColor` en los campos de número de tarjeta, tipo de documento y DNI, con colores independientes del resto del formulario para no afectar otras partes del archivo.
- **Consistencia visual**: se unificó el `shape` (esquinas redondeadas, 12dp) entre el campo de tipo de documento (`ExposedDropdownMenuBox`) y los demás campos.

### Archivos modificados
- `MainActivity.kt` — función `LoginScreen()`

### Imports agregados
- `androidx.compose.ui.platform.LocalConfiguration`
- `androidx.compose.animation.core.animateDpAsState`

### Fuera de alcance (no modificado)
- `validateLogin()` y los valores mínimos de validación (16 dígitos tarjeta, 8 dígitos DNI, 4 caracteres contraseña)
- Campo de contraseña, `shakeOffset` y mensaje de error animado
- `BiometricButton()` y botón de invitado
