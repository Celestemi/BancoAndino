package com.example.logincomposebasico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


// ============================================================
// MAIN ACTIVITY
// ============================================================

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    BancoAndinoApp()
                }
            }
        }
    }
}


// ============================================================
// APP PRINCIPAL
// ============================================================

@Composable
fun BancoAndinoApp() {

    // Estado de la pantalla actual
    var pantallaActual by remember {
        mutableStateOf("splash")
    }

    // Usuario que inició sesión
    var nombreUsuario by remember {
        mutableStateOf("")
    }

    when (pantallaActual) {

        // ----------------------------------------------------
        // SPLASH
        // ----------------------------------------------------
        "splash" -> {
            SplashScreen(
                onSplashFinished = {
                    pantallaActual = "login"
                }
            )
        }

        // ----------------------------------------------------
        // LOGIN
        // ----------------------------------------------------
        "login" -> {
            LoginScreen(
                onLoginExitoso = { usuario ->
                    nombreUsuario = usuario
                    pantallaActual = "inicio"
                }
            )
        }

        // ----------------------------------------------------
        // APLICACIÓN PRINCIPAL
        // ----------------------------------------------------
        "inicio" -> {
            BancoPrincipalScreen(
                nombre = nombreUsuario,
                onCerrarSesion = {
                    nombreUsuario = ""
                    pantallaActual = "login"
                }
            )
        }
    }
}


// ============================================================
// 1. SPLASH SCREEN
// La rúbrica exige LaunchedEffect + delay + transición automática
// ============================================================

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit
) {

    // Transición automática después de unos segundos
    LaunchedEffect(Unit) {
        delay(2000)
        onSplashFinished()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Logo
        Box(
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
                .background(Color(0xFFFFC107)),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = Icons.Default.AccountBalance,
                contentDescription = "Banco Andino",
                modifier = Modifier.size(65.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Banco Andino",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Tu banco, siempre contigo",
            color = Color.White,
            fontSize = 15.sp
        )
    }
}


// ============================================================
// 2. LOGIN
// OutlinedTextField + remember + mutableStateOf
// PasswordVisualTransformation
// ============================================================

@Composable
fun LoginScreen(
    onLoginExitoso: (String) -> Unit
) {

    // Credenciales solicitadas en la práctica
    val usuarioValido = "cliente1"
    val claveValida = "banco2026"

    // Estados del formulario
    var usuario by remember {
        mutableStateOf("")
    }

    var clave by remember {
        mutableStateOf("")
    }

    var mensajeError by remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Icono del banco
        Box(
            modifier = Modifier
                .size(85.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = Icons.Default.AccountBalance,
                contentDescription = "Banco Andino",
                modifier = Modifier.size(50.dp),
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Banco Andino",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Inicia sesión",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(28.dp))


        // ----------------------------------------------------
        // USUARIO
        // ----------------------------------------------------

        OutlinedTextField(
            value = usuario,
            onValueChange = {
                usuario = it
                mensajeError = ""
            },
            label = {
                Text("Usuario")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Usuario"
                )
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(14.dp))


        // ----------------------------------------------------
        // CLAVE
        // ----------------------------------------------------

        OutlinedTextField(
            value = clave,
            onValueChange = {
                clave = it
                mensajeError = ""
            },
            label = {
                Text("Contraseña")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Contraseña"
                )
            },
            singleLine = true,

            // Oculta la contraseña
            visualTransformation = PasswordVisualTransformation(),

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))


        // ----------------------------------------------------
        // BOTÓN INGRESAR
        // ----------------------------------------------------

        Button(
            onClick = {

                // Validación de campos vacíos
                if (usuario.isEmpty() || clave.isEmpty()) {

                    mensajeError = "Completa usuario y clave"

                }
                // Validación de credenciales
                else if (
                    usuario == usuarioValido &&
                    clave == claveValida
                ) {

                    mensajeError = ""

                    onLoginExitoso(usuario)

                }
                // Credenciales incorrectas
                else {

                    mensajeError = "Credenciales incorrectas"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Ingresar",
                fontSize = 16.sp
            )
        }


        // ----------------------------------------------------
        // MENSAJE DE ERROR
        // ----------------------------------------------------

        if (mensajeError.isNotEmpty()) {

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = mensajeError,
                color = MaterialTheme.colorScheme.error,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}


// ============================================================
// 3, 4 y 5. APLICACIÓN PRINCIPAL
//
// Scaffold + NavigationBar + mutableStateOf
// ============================================================

@Composable
fun BancoPrincipalScreen(
    nombre: String,
    onCerrarSesion: () -> Unit
) {

    // Estado de la sección seleccionada
    var seccionSeleccionada by remember {
        mutableStateOf(0)
    }


    Scaffold(

        // ====================================================
        // BARRA INFERIOR
        // ====================================================

        bottomBar = {

            NavigationBar {

                // -------------------------------
                // INICIO
                // -------------------------------

                NavigationBarItem(
                    selected = seccionSeleccionada == 0,

                    onClick = {
                        seccionSeleccionada = 0
                    },

                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Inicio"
                        )
                    },

                    label = {
                        Text("Inicio")
                    }
                )


                // -------------------------------
                // CUENTAS
                // -------------------------------

                NavigationBarItem(
                    selected = seccionSeleccionada == 1,

                    onClick = {
                        seccionSeleccionada = 1
                    },

                    icon = {
                        Icon(
                            imageVector = Icons.Default.AccountBalance,
                            contentDescription = "Cuentas"
                        )
                    },

                    label = {
                        Text("Cuentas")
                    }
                )


                // -------------------------------
                // CRÉDITOS
                // -------------------------------

                NavigationBarItem(
                    selected = seccionSeleccionada == 2,

                    onClick = {
                        seccionSeleccionada = 2
                    },

                    icon = {
                        Icon(
                            imageVector = Icons.Default.CreditCard,
                            contentDescription = "Créditos"
                        )
                    },

                    label = {
                        Text("Créditos")
                    }
                )


                // -------------------------------
                // MÁS
                // -------------------------------

                NavigationBarItem(
                    selected = seccionSeleccionada == 3,

                    onClick = {
                        seccionSeleccionada = 3
                    },

                    icon = {
                        Icon(
                            imageVector = Icons.Default.MoreHoriz,
                            contentDescription = "Más"
                        )
                    },

                    label = {
                        Text("Más")
                    }
                )
            }
        }
    ) { paddingValues ->


        // ====================================================
        // CONTENIDO DINÁMICO
        // ====================================================

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            // Barra superior
            BarraSuperior(
                nombre = nombre,
                onCerrarSesion = onCerrarSesion
            )


            // ------------------------------------------------
            // WHEN PARA CAMBIAR EL CONTENIDO
            // ------------------------------------------------

            when (seccionSeleccionada) {

                // 0 = INICIO
                0 -> {
                    InicioScreen(nombre)
                }

                // 1 = CUENTAS
                1 -> {
                    CuentasScreen()
                }

                // 2 = CRÉDITOS
                2 -> {
                    CreditosScreen()
                }

                // 3 = MÁS
                3 -> {
                    MasScreen()
                }
            }
        }
    }
}


// ============================================================
// BARRA SUPERIOR
// ============================================================

@Composable
fun BarraSuperior(
    nombre: String,
    onCerrarSesion: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            ),

        horizontalArrangement = Arrangement.SpaceBetween,

        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Icono de perfil
            Box {

                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Perfil",
                    tint = Color.White,
                    modifier = Modifier.size(34.dp)
                )

                // Indicador
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .align(Alignment.TopEnd)
                        .clip(CircleShape)
                        .background(Color.Red)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column {

                Text(
                    text = "Banco Andino",
                    color = Color.White,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Hola, $nombre",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }


        TextButton(
            onClick = {
                onCerrarSesion()
            }
        ) {

            Text(
                text = "Cerrar sesión",
                color = Color.White
            )
        }
    }
}


// ============================================================
// INICIO
// ============================================================

@Composable
fun InicioScreen(
    nombre: String
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Bienvenido, $nombre",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(18.dp))


        // -----------------------------------------------
        // CUENTA DE AHORROS
        // -----------------------------------------------

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Cuenta de ahorros",
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "S/ 2,340.00",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }


        Spacer(modifier = Modifier.height(14.dp))


        // -----------------------------------------------
        // CRÉDITO VIGENTE
        // -----------------------------------------------

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Crédito vigente",
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "S/ 1,850.00",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


// ============================================================
// CUENTAS
// ============================================================

@Composable
fun CuentasScreen() {

    val movimientos = listOf(
        "Depósito" to "+ S/ 350.00",
        "Retiro cajero" to "- S/ 120.00",
        "Pago de servicio" to "- S/ 45.50",
        "Transferencia recibida" to "+ S/ 500.00"
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        // Saldo destacado

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(20.dp)
        ) {

            Text(
                text = "Cuenta de ahorros",
                color = Color.White,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "S/ 2,340.00",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }


        // Lista de movimientos

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            items(movimientos) { movimiento ->

                MovimientoItem(
                    descripcion = movimiento.first,
                    monto = movimiento.second
                )
            }
        }
    }
}


// ============================================================
// ITEM DE MOVIMIENTO
// ============================================================

@Composable
fun MovimientoItem(
    descripcion: String,
    monto: String
) {

    val esIngreso = monto.startsWith("+")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 15.dp
            ),

        horizontalArrangement = Arrangement.SpaceBetween,

        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = if (esIngreso) {
                    Icons.Default.ArrowDownward
                } else {
                    Icons.Default.ArrowUpward
                },

                contentDescription = descripcion,

                tint = if (esIngreso) {
                    Color(0xFF2E7D32)
                } else {
                    Color(0xFFC62828)
                }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = descripcion,
                fontSize = 15.sp
            )
        }


        Text(
            text = monto,
            fontWeight = FontWeight.Bold
        )
    }

    HorizontalDivider()
}


// ============================================================
// CRÉDITOS
// ============================================================

@Composable
fun CreditosScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Mis créditos",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(18.dp))


        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Crédito personal",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Saldo pendiente"
                )

                Text(
                    text = "S/ 1,850.00",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Próxima cuota: S/ 250.00"
                )

                Text(
                    text = "Vencimiento: 15 de septiembre"
                )
            }
        }


        Spacer(modifier = Modifier.height(15.dp))


        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Ver cronograma")
        }
    }
}


// ============================================================
// MÁS
// ============================================================

@Composable
fun MasScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Más opciones",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))


        OpcionMenu("Mi perfil")

        OpcionMenu("Configuración")

        OpcionMenu("Notificaciones")

        OpcionMenu("Ayuda")

        OpcionMenu("Términos y condiciones")
    }
}


// ============================================================
// OPCIÓN DEL MENÚ
// ============================================================

@Composable
fun OpcionMenu(
    texto: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {

        Text(
            text = texto,
            modifier = Modifier.padding(18.dp),
            fontSize = 16.sp
        )
    }
}