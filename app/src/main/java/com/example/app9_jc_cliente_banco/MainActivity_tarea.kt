package com.example.app9_jc_cliente_banco



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOutBack
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AddCard
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.QrCode2
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.TrendingDown
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults.colors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.animation.animateColorAsState   // ← usado en LoginScreen (borderColor)
import androidx.compose.animation.core.animateFloat      // ← extension de InfiniteTransition (Biometría, Badge, Shimmer)
import kotlin.math.absoluteValue                         // ← usado en el pageOffset del Dashboard

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MiBancoApp()
        }
    }
}

/* ============================================================
   1. MODELOS DE DATOS TEMPORALES
   Luego estas clases pueden ir a archivos separados.
   ============================================================ */

enum class AppScreen {
    SPLASH,
    LOGIN,
    DASHBOARD,
    CUENTAS,
    PRESTAMOS,
    OPERAR,
    NOTIFICACIONES,
    PERFIL,
    INGRESOS_GASTOS
}

data class Cuenta(
    val id: String,
    val tipo: String,
    val nombre: String,
    val numeroOculto: String,
    val saldo: Double,
    val moneda: String,
    val color: Color,
    val icono: androidx.compose.ui.graphics.vector.ImageVector
)

data class Movimiento(
    val descripcion: String,
    val fecha: String,
    val monto: Double,
    val esIngreso: Boolean,
    val categoria: String
)

data class Notificacion(
    val titulo: String,
    val descripcion: String,
    val hora: String,
    val leida: Boolean,
    val icono: androidx.compose.ui.graphics.vector.ImageVector
)

/* ============================================================
   2. COLORES Y TEMA MATERIAL 3
   ============================================================ */

private val BancoAzul = Color(0xFF003A70)
private val BancoAzulClaro = Color(0xFF005CA8)
private val BancoCeleste = Color(0xFF00A5E5)
private val BancoVerde = Color(0xFF008A5B)
private val BancoRojo = Color(0xFFBA1A1A)
private val BancoFondoClaro = Color(0xFFF7F9FC)
private val BancoFondoOscuro = Color(0xFF101418)
private val BancoSuperficieOscura = Color(0xFF1A2027)

private val LightColors = androidx.compose.material3.lightColorScheme(
    primary = BancoAzul,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD4E3FF),
    onPrimaryContainer = Color(0xFF001B3B),
    secondary = BancoCeleste,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFC7E7FF),
    onSecondaryContainer = Color(0xFF001E2F),
    tertiary = BancoVerde,
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFF9EF2C5),
    onTertiaryContainer = Color(0xFF002113),
    error = BancoRojo,
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),
    background = BancoFondoClaro,
    onBackground = Color(0xFF191C20),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF191C20),
    surfaceVariant = Color(0xFFDEE3EB),
    onSurfaceVariant = Color(0xFF42474E),
    outline = Color(0xFF72777F)
)

private val DarkColors = androidx.compose.material3.darkColorScheme(
    primary = Color(0xFFA8C8FF),
    onPrimary = Color(0xFF00315F),
    primaryContainer = Color(0xFF00477F),
    onPrimaryContainer = Color(0xFFD4E3FF),
    secondary = Color(0xFF8DD0FF),
    onSecondary = Color(0xFF00344F),
    secondaryContainer = Color(0xFF004C6D),
    onSecondaryContainer = Color(0xFFC7E7FF),
    tertiary = Color(0xFF82DDAA),
    onTertiary = Color(0xFF003821),
    tertiaryContainer = Color(0xFF005232),
    onTertiaryContainer = Color(0xFF9EF2C5),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),
    background = BancoFondoOscuro,
    onBackground = Color(0xFFE1E2E8),
    surface = BancoSuperficieOscura,
    onSurface = Color(0xFFE1E2E8),
    surfaceVariant = Color(0xFF42474E),
    onSurfaceVariant = Color(0xFFC2C7D0),
    outline = Color(0xFF8C9199)
)

@Composable
fun MiBancoTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = androidx.compose.material3.Typography(),
        shapes = androidx.compose.material3.Shapes(
            extraSmall = RoundedCornerShape(6.dp),
            small = RoundedCornerShape(10.dp),
            medium = RoundedCornerShape(16.dp),
            large = RoundedCornerShape(24.dp),
            extraLarge = RoundedCornerShape(32.dp)
        ),
        content = content
    )
}

/* ============================================================
   3. APP PRINCIPAL Y CONTROL DE PANTALLAS
   ============================================================ */

@Composable
fun MiBancoApp() {
    var darkTheme by remember { mutableStateOf(false) }
    var currentScreen by remember { mutableStateOf(AppScreen.SPLASH) }
    var isGuest by remember { mutableStateOf(false) }

    MiBancoTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AnimatedContent(
                targetState = currentScreen,
                transitionSpec = {
                    (slideInHorizontally(
                        initialOffsetX = { it },
                        animationSpec = tween(300, easing = FastOutSlowInEasing)
                    ) + fadeIn(animationSpec = tween(300)))
                        .togetherWith(
                            slideOutHorizontally(
                                targetOffsetX = { -it / 3 },
                                animationSpec = tween(300, easing = FastOutSlowInEasing)
                            ) + fadeOut(animationSpec = tween(200))
                        )
                },
                label = "NavegacionPrincipal"
            ) { screen ->
                when (screen) {
                    AppScreen.SPLASH -> SplashScreen(
                        onFinish = {
                            // Luego reemplazar por verificación real con DataStore.
                            currentScreen = AppScreen.LOGIN
                        }
                    )

                    AppScreen.LOGIN -> LoginScreen(
                        onLoginSuccess = {
                            isGuest = false
                            currentScreen = AppScreen.DASHBOARD
                        },
                        onGuest = {
                            isGuest = true
                            currentScreen = AppScreen.DASHBOARD
                        }
                    )

                    AppScreen.DASHBOARD -> BancoShell(
                        title = "Inicio",
                        selectedScreen = AppScreen.DASHBOARD,
                        isGuest = isGuest,
                        darkTheme = darkTheme,
                        onDarkThemeChange = { darkTheme = it },
                        onNavigate = { destination ->
                            currentScreen = destination
                        },
                        onLogout = {
                            isGuest = false
                            currentScreen = AppScreen.LOGIN
                        }
                    ) {
                        DashboardScreen(
                            isGuest = isGuest,
                            onNavigate = { currentScreen = it }
                        )
                    }

                    AppScreen.CUENTAS -> BancoShell(
                        title = "Mis cuentas",
                        selectedScreen = AppScreen.CUENTAS,
                        isGuest = isGuest,
                        darkTheme = darkTheme,
                        onDarkThemeChange = { darkTheme = it },
                        onNavigate = { currentScreen = it },
                        onLogout = {
                            isGuest = false
                            currentScreen = AppScreen.LOGIN
                        }
                    ) {
                        CuentasScreen()
                    }

                    AppScreen.PRESTAMOS -> BancoShell(
                        title = "Préstamos",
                        selectedScreen = AppScreen.PRESTAMOS,
                        isGuest = isGuest,
                        darkTheme = darkTheme,
                        onDarkThemeChange = { darkTheme = it },
                        onNavigate = { currentScreen = it },
                        onLogout = {
                            isGuest = false
                            currentScreen = AppScreen.LOGIN
                        }
                    ) {
                        PrestamosScreen()
                    }

                    AppScreen.OPERAR -> BancoShell(
                        title = "Operar",
                        selectedScreen = AppScreen.OPERAR,
                        isGuest = isGuest,
                        darkTheme = darkTheme,
                        onDarkThemeChange = { darkTheme = it },
                        onNavigate = { currentScreen = it },
                        onLogout = {
                            isGuest = false
                            currentScreen = AppScreen.LOGIN
                        }
                    ) {
                        OperarScreen()
                    }

                    AppScreen.NOTIFICACIONES -> BancoShell(
                        title = "Notificaciones",
                        selectedScreen = AppScreen.NOTIFICACIONES,
                        isGuest = isGuest,
                        darkTheme = darkTheme,
                        onDarkThemeChange = { darkTheme = it },
                        onNavigate = { currentScreen = it },
                        onLogout = {
                            isGuest = false
                            currentScreen = AppScreen.LOGIN
                        }
                    ) {
                        NotificacionesScreen()
                    }

                    AppScreen.PERFIL -> BancoShell(
                        title = "Mi perfil",
                        selectedScreen = AppScreen.PERFIL,
                        isGuest = isGuest,
                        darkTheme = darkTheme,
                        onDarkThemeChange = { darkTheme = it },
                        onNavigate = { currentScreen = it },
                        onLogout = {
                            isGuest = false
                            currentScreen = AppScreen.LOGIN
                        }
                    ) {
                        PerfilScreen(
                            darkTheme = darkTheme,
                            onDarkThemeChange = { darkTheme = it }
                        )
                    }

                    AppScreen.INGRESOS_GASTOS -> BancoShell(
                        title = "Ingresos y gastos",
                        selectedScreen = AppScreen.INGRESOS_GASTOS,
                        isGuest = isGuest,
                        darkTheme = darkTheme,
                        onDarkThemeChange = { darkTheme = it },
                        onNavigate = { currentScreen = it },
                        onLogout = {
                            isGuest = false
                            currentScreen = AppScreen.LOGIN
                        }
                    ) {
                        IngresosGastosScreen()
                    }
                }
            }
        }
    }
}

/* ============================================================
   4. SPLASH
   ============================================================ */

@Composable
fun SplashScreen(onFinish: () -> Unit) {
    val scale = remember { Animatable(0.80f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        launch {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(600, easing = EaseOutBack)
            )
        }
        launch {
            alpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(450)
            )
        }

        delay(1200)
        onFinish()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BancoAzul),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .scale(scale.value)
                .alpha(alpha.value)
        ) {
            Box(
                modifier = Modifier
                    .size(112.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBalance,
                    contentDescription = "Logo de Mi Banco",
                    tint = Color.White,
                    modifier = Modifier.size(60.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Mi Banco",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Tu banco, siempre contigo",
                color = Color.White.copy(alpha = 0.85f),
                fontSize = 15.sp
            )
        }
    }
}

/* ============================================================
   5. LOGIN
   ============================================================ */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onGuest: () -> Unit
) {
    var cardNumber by remember { mutableStateOf("") }
    var documentType by remember { mutableStateOf("DNI") }
    var dni by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var documentMenuExpanded by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }
    var loading by remember { mutableStateOf(false) }
    var showError by remember { mutableStateOf(false) }

    val shakeOffset = remember { Animatable(0f) }
    val borderColor by animateColorAsState(
        targetValue = if (showError) MaterialTheme.colorScheme.error
        else MaterialTheme.colorScheme.outline,
        label = "ColorBordeError"
    )

    // HU-03 (Tarea 3): contraste reforzado únicamente para tarjeta, tipo de
    // documento y DNI. No se reutiliza "borderColor" aquí para no afectar el
    // campo de contraseña, que es responsabilidad exclusiva de la Tarea 4.
    val highContrastFocusedColor by animateColorAsState(
        targetValue = if (showError) MaterialTheme.colorScheme.error
        else MaterialTheme.colorScheme.primary,
        label = "ColorBordeEnfocadoContrasteAlto"
    )
    val highContrastUnfocusedColor by animateColorAsState(
        targetValue = if (showError) MaterialTheme.colorScheme.error
        else MaterialTheme.colorScheme.onSurfaceVariant,
        label = "ColorBordeDesenfocadoContrasteAlto"
    )
    val loginFieldShape = RoundedCornerShape(12.dp)

    // HU-03 (Tarea 3): espaciado adaptativo según altura real de pantalla.
    // Se usa LocalConfiguration en vez de BoxWithConstraints porque dentro de un
    // item{} de LazyColumn la altura se mide sin acotar (para permitir scroll),
    // por lo que BoxWithConstraints no daría un valor útil aquí.
    val screenHeightDp = LocalConfiguration.current.screenHeightDp
    val formSpacing by animateDpAsState(
        targetValue = if (screenHeightDp < 640) 10.dp else 14.dp,
        label = "EspaciadoFormularioLogin"
    )

    val scope = rememberCoroutineScope()

    fun validateLogin() {
        if (
            cardNumber.replace(" ", "").length < 16 ||
            dni.length < 8 ||
            password.length < 4
        ) {
            showError = true
            scope.launch {
                shakeOffset.snapTo(0f)
                repeat(3) {
                    shakeOffset.animateTo(
                        targetValue = 10f,
                        animationSpec = tween(55)
                    )
                    shakeOffset.animateTo(
                        targetValue = -10f,
                        animationSpec = tween(55)
                    )
                }
                shakeOffset.animateTo(0f, animationSpec = tween(55))
            }
        } else {
            showError = false
            loading = true
            scope.launch {
                delay(1400)
                loading = false
                onLoginSuccess()
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(
            start = 24.dp,
            end = 24.dp,
            top = 48.dp,
            bottom = 24.dp
        )
    ) {
        item {
            Box(
                modifier = Modifier
                    .size(82.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBalance,
                    contentDescription = "Logo Mi Banco",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(42.dp)
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Bienvenido a Mi Banco",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Ingresa tus datos para continuar",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(28.dp))
        }

        item {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = shakeOffset.value.dp),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(formSpacing)
                ) {
                    Text(
                        text = "Iniciar sesión",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
                    )

                    OutlinedTextField(
                        value = cardNumber,
                        onValueChange = {
                            cardNumber = it.filter { char -> char.isDigit() }
                                .take(16)
                                .chunked(4)
                                .joinToString(" ")
                            showError = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Número de tarjeta") },
                        placeholder = { Text("0000 0000 0000 0000") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.CreditCard,
                                contentDescription = null
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        singleLine = true,
                        isError = showError && cardNumber.replace(" ", "").length < 16,
                        shape = loginFieldShape,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = highContrastFocusedColor,
                            unfocusedBorderColor = highContrastUnfocusedColor
                        )
                    )

                    ExposedDropdownMenuBox(
                        expanded = documentMenuExpanded,
                        onExpandedChange = {
                            documentMenuExpanded = !documentMenuExpanded
                        }
                    ) {
                        OutlinedTextField(
                            value = documentType,
                            onValueChange = {},
                            readOnly = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor(),
                            label = { Text("Tipo de documento") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(
                                    expanded = documentMenuExpanded
                                )
                            },
                            shape = loginFieldShape,
                            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                                focusedBorderColor = highContrastFocusedColor,
                                unfocusedBorderColor = highContrastUnfocusedColor
                            )
                        )

                        ExposedDropdownMenu(
                            expanded = documentMenuExpanded,
                            onDismissRequest = {
                                documentMenuExpanded = false
                            }
                        ) {
                            listOf("DNI", "Carné de extranjería", "Pasaporte").forEach {
                                    option ->
                                androidx.compose.material3.DropdownMenuItem(
                                    text = { Text(option) },
                                    onClick = {
                                        documentType = option
                                        documentMenuExpanded = false
                                    }
                                )
                            }
                        }
                    }

                    OutlinedTextField(
                        value = dni,
                        onValueChange = {
                            dni = it.filter { char -> char.isDigit() }.take(12)
                            showError = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("N° de $documentType") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = null
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        singleLine = true,
                        isError = showError && dni.length < 8,
                        shape = loginFieldShape,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = highContrastFocusedColor,
                            unfocusedBorderColor = highContrastUnfocusedColor
                        )
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            showError = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Contraseña") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        trailingIcon = {
                            IconButton(
                                onClick = { passwordVisible = !passwordVisible }
                            ) {
                                AnimatedContent(
                                    targetState = passwordVisible,
                                    label = "MostrarOcultarContrasena"
                                ) { visible ->
                                    Icon(
                                        imageVector = if (visible) {
                                            Icons.Default.VisibilityOff
                                        } else {
                                            Icons.Default.Visibility
                                        },
                                        contentDescription = if (visible) {
                                            "Ocultar contraseña"
                                        } else {
                                            "Mostrar contraseña"
                                        }
                                    )
                                }
                            }
                        },
                        visualTransformation = if (passwordVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        singleLine = true,
                        isError = showError && password.length < 4,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = borderColor,
                            unfocusedBorderColor = borderColor
                        )
                    )

                    AnimatedVisibility(
                        visible = showError,
                        enter = fadeIn() + slideInVertically(),
                        exit = fadeOut() + slideOutVertically()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                imageVector = Icons.Default.Security,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.error,
                                modifier = Modifier.size(18.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Verifica tus datos e inténtalo nuevamente.",
                                color = MaterialTheme.colorScheme.error,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }

                    Button(
                        onClick = { validateLogin() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        enabled = !loading
                    ) {
                        AnimatedContent(
                            targetState = loading,
                            label = "EstadoBotonLogin"
                        ) { isLoading ->
                            if (isLoading) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.size(20.dp),
                                        color = MaterialTheme.colorScheme.onPrimary,
                                        strokeWidth = 2.dp
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text("Verificando...")
                                }
                            } else {
                                Text("Iniciar sesión")
                            }
                        }
                    }

                    TextButton(
                        onClick = {},
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text("¿Olvidaste tu contraseña?")
                    }
                }
            }

            Spacer(modifier = Modifier.height(22.dp))
        }

        item {
            BiometricButton(
                onClick = onLoginSuccess
            )

            Spacer(modifier = Modifier.height(14.dp))

            TextButton(onClick = onGuest) {
                Text("Continuar como invitado")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Al ingresar aceptas los términos y condiciones de Mi Banco.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun BiometricButton(onClick: () -> Unit) {
    val infiniteTransition = rememberInfiniteTransition(label = "PulsoBiometrico")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.08f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "EscalaHuella"
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(58.dp)
                .scale(scale)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondaryContainer),
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        ) {
            Icon(
                imageVector = Icons.Default.Fingerprint,
                contentDescription = "Ingresar con huella digital",
                modifier = Modifier.size(30.dp)
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Ingresar con huella digital",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

/* ============================================================
   6. ESTRUCTURA PRINCIPAL: DRAWER + TOP BAR + BOTTOM BAR
   ============================================================ */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BancoShell(
    title: String,
    selectedScreen: AppScreen,
    isGuest: Boolean,
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit,
    onNavigate: (AppScreen) -> Unit,
    onLogout: () -> Unit,
    content: @Composable () -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerContent(
                isGuest = isGuest,
                selectedScreen = selectedScreen,
                onNavigate = { screen ->
                    scope.launch {
                        drawerState.close()
                        onNavigate(screen)
                    }
                },
                onLogout = {
                    scope.launch {
                        drawerState.close()
                        onLogout()
                    }
                }
            )
        }
    ) {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = title,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch { drawerState.open() }
                            }
                        ) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Abrir menú lateral"
                            )
                        }
                    },
                    actions = {
                        if (isGuest) {
                            IconButton(
                                onClick = {
                                    scope.launch {
                                        snackbarHostState.showSnackbar(
                                            "Estás navegando como invitado."
                                        )
                                    }
                                }
                            ) {
                                Icon(
                                    Icons.Default.Lock,
                                    contentDescription = "Modo invitado",
                                    tint = MaterialTheme.colorScheme.tertiary
                                )
                            }
                        } else {
                            IconButton(
                                onClick = { onNavigate(AppScreen.NOTIFICACIONES) }
                            ) {
                                BadgedBox(
                                    badge = {
                                        Badge { Text("3") }
                                    }
                                ) {
                                    Icon(
                                        Icons.Default.Notifications,
                                        contentDescription = "Notificaciones"
                                    )
                                }
                            }
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                )
            },
            bottomBar = {
                BancoBottomBar(
                    selectedScreen = selectedScreen,
                    onNavigate = onNavigate
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                content()
            }
        }
    }
}

@Composable
fun ModalDrawerContent(
    isGuest: Boolean,
    selectedScreen: AppScreen,
    onNavigate: (AppScreen) -> Unit,
    onLogout: () -> Unit
) {
    val drawerItems = listOf(
        Triple("Ingresos y gastos", Icons.Default.BarChart, AppScreen.INGRESOS_GASTOS),
        Triple("Contacto", Icons.Default.Phone, null),
        Triple("Ayuda y preguntas", Icons.Default.HelpOutline, null),
        Triple("Configuración", Icons.Default.Settings, AppScreen.PERFIL)
    )

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(320.dp)
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 12.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Perfil de usuario",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = if (isGuest) "Usuario invitado" else "Guillermo Peña",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = if (isGuest) {
                        "Acceso limitado"
                    } else {
                        "Cliente Mi Banco"
                    },
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(14.dp))
        HorizontalDivider()

        Spacer(modifier = Modifier.height(10.dp))

        // 👇 ÚNICO CAMBIO: variable local "screen" agregada aquí
        drawerItems.forEach { item ->
            val screen = item.third
            val selected = screen == selectedScreen

            NavigationDrawerItem(
                label = { Text(item.first) },
                icon = {
                    Icon(
                        imageVector = item.second,
                        contentDescription = item.first
                    )
                },
                selected = selected,
                onClick = {
                    if (screen != null) {
                        onNavigate(screen)
                    }
                },
                modifier = Modifier.padding(vertical = 2.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        HorizontalDivider()

        NavigationDrawerItem(
            label = {
                Text(
                    text = "Cerrar sesión",
                    color = MaterialTheme.colorScheme.error
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Cerrar sesión",
                    tint = MaterialTheme.colorScheme.error
                )
            },
            selected = false,
            onClick = onLogout,
            modifier = Modifier.padding(vertical = 12.dp),
            colors = NavigationDrawerItemDefaults.colors(
                unselectedContainerColor = Color.Transparent
            )
        )
    }
}

@Composable
fun BancoBottomBar(
    selectedScreen: AppScreen,
    onNavigate: (AppScreen) -> Unit
) {
    val items = listOf(
        Triple("Inicio", Icons.Default.Home, AppScreen.DASHBOARD),
        Triple("Cuentas", Icons.Default.AccountBalance, AppScreen.CUENTAS),
        Triple("Préstamos", Icons.Default.Payments, AppScreen.PRESTAMOS),
        Triple("Operar", Icons.Default.SwapHoriz, AppScreen.OPERAR),
        Triple("Perfil", Icons.Default.Person, AppScreen.PERFIL)
    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = selectedScreen == item.third,
                onClick = { onNavigate(item.third) },
                icon = {
                    Icon(
                        imageVector = item.second,
                        contentDescription = item.first
                    )
                },
                label = { Text(item.first) }
            )
        }
    }
}

/* ============================================================
   7. DASHBOARD
   ============================================================ */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DashboardScreen(
    isGuest: Boolean,
    onNavigate: (AppScreen) -> Unit
) {
    var showTokenSheet by remember { mutableStateOf(false) }

    val cuentas = remember {
        listOf(
            Cuenta(
                id = "1",
                tipo = "Ahorros",
                nombre = "Cuenta Sueldo",
                numeroOculto = "•••• 4821",
                saldo = 8450.70,
                moneda = "S/",
                color = BancoAzul,
                icono = Icons.Default.AccountBalance
            ),
            Cuenta(
                id = "2",
                tipo = "CTS",
                nombre = "Cuenta CTS",
                numeroOculto = "•••• 1290",
                saldo = 12350.25,
                moneda = "S/",
                color = BancoVerde,
                icono = Icons.Default.Savings
            ),
            Cuenta(
                id = "3",
                tipo = "Ahorros USD",
                nombre = "Cuenta Dólares",
                numeroOculto = "•••• 7684",
                saldo = 2150.40,
                moneda = "$",
                color = Color(0xFF6D4C41),
                icono = Icons.Default.AttachMoney
            )
        )
    }

    val pagerState = rememberPagerState(pageCount = { cuentas.size })

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            Column(modifier = Modifier.padding(top = 8.dp)) {
                Text(
                    text = if (isGuest) "Hola, invitado" else "Hola, Guillermo",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Text(
                    text = if (isGuest) {
                        "Explora las funciones disponibles"
                    } else {
                        "Revisa el estado de tus finanzas hoy"
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(
                        horizontal = 20.dp,
                        vertical = 4.dp
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        item {
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 20.dp),
                pageSpacing = 12.dp,
                modifier = Modifier.fillMaxWidth()
            ) { page ->
                val pageOffset = (
                        (pagerState.currentPage - page) +
                                pagerState.currentPageOffsetFraction
                        ).absoluteValue

                val scale = 1f - min(0.08f, pageOffset * 0.08f)
                val alpha = 1f - min(0.30f, pageOffset * 0.30f)

                AccountCard(
                    cuenta = cuentas[page],
                    isGuest = isGuest,
                    modifier = Modifier
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            this.alpha = alpha
                        }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(cuentas.size) { index ->
                    val selected = pagerState.currentPage == index
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 3.dp)
                            .size(
                                width = if (selected) 18.dp else 7.dp,
                                height = 7.dp
                            )
                            .clip(CircleShape)
                            .background(
                                if (selected) MaterialTheme.colorScheme.primary
                                else MaterialTheme.colorScheme.outlineVariant
                            )
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            Text(
                text = "Accesos rápidos",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            LazyRow(
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    QuickAction(
                        text = "Transferir",
                        icon = Icons.Default.Send,
                        color = MaterialTheme.colorScheme.primary,
                        onClick = { onNavigate(AppScreen.OPERAR) }
                    )
                }

                item {
                    QuickAction(
                        text = "PLIN",
                        icon = Icons.Default.QrCode2,
                        color = Color(0xFF612B8F),
                        onClick = { onNavigate(AppScreen.OPERAR) }
                    )
                }

                item {
                    QuickAction(
                        text = "T-Cambio",
                        icon = Icons.Default.SwapHoriz,
                        color = BancoVerde,
                        onClick = { }
                    )
                }

                item {
                    QuickAction(
                        text = "Token",
                        icon = Icons.Default.Security,
                        color = Color(0xFFE67E22),
                        onClick = { showTokenSheet = true }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            FinanceSummaryCard(
                ingresos = 5800.0,
                gastos = 3240.0,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            ExchangeRateCard(
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            RecentMovementsPreview(
                isGuest = isGuest,
                onSeeAll = { onNavigate(AppScreen.CUENTAS) },
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }

    if (showTokenSheet) {
        TokenDigitalSheet(
            onDismiss = { showTokenSheet = false }
        )
    }
}

@Composable
fun AccountCard(
    cuenta: Cuenta,
    isGuest: Boolean,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .height(205.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = cuenta.color
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Icon(
                imageVector = cuenta.icono,
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.16f),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(120.dp)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AssistChip(
                        onClick = {},
                        label = {
                            Text(
                                cuenta.tipo,
                                fontSize = 12.sp
                            )
                        },
                        leadingIcon = {
                            Icon(
                                cuenta.icono,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    )

                    Icon(
                        imageVector = Icons.Default.MoreHoriz,
                        contentDescription = "Más opciones",
                        tint = Color.White
                    )
                }

                Column {
                    Text(
                        text = cuenta.nombre,
                        color = Color.White.copy(alpha = 0.9f),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    if (isGuest) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .blur(8.dp)
                        ) {
                            Text(
                                text = "S/ 8,450.70",
                                color = Color.White,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    } else {
                        AnimatedCurrencyText(
                            amount = cuenta.saldo,
                            currency = cuenta.moneda,
                            color = Color.White,
                            fontSize = 28.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = cuenta.numeroOculto,
                        color = Color.White.copy(alpha = 0.80f),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            if (isGuest) {
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color.Black.copy(alpha = 0.35f))
                        .padding(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Lock,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            text = "Inicia sesión para ver saldo",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun QuickAction(
    text: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.92f else 1f,
        animationSpec = tween(120),
        label = "EscalaAccesoRapido"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(78.dp)
            .scale(scale)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
    ) {
        Box(
            modifier = Modifier
                .size(58.dp)
                .clip(CircleShape)
                .background(color.copy(alpha = 0.15f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = color,
                modifier = Modifier.size(26.dp)
            )
        }

        Spacer(modifier = Modifier.height(7.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun FinanceSummaryCard(
    ingresos: Double,
    gastos: Double,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(
                text = "Resumen de este mes",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Tus ingresos y gastos de septiembre",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AnimatedDonutChart(
                    ingresos = ingresos,
                    gastos = gastos,
                    modifier = Modifier.size(132.dp)
                )

                Spacer(modifier = Modifier.width(18.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    LegendItem(
                        color = MaterialTheme.colorScheme.tertiary,
                        label = "Ingresos",
                        amount = ingresos
                    )

                    LegendItem(
                        color = MaterialTheme.colorScheme.error,
                        label = "Gastos",
                        amount = gastos
                    )

                    HorizontalDivider()

                    Text(
                        text = "Disponible",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Text(
                        text = formatCurrency(ingresos - gastos),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
fun LegendItem(
    color: Color,
    label: String,
    amount: Double
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(color)
        )

        Spacer(modifier = Modifier.width(7.dp))

        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                text = formatCurrency(amount),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun AnimatedDonutChart(
    ingresos: Double,
    gastos: Double,
    modifier: Modifier = Modifier
) {
    val total = max(ingresos + gastos, 1.0)
    val ingresoSweep = ((ingresos / total) * 360f).toFloat()
    val gastoSweep = ((gastos / total) * 360f).toFloat()


    // léelos aquí, en contexto @Composable
    val trackColor = MaterialTheme.colorScheme.surfaceVariant
    val ingresoColor = MaterialTheme.colorScheme.tertiary
    val gastoColor = MaterialTheme.colorScheme.error

    val animation = remember { Animatable(0f) }

    LaunchedEffect(ingresos, gastos) {
        animation.snapTo(0f)
        animation.animateTo(1f, tween(800, easing = FastOutSlowInEasing))
    }

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val stroke = size.minDimension * 0.15f
            val arcSize = Size(size.width - stroke, size.height - stroke)
            val topLeft = Offset(stroke / 2f, stroke / 2f)

            drawArc(color = trackColor, startAngle = -90f, sweepAngle = 360f,
                useCenter = false, topLeft = topLeft, size = arcSize,
                style = Stroke(width = stroke, cap = StrokeCap.Round))

            drawArc(color = ingresoColor, startAngle = -90f,
                sweepAngle = ingresoSweep * animation.value,
                useCenter = false, topLeft = topLeft, size = arcSize,
                style = Stroke(width = stroke, cap = StrokeCap.Round))

            drawArc(color = gastoColor, startAngle = -90f + ingresoSweep,
                sweepAngle = gastoSweep * animation.value,
                useCenter = false, topLeft = topLeft, size = arcSize,
                style = Stroke(width = stroke, cap = StrokeCap.Round))
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Balance",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = formatCompactCurrency(ingresos - gastos),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ExchangeRateCard(modifier: Modifier = Modifier) {
    var rate by remember { mutableStateOf(3.74) }
    var previousRate by remember { mutableStateOf(3.72) }
    val isUp = rate >= previousRate

    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ShowChart,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Tipo de cambio",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Dólar estadounidense (USD)",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(
                    onClick = {
                        previousRate = rate
                        rate = if (rate == 3.74) 3.73 else 3.74
                    }
                ) {
                    Icon(
                        Icons.Default.MoreHoriz,
                        contentDescription = "Actualizar tipo de cambio"
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Compra",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    AnimatedContent(
                        targetState = rate,
                        transitionSpec = {
                            if (targetState > initialState) {
                                (slideInVertically { -it } + fadeIn())
                                    .togetherWith(slideOutVertically { it } + fadeOut())
                            } else {
                                (slideInVertically { it } + fadeIn())
                                    .togetherWith(slideOutVertically { -it } + fadeOut())
                            }
                        },
                        label = "OdometerTipoCambio"
                    ) { currentRate ->
                        Text(
                            text = "S/ %.2f".format(currentRate),
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Column(horizontalAlignment = Alignment.End) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = if (isUp) {
                                Icons.Default.TrendingUp
                            } else {
                                Icons.Default.TrendingDown
                            },
                            contentDescription = null,
                            tint = if (isUp) BancoVerde else MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = if (isUp) "+0.02%" else "-0.02%",
                            color = if (isUp) BancoVerde else MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }

                    Text(
                        text = "Actualizado ahora",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            SparklineChart(
                points = listOf(3.68f, 3.70f, 3.69f, 3.71f, 3.70f, 3.72f, 3.71f, 3.74f),
                color = if (isUp) BancoVerde else MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
            )
        }
    }
}

@Composable
fun SparklineChart(
    points: List<Float>,
    color: Color,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        if (points.size < 2) return@Canvas

        val minValue = points.minOrNull() ?: 0f
        val maxValue = points.maxOrNull() ?: 1f
        val range = max(maxValue - minValue, 0.01f)

        val path = Path()

        points.forEachIndexed { index, value ->
            val x = index * (size.width / (points.size - 1))
            val normalized = (value - minValue) / range
            val y = size.height - (normalized * size.height * 0.85f) - 4f

            if (index == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }
        }

        drawPath(
            path = path,
            color = color,
            style = Stroke(
                width = 4f,
                cap = StrokeCap.Round
            )
        )
    }
}

@Composable
fun RecentMovementsPreview(
    isGuest: Boolean,
    onSeeAll: () -> Unit,
    modifier: Modifier = Modifier
) {
    val movements = listOf(
        Movimiento(
            descripcion = "Pago recibido",
            fecha = "Hoy, 10:35 a. m.",
            monto = 850.0,
            esIngreso = true,
            categoria = "Ingresos"
        ),
        Movimiento(
            descripcion = "Supermercado Metro",
            fecha = "Ayer, 06:15 p. m.",
            monto = 145.60,
            esIngreso = false,
            categoria = "Alimentación"
        ),
        Movimiento(
            descripcion = "Transferencia enviada",
            fecha = "Ayer, 01:20 p. m.",
            monto = 280.0,
            esIngreso = false,
            categoria = "Transferencias"
        )
    )

    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Últimos movimientos",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                TextButton(onClick = onSeeAll) {
                    Text("Ver todos")
                }
            }

            movements.forEachIndexed { index, movement ->
                if (index > 0) {
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                    )
                }

                MovimientoItem(
                    movement = movement,
                    isGuest = isGuest
                )
            }
        }
    }
}

@Composable
fun MovimientoItem(
    movement: Movimiento,
    isGuest: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 9.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(
                    if (movement.esIngreso) {
                        MaterialTheme.colorScheme.tertiaryContainer
                    } else {
                        MaterialTheme.colorScheme.errorContainer
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = if (movement.esIngreso) {
                    Icons.Default.ArrowDownward
                } else {
                    Icons.Default.ArrowUpward
                },
                contentDescription = null,
                tint = if (movement.esIngreso) {
                    MaterialTheme.colorScheme.onTertiaryContainer
                } else {
                    MaterialTheme.colorScheme.onErrorContainer
                }
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = movement.descripcion,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = movement.fecha,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Text(
            text = if (isGuest) "••••••" else {
                (if (movement.esIngreso) "+ " else "- ") +
                        formatCurrency(movement.monto)
            },
            color = if (movement.esIngreso) {
                MaterialTheme.colorScheme.tertiary
            } else {
                MaterialTheme.colorScheme.error
            },
            fontWeight = FontWeight.SemiBold
        )
    }
}

/* ============================================================
   8. CUENTAS
   ============================================================ */

@Composable
fun CuentasScreen() {
    val cuentas = listOf(
        Cuenta(
            "1",
            "Ahorros",
            "Cuenta Sueldo",
            "•••• 4821",
            8450.70,
            "S/",
            BancoAzul,
            Icons.Default.AccountBalance
        ),
        Cuenta(
            "2",
            "CTS",
            "Cuenta CTS",
            "•••• 1290",
            12350.25,
            "S/",
            BancoVerde,
            Icons.Default.Savings
        ),
        Cuenta(
            "3",
            "Ahorros USD",
            "Cuenta Dólares",
            "•••• 7684",
            2150.40,
            "$",
            Color(0xFF6D4C41),
            Icons.Default.AttachMoney
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "Productos financieros",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Selecciona una cuenta para ver su detalle y movimientos.",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))
        }

        items(cuentas) { cuenta ->
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(cuenta.color.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            cuenta.icono,
                            contentDescription = cuenta.tipo,
                            tint = cuenta.color
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            cuenta.nombre,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "${cuenta.tipo} · ${cuenta.numeroOculto}",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodySmall
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        AnimatedCurrencyText(
                            amount = cuenta.saldo,
                            currency = cuenta.moneda,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 18.sp
                        )
                    }

                    Icon(
                        Icons.Default.ChevronRight,
                        contentDescription = "Ver detalle"
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Movimientos recientes",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            MovimientoItem(
                movement = Movimiento(
                    "Transferencia recibida",
                    "Hoy, 10:35 a. m.",
                    850.0,
                    true,
                    "Ingresos"
                ),
                isGuest = false
            )

            MovimientoItem(
                movement = Movimiento(
                    "Pago de servicios",
                    "Ayer, 08:20 p. m.",
                    98.50,
                    false,
                    "Servicios"
                ),
                isGuest = false
            )
        }
    }
}

/* ============================================================
   9. PRÉSTAMOS
   ============================================================ */

@Composable
fun PrestamosScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }
    var sliderValue by remember { mutableFloatStateOf(1500f) }

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = selectedTab) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = { Text("Nuevo adelanto") },
                icon = {
                    Icon(
                        Icons.Default.Payments,
                        contentDescription = null
                    )
                }
            )

            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = { Text("Mis contratos") },
                icon = {
                    Icon(
                        Icons.Default.ReceiptLong,
                        contentDescription = null
                    )
                }
            )
        }

        AnimatedContent(
            targetState = selectedTab,
            transitionSpec = {
                if (targetState > initialState) {
                    (slideInHorizontally { it } + fadeIn())
                        .togetherWith(slideOutHorizontally { -it } + fadeOut())
                } else {
                    (slideInHorizontally { -it } + fadeIn())
                        .togetherWith(slideOutHorizontally { it } + fadeOut())
                }
            },
            label = "TabsPrestamos"
        ) { tab ->
            when (tab) {
                0 -> NuevoAdelantoContent(
                    sliderValue = sliderValue,
                    onValueChange = { sliderValue = it }
                )

                else -> ContratosContent()
            }
        }
    }
}

@Composable
fun NuevoAdelantoContent(
    sliderValue: Float,
    onValueChange: (Float) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "Adelanto de sueldo",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Monto disponible: S/ 3,000.00",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(26.dp))

                    Text(
                        text = "¿Cuánto deseas solicitar?",
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    androidx.compose.material3.Slider(
                        value = sliderValue,
                        onValueChange = onValueChange,
                        valueRange = 300f..3000f,
                        steps = 8
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "S/ 300",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Text(
                            text = "S/ 3,000",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Recibirás aproximadamente",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    AnimatedCurrencyText(
                        amount = sliderValue.toDouble(),
                        currency = "S/",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 30.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                    ) {
                        Text("Solicitar adelanto")
                    }
                }
            }
        }

        item {
            Text(
                text = "Condiciones referenciales",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            ListItem(
                headlineContent = { Text("Desembolso inmediato") },
                supportingContent = {
                    Text("El dinero se deposita en tu cuenta sueldo.")
                },
                leadingContent = {
                    Icon(
                        Icons.Default.SwapHoriz,
                        contentDescription = null
                    )
                }
            )

            ListItem(
                headlineContent = { Text("Pago automático") },
                supportingContent = {
                    Text("El monto se descuenta en tu próximo abono.")
                },
                leadingContent = {
                    Icon(
                        Icons.Default.ReceiptLong,
                        contentDescription = null
                    )
                }
            )
        }
    }
}

@Composable
fun ContratosContent() {
    val contracts = listOf(
        Triple("Préstamo personal", 0.62f, "S/ 4,320.00 pendiente"),
        Triple("Compra de equipo", 0.35f, "S/ 1,850.00 pendiente")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Text(
                text = "Contratos activos",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Consulta el progreso de pago de tus créditos.",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        items(contracts) { contract ->
            AnimatedContractCard(
                title = contract.first,
                progress = contract.second,
                pending = contract.third
            )
        }
    }
}

@Composable
fun AnimatedContractCard(
    title: String,
    progress: Float,
    pending: String
) {
    var started by remember { mutableStateOf(false) }
    val animatedProgress by animateFloatAsState(
        targetValue = if (started) progress else 0f,
        animationSpec = tween(1000, easing = FastOutSlowInEasing),
        label = "ProgresoContrato"
    )

    LaunchedEffect(Unit) {
        started = true
    }

    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.ReceiptLong,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(title, fontWeight = FontWeight.Bold)
                    Text(
                        pending,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                AssistChip(
                    onClick = {},
                    label = { Text("Activo") }
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            LinearProgressIndicator(
                progress = { animatedProgress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(9.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${(animatedProgress * 100).toInt()}% pagado",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

/* ============================================================
   10. OPERAR
   ============================================================ */

@Composable
fun OperarScreen() {
    val actions = listOf(
        Pair("Transferir", Icons.Default.Send),
        Pair("Pagar servicios", Icons.Default.ReceiptLong),
        Pair("PLIN", Icons.Default.QrCode2),
        Pair("Pago con QR", Icons.Default.QrCode2),
        Pair("Tipo de cambio", Icons.Default.SwapHoriz),
        Pair("Recargar celular", Icons.Default.Phone)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "¿Qué operación deseas realizar?",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Elige una opción para comenzar.",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        items(actions.chunked(2)) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                rowItems.forEach { action ->
                    ElevatedCard(
                        modifier = Modifier
                            .weight(1f)
                            .height(135.dp),
                        shape = RoundedCornerShape(20.dp),
                        onClick = {}
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(45.dp)
                                    .clip(CircleShape)
                                    .background(
                                        MaterialTheme.colorScheme.primaryContainer
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    action.second,
                                    contentDescription = action.first,
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }

                            Text(
                                action.first,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }

                if (rowItems.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

/* ============================================================
   11. NOTIFICACIONES
   ============================================================ */

@Composable
fun NotificacionesScreen() {
    val notifications = remember {
        mutableStateOf(
            listOf(
                Notificacion(
                    "Transferencia recibida",
                    "Recibiste S/ 850.00 en tu Cuenta Sueldo.",
                    "Hace 10 min",
                    false,
                    Icons.Default.ArrowDownward
                ),
                Notificacion(
                    "Pago de servicio realizado",
                    "El pago de luz se procesó correctamente.",
                    "Ayer",
                    false,
                    Icons.Default.ReceiptLong
                ),
                Notificacion(
                    "Resumen mensual disponible",
                    "Tu resumen financiero de agosto está listo.",
                    "02 set.",
                    true,
                    Icons.Default.BarChart
                )
            )
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = "Mantente informado",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Desliza una notificación para gestionarla.",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))
        }

        items(notifications.value) { notification ->
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                onClick = {
                    notifications.value = notifications.value.map {
                        if (it == notification) it.copy(leida = true) else it
                    }
                }
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            notification.icono,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = notification.titulo,
                                fontWeight = if (notification.leida) {
                                    FontWeight.Normal
                                } else {
                                    FontWeight.Bold
                                },
                                modifier = Modifier.weight(1f)
                            )

                            if (!notification.leida) {
                                PulsingBadge()
                            }
                        }

                        Text(
                            text = notification.descripcion,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = notification.hora,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PulsingBadge() {
    val transition = rememberInfiniteTransition(label = "PulsoNotificacion")
    val alpha by transition.animateFloat(
        initialValue = 1f,
        targetValue = 0.45f,
        animationSpec = infiniteRepeatable(
            animation = tween(900),
            repeatMode = RepeatMode.Reverse
        ),
        label = "AlphaBadge"
    )

    Box(
        modifier = Modifier
            .size(9.dp)
            .alpha(alpha)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.error)
    )
}

/* ============================================================
   12. PERFIL
   ============================================================ */

@Composable
fun PerfilScreen(
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit
) {
    var biometrics by remember { mutableStateOf(true) }
    var notifications by remember { mutableStateOf(true) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp)
            ) {
                Row(
                    modifier = Modifier.padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Foto de perfil",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier.size(34.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column {
                        Text(
                            "Guillermo Peña Garcia",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "DNI: ••••••••",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }

        item {
            Text(
                text = "Preferencias",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        item {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            ) {
                Column {
                    ListItem(
                        headlineContent = { Text("Tema oscuro") },
                        supportingContent = {
                            Text("Cambia la apariencia de la aplicación.")
                        },
                        leadingContent = {
                            Icon(
                                if (darkTheme) {
                                    Icons.Default.DarkMode
                                } else {
                                    Icons.Default.LightMode
                                },
                                contentDescription = null
                            )
                        },
                        trailingContent = {
                            Switch(
                                checked = darkTheme,
                                onCheckedChange = onDarkThemeChange
                            )
                        }
                    )

                    HorizontalDivider()

                    ListItem(
                        headlineContent = { Text("Acceso biométrico") },
                        supportingContent = {
                            Text("Ingresa con huella digital.")
                        },
                        leadingContent = {
                            Icon(
                                Icons.Default.Fingerprint,
                                contentDescription = null
                            )
                        },
                        trailingContent = {
                            Switch(
                                checked = biometrics,
                                onCheckedChange = { biometrics = it }
                            )
                        }
                    )

                    HorizontalDivider()

                    ListItem(
                        headlineContent = { Text("Notificaciones") },
                        supportingContent = {
                            Text("Recibe alertas de operaciones y movimientos.")
                        },
                        leadingContent = {
                            Icon(
                                Icons.Default.Notifications,
                                contentDescription = null
                            )
                        },
                        trailingContent = {
                            Switch(
                                checked = notifications,
                                onCheckedChange = { notifications = it }
                            )
                        }
                    )
                }
            }
        }

        item {
            Text(
                text = "Seguridad",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        item {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            ) {
                ListItem(
                    headlineContent = { Text("Cambiar contraseña") },
                    supportingContent = {
                        Text("Actualiza tu clave de acceso.")
                    },
                    leadingContent = {
                        Icon(
                            Icons.Default.Lock,
                            contentDescription = null
                        )
                    },
                    trailingContent = {
                        Icon(
                            Icons.Default.ChevronRight,
                            contentDescription = "Cambiar contraseña"
                        )
                    }
                )
            }
        }
    }
}

/* ============================================================
   13. INGRESOS Y GASTOS
   ============================================================ */

@Composable
fun IngresosGastosScreen() {
    var selectedFilter by remember { mutableStateOf("Todos") }
    val filters = listOf("Todos", "Alimentación", "Servicios", "Transporte")

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Análisis financiero",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Compara tus ingresos y gastos mensuales.",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filters) { filter ->
                    FilterChip(
                        selected = selectedFilter == filter,
                        onClick = { selectedFilter = filter },
                        label = { Text(filter) }
                    )
                }
            }
        }

        item {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "Evolución mensual",
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Ingresos vs. gastos",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    BarChart(
                        income = listOf(4800f, 5200f, 4600f, 5800f, 5300f),
                        expenses = listOf(2900f, 3200f, 2800f, 3240f, 3000f),
                        labels = listOf("May", "Jun", "Jul", "Ago", "Set"),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(230.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(18.dp)
                    ) {
                        ChartLegend(
                            color = MaterialTheme.colorScheme.tertiary,
                            label = "Ingresos"
                        )

                        ChartLegend(
                            color = MaterialTheme.colorScheme.error,
                            label = "Gastos"
                        )
                    }
                }
            }
        }

        item {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "Resumen de septiembre",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    SummaryRow(
                        "Ingresos",
                        formatCurrency(5800.0),
                        MaterialTheme.colorScheme.tertiary
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    SummaryRow(
                        "Gastos",
                        formatCurrency(3240.0),
                        MaterialTheme.colorScheme.error
                    )

                    HorizontalDivider(modifier = Modifier.padding(vertical = 14.dp))

                    SummaryRow(
                        "Balance",
                        formatCurrency(2560.0),
                        MaterialTheme.colorScheme.primary,
                        bold = true
                    )
                }
            }
        }
    }
}

@Composable
fun ChartLegend(color: Color, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(color)
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            label,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
fun SummaryRow(
    label: String,
    amount: String,
    color: Color,
    bold: Boolean = false
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            modifier = Modifier.weight(1f),
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
        )

        Text(
            text = amount,
            color = color,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.SemiBold
        )
    }
}

@Composable
fun BarChart(
    income: List<Float>,
    expenses: List<Float>,
    labels: List<String>,
    modifier: Modifier = Modifier
) {
    val animation = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        animation.animateTo(
            targetValue = 1f,
            animationSpec = tween(900, easing = FastOutSlowInEasing)
        )
    }

    val maxValue = max(
        income.maxOrNull() ?: 1f,
        expenses.maxOrNull() ?: 1f
    )

    Column(modifier = modifier) {
        Canvas(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            val chartHeight = size.height * 0.85f
            val groupWidth = size.width / income.size
            val barWidth = groupWidth * 0.26f

            for (i in income.indices) {
                val incomeHeight = (
                        (income[i] / maxValue) * chartHeight * animation.value
                        )
                val expenseHeight = (
                        (expenses[i] / maxValue) * chartHeight * animation.value
                        )

                val centerX = groupWidth * i + groupWidth / 2f

                drawRoundRect(
                    color = BancoVerde,
                    topLeft = Offset(
                        x = centerX - barWidth - 3f,
                        y = chartHeight - incomeHeight
                    ),
                    size = Size(barWidth, incomeHeight),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(
                        10f,
                        10f
                    )
                )

                drawRoundRect(
                    color = BancoRojo,
                    topLeft = Offset(
                        x = centerX + 3f,
                        y = chartHeight - expenseHeight
                    ),
                    size = Size(barWidth, expenseHeight),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(
                        10f,
                        10f
                    )
                )
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            labels.forEach { label ->
                Text(
                    text = label,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

/* ============================================================
   14. TOKEN DIGITAL
   ============================================================ */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TokenDigitalSheet(onDismiss: () -> Unit) {
    var token by remember { mutableStateOf("") }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val progress = remember { Animatable(1f) }

    LaunchedEffect(Unit) {
        progress.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                durationMillis = 60_000,
                easing = LinearEasing
            )
        )
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 34.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(58.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.Security,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(30.dp)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Token Digital",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Ingresa el código de 6 dígitos para confirmar la operación.",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 6.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = token,
                onValueChange = {
                    token = it.filter { char -> char.isDigit() }.take(6)
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Código de seguridad") },
                placeholder = { Text("000000") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                singleLine = true,
                textStyle = MaterialTheme.typography.headlineSmall.copy(
                    letterSpacing = 10.sp,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(22.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(70.dp)
            ) {
                CircularProgressIndicator(
                    progress = { progress.value },
                    modifier = Modifier.fillMaxSize(),
                    color = if (progress.value < 0.17f) {
                        MaterialTheme.colorScheme.error
                    } else {
                        MaterialTheme.colorScheme.primary
                    },
                    strokeWidth = 6.dp
                )

                Text(
                    text = "${(progress.value * 60).toInt()} s",
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onDismiss,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                enabled = token.length == 6
            ) {
                Text("Confirmar operación")
            }
        }
    }
}

/* ============================================================
   15. SHIMMER: ESTADO DE CARGA PARA FUTURA CONEXIÓN SUPABASE
   ============================================================ */

@Composable
fun ShimmerCard(
    modifier: Modifier = Modifier
) {
    val transition = rememberInfiniteTransition(label = "Shimmer")
    val translateAnimation by transition.animateFloat(
        initialValue = -700f,
        targetValue = 700f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing)
        ),
        label = "MovimientoShimmer"
    )

    val shimmerBrush = Brush.linearGradient(
        colors = listOf(
            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.9f),
            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
        ),
        start = Offset(translateAnimation - 300f, 0f),
        end = Offset(translateAnimation, 0f)
    )

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(shimmerBrush)
    )
}

/* ============================================================
   16. UTILIDADES
   ============================================================ */

@Composable
fun AnimatedCurrencyText(
    amount: Double,
    currency: String = "S/",
    color: Color = MaterialTheme.colorScheme.onSurface,
    fontSize: androidx.compose.ui.unit.TextUnit = 22.sp
) {
    val animatedValue = remember { Animatable(0f) }

    LaunchedEffect(amount) {
        animatedValue.animateTo(
            targetValue = amount.toFloat(),
            animationSpec = tween(850, easing = FastOutSlowInEasing)
        )
    }

    Text(
        text = "$currency ${formatNumber(animatedValue.value.toDouble())}",
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold
    )
}

fun formatCurrency(amount: Double): String {
    return "S/ ${formatNumber(amount)}"
}

fun formatCompactCurrency(amount: Double): String {
    return when {
        amount >= 1000 -> "S/ ${(amount / 1000.0).toString().take(3)}k"
        else -> "S/ ${amount.toInt()}"
    }
}

fun formatNumber(amount: Double): String {
    val formatter = NumberFormat.getNumberInstance(Locale("es", "PE"))
    formatter.minimumFractionDigits = 2
    formatter.maximumFractionDigits = 2
    return formatter.format(amount)
}