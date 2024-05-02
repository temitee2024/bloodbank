package com.example.bloodbank_compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bloodbank_compose.R
import com.example.bloodbank_compose.navigation.BottomNavigation

@Composable
fun AboutUsScreen(navController: NavController) {
    val state = rememberScrollState()
    Scaffold(
        bottomBar = { BottomNavigation(navController) },
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxHeight()
                .fillMaxWidth()
                .verticalScroll(state)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(bottomStartPercent = 9, bottomEndPercent = 9)

                )
        ) {


            Image(
                painter = painterResource(id = R.drawable.bloodbank_img), contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(150.dp)
                    .padding(top = 20.dp)
            )

            Card (  modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)){
                Text(
                    text = "About Us", style = TextStyle(
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center

                    ),
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp)

                )

                Column(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
                ) {
                    Text(text = "At BloodBank Name, we understand the critical importance of blood donation in saving lives. Established with a commitment to excellence and compassion, we are a leading blood bank dedicated to ensuring a safe and sustainable blood supply for healthcare facilities and patients in need.")

                    Text("Our mission is simple yet profound: to bridge the gap between blood donors and recipients, empowering communities to come together and make a difference. With a relentless focus on innovation, quality, and integrity, we strive to set the highest standards in blood banking.")



                }
            }

  Card(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
            ){
      Column(
          modifier = Modifier.padding(20.dp)
      ) {
          Text(text = "Get Involved",style = TextStyle(
              color = Color.Red,
              fontWeight = FontWeight.Bold,
              fontSize = 20.sp,
              textAlign = TextAlign.Center

          ),   modifier = Modifier
              .fillMaxWidth()
              .padding(10.dp))
          Text("Whether you're an individual looking to donate blood, a healthcare provider in need of blood products, or a community organization interested in partnering with us, we welcome you to join us in our lifesaving mission. Together, we can make a meaningful difference in the lives of patients and their families.\n" +
                  "\n" +
                  "Thank you for considering [BloodBank Name] for your blood banking needs. Your support truly makes a difference.")
      }

  }

        }


    }
}