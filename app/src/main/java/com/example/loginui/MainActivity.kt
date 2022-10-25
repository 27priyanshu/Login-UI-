package com.example.loginui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginui.ui.theme.LoginUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UI(applicationContext)
        }
    }
}
@Composable
fun UI(context: Context){


    var email by remember{ mutableStateOf("")}
    var password by remember { mutableStateOf(" ")}
    Column(
        modifier= Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text ="Login Here",
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Left,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange ={email=it},
            label = {Text("Enter your mail")},
            leadingIcon = {
                Icon(Icons.Default.Person , contentDescription = "person")
            },
            modifier= Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)

            )

        OutlinedTextField(
            value = password,
            onValueChange ={ password =it},
            label = {Text("Enter your password")},
            leadingIcon = {
                Icon(Icons.Default.Info , contentDescription = "password")
            },
            modifier= Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)


        )

        OutlinedButton(
            onClick = { logged(email,password,context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        ) {
            Text(
                text = "Login",
                textAlign = TextAlign.Center
            )

        }

    }
}

fun logged(email: String, password: String, context: Context) {
    if(email == "1234" && password== "1234"){
        Toast.makeText(context,"Logged In Successfully",Toast.LENGTH_LONG).show()
    }else{
        Toast.makeText(context, "Logged In Failed", Toast.LENGTH_LONG).show()

    }

}
