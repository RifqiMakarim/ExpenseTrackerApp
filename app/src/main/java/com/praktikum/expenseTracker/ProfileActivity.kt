package com.praktikum.expenseTracker

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.praktikum.expenseTracker.ui.theme.Week3Theme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nama = intent.getStringExtra("nama") ?: "nama tidak terdaftar"
        val nim = intent.getStringExtra("nim") ?: " nim tidak terdaftar"
        val jurusan = intent.getStringExtra("jurusan") ?: "Tidak terdaftar"
        val angkatan = intent.getStringExtra("angkatan") ?: "Tidak terdaftar"
        val deskripsiDiri = intent.getStringExtra("deskripsi diri") ?: "Tidak terdaftar"

        enableEdgeToEdge()
        setContent {
            Week3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfilePage(
                        nama, nim, jurusan, angkatan, deskripsiDiri,
                        modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ProfilePage (
    nama : String,
    nim : String,
    jurusan : String,
    angkatan : String,
    deskripsiDiri : String,
    modifier: Modifier = Modifier )
{
    Box (
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        val context = LocalContext.current

        Image(
            painter = painterResource(R.drawable.background2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp),
        ){
            Text(
                text = "Data Profil",
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.rifqi),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(135.dp))
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "$nim\n$nama\n $jurusan | $angkatan",
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .size(width = 300.dp, height = 170.dp)
            ) {
                Text(
                text = "Mahasiswa Informatika yang menyukai Pengembangan Perangkat Lunak. " +
                        "Menjelajahi seni dari coding untuk membangun Aplikasi yang Impactfully. " +
                        "Saya juga tertarik pada Keamanan Siber dan Machine Learning. " +
                        "Always learning, coding, and leveling up my skills. ",
                        
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(10.dp),
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                TextButton( onClick = {
                    (context as? ComponentActivity)?.finish()
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Text(
                        text = "Kembali",
                        modifier = Modifier
                            .padding(10.dp),
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer( modifier = Modifier.width(35.dp))

                TextButton( onClick = {
                    val shareintent = Intent(Intent.ACTION_SEND)
                    shareintent.type = "text/plain"
                    shareintent.putExtra(Intent.EXTRA_SUBJECT,"Data Profil Pengguna")
                    shareintent.putExtra(Intent.EXTRA_TEXT,
                        "Nama : $nama\nNIM : $nim\nJurusan : $jurusan  |  Angkatan : $angkatan\n" +
                                "Deskripsi Diri  : $deskripsiDiri")
                    context.startActivity(Intent.createChooser(shareintent,"Bagikan via"))
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(25.dp)

                ) {
                    Text(
                        text = "BAGIKAN",
                        modifier = Modifier
                            .padding(10.dp),
                        fontSize = 13.sp
                    )
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun CodingPreview() {
    Week3Theme {
        ProfilePage(
            nama = "Rifqi Makarim",
            nim = "L0123122",
            jurusan = "Informatika",
            angkatan = "2023",
            deskripsiDiri = "Mahasiswa Informatika yang menyukai Pengembangan Perangkat Lunak. Menjelajahi seni dari coding untuk membangun Aplikasi yang Impactfully. Saya juga tertarik pada Keamanan Siber dan Machine Learning. Always learning, coding, and leveling up my skills."
        )
    }
}