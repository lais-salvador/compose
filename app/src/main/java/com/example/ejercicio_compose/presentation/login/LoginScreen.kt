package com.example.ejercicio_compose.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicio_compose.R

@Composable
fun LoginScreen(
    onLoginSuccess:() -> Unit,
    onForgotPassword: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Img()
        Spacer(modifier = Modifier.height(10.dp))
        UserTextField()
        Spacer(modifier = Modifier.height(10.dp))
        PassTextField()
        Spacer(modifier = Modifier.height(10.dp))
        forgotPasswordLink(onForgotPassword)
        Spacer(modifier = Modifier.height(5.dp))
        LoginButton(onLoginSuccess)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserTextField(){
    var usuario by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = usuario,
        onValueChange = { usuario = it },
        label = { Text( "Usuario") },
        leadingIcon = {
            Image(
                painterResource(id = R.drawable.email),
                contentDescription = "",
                modifier = Modifier.alpha(0.5f)
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassTextField(){
    var pass by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = pass,
        onValueChange = { pass = it },
        label = { Text("Contraseña") },
        leadingIcon = {
            Image(
                painterResource(id = R.drawable.lock),
                contentDescription = "",
                modifier = Modifier.alpha(0.5f)
            )
        },
        trailingIcon = {
            Image(
                painterResource(id = R.drawable.eye),
                contentDescription = "",
                modifier = Modifier.alpha(0.5f)
            )
        }

    )
}

@Composable
fun LoginButton(onLoginSuccess: () -> Unit) =
    Button(
        onClick = onLoginSuccess
    ) {
        Text("Login")
    }


@Composable
fun Img() = Image(
        modifier = Modifier.size(100.dp),
        painter = painterResource(id = R.drawable.android),
        contentDescription = "My awesome image"
)

@Composable
fun forgotPasswordLink(onForgotPassword: () -> Unit) {
    Text(
        modifier = Modifier.clickable{onForgotPassword()},
        text = AnnotatedString("Se me ha olvidado la contraseña"),
    )
}



@Preview
@Composable
fun LoginPreview(){
    LoginScreen({}, {})
}