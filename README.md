## Novedades (Semana 4 — Setiembre 2026)

### Reestructuración del proyecto
- Se consolidó el proyecto en un único módulo `app/`, eliminando la separación anterior entre `01_Java_XML/` y `02_JetpackCompose/`.
- Se limpiaron del control de versiones los archivos de caché (`.gradle/`) y binarios de compilación (`build/`), que no deben trackearse en Git. Se actualizó `.gitignore` para prevenir que vuelvan a subirse.

### Mejoras UI/UX — LoginScreen() (HU-03, Tarea 4 del curso Desarrollo Móvil)
Ajustes de mantenimiento sobre la pantalla de login, alineados con Material Design 3:

- **Layout adaptativo**: se lee la altura real de pantalla con `LocalConfiguration` y se ajusta dinámicamente el espaciado del formulario (10dp en pantallas ≤ 640dp de alto, 14dp en pantallas más altas), animado con `animateDpAsState` para evitar saltos bruscos.
- **Contraste de campos**: se reforzó el contraste de los bordes (`focusedBorderColor` / `unfocusedBorderColor`) en los campos de número de tarjeta, tipo de documento y DNI, resolviendo un hallazgo de QA sobre baja legibilidad en estado de error.
- **Consistencia visual**: se unificó el `shape` (esquinas redondeadas, 12dp) entre el campo de tipo de documento (`ExposedDropdownMenuBox`) y los demás campos del formulario.

### Notas técnicas
- Imports agregados: `androidx.compose.ui.platform.LocalConfiguration`, `androidx.compose.animation.core.animateDpAsState`.
- No se modificó `validateLogin()` ni los valores mínimos de validación (16 dígitos tarjeta, 8 dígitos DNI, 4 caracteres contraseña).
