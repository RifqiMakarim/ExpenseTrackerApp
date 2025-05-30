package com.praktikum.expenseTracker

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.praktikum.expenseTracker.ui.theme.Week3Theme
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Homepage( modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Homepage( modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.TopCenter
    ) {

        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ){
            Text(
                text = "RupiahKu",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.displayMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.catatuang_logo),
                contentDescription = null,
                modifier = Modifier.size(300.dp)
            )

            Text(
                text = "Aplikasi untuk kebutuhan mencatat pengeluaran uang untuk kebutuhan sehari-harimu",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(30.dp))
            
            TextButton(onClick = {
                val intent = Intent(context,ProfileActivity::class.java)
                intent.putExtra("nama","Rifqi Makarim")
                intent.putExtra("nim","L0123122")
                intent.putExtra("jurusan","Informatika")
                intent.putExtra("angkatan","2023")
                intent.putExtra("deskripsi diri",
                    "Mahasiswa Informatika yang menyukai Pengembangan Perangkat Lunak." +
                            " Menjelajahi seni dari coding untuk membangun Aplikasi yang Impactfully. " +
                            "Saya juga tertarik pada Keamanan Siber dan Machine Learning." +
                            " Always learning, coding, and leveling up my skills. ")
                context.startActivity(intent) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary ),
                shape = RoundedCornerShape(15.dp)
            )
                { Text( text = "Go To Profile Page", modifier = Modifier
                    .padding(12.dp), fontWeight = FontWeight.Bold )
            }

            Spacer(modifier = Modifier.height(30.dp))

            TextButton(onClick = {
                val intent = Intent(context,HistoryActivity::class.java)
                context.startActivity(intent)
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary ),
                shape = RoundedCornerShape(15.dp)
            )
            { Text( text = "Go To Excel Tracker",
                modifier = Modifier
                .padding(12.dp), fontWeight = FontWeight.Bold,
                )
            }

            Spacer(modifier = Modifier.height(30.dp))


            TextButton(onClick = {

                val intent = Intent(Intent.ACTION_VIEW, "https://github.com/RifqiMakarim".toUri())
                context.startActivity(intent) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary ),
                shape = RoundedCornerShape(15.dp)
            )
            { Text( text = "Go To My Github", modifier = Modifier
                .padding(12.dp), fontWeight = FontWeight.Bold )
            }
        }
    }
}



@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun LightPreview() {
    Week3Theme {
        Homepage()
    } 
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Darkpreview() {
    Week3Theme {
        Homepage()
    }
}