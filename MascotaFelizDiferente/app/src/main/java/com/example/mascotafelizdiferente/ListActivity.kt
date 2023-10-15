package com.example.mascotafelizdiferente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mascotafelizdiferente.ui.theme.MascotaFelizDiferenteTheme

class ListActivity : ComponentActivity() {
    val datos : List<String> = listOf(
        "Razas",
        "Entrenamiento",
        "Alimentacion",
        "Belleza",
        "Reproduccion",
        "Salud",
        "Noticias"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MascotaFelizDiferenteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Pantalla(datos)
                }
            }
        }
    }
}

@Composable
fun Pantalla(datos: List<String>){
    LazyColumn(
        contentPadding = PaddingValues(all = 20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ){
        items(datos){
            item -> ListItemRow(item)
        }
    }
}

@Composable
fun ListItemRow(item : String){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.tertiary)
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ){
        Row(){
            Text(modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
                text = item,
                style = MaterialTheme.typography.bodyMedium
            )
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Más ...")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPreview(){
    val datos : List<String> = listOf(
        "Razas",
        "Entrenamiento",
        "Alimentacion",
        "Belleza",
        "Reproduccion",
        "Salud",
        "Noticias"
    )

    MascotaFelizDiferenteTheme {
        Pantalla(datos)
    }
}

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MascotaFelizDiferenteTheme {
        Greeting("Android")
    }
}*/