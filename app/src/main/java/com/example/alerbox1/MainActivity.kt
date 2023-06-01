package com.example.alerbox1

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.alerbox1.ui.theme.AlerBox1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlerBox1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainPage();
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlerBox1Theme {
        Greeting("Android")
    }
}

@Composable
fun mainPage() {
    val openDialog1 = remember {
        mutableStateOf(true)
    }
    val openDialog2 = remember {
        mutableStateOf(true)
    }

    var res by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            res="You Clicked ONE"
            openDialog1.value = true }) {
            Text(text = "One")
        }

        Button(onClick = {
            res="You Clicked TWO"
            openDialog2.value = true }) {
            Text(text = "Two")
        }
        Text(text = res)
    }

    if (openDialog1.value) {
        AlertDialog(
            onDismissRequest = { openDialog1.value = false },
            confirmButton = {
                TextButton(onClick = {
                    openDialog1.value = false
                    Toast.makeText(context, "ONE", Toast.LENGTH_LONG)
                        .show()
                }) {
                    Text(text = "ONE")
                }
            },
//            dismissButton = {
//                TextButton(onClick = { openDialog1.value = false }) {
//                    Text(text = "Cancel")
//                }
//            },


            title = { Text(text = "One") },
            text = { Text(text = "This is for One") }
        )
    }

    if (openDialog2.value) {
        AlertDialog(
            onDismissRequest = { openDialog2.value = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog2.value = false
                        Toast.makeText(context, "You pressed One", Toast.LENGTH_LONG).show()
                    }) {

                    Text(text = "ONE")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    openDialog2.value = false
                    Toast.makeText(
                        context, "You pressed Two", Toast
                            .LENGTH_LONG
                    ).show()
                }) {
                    Text(text = "Two")
                }
            },
            title = { Text(text = "Two") },
            text = { Text(text = "This is for Two") }
        )
    }

}

