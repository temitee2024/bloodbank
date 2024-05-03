package com.example.bloodbank_compose.screens

import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bloodbank_compose.R
import com.example.bloodbank_compose.components.CustomButton
import com.example.bloodbank_compose.components.InputText
import com.example.bloodbank_compose.navigation.BloodbankScreens
import com.example.bloodbank_compose.ui.theme.Purple80
import java.lang.Math.cos
import kotlin.math.PI
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun LoginScreen(navController: NavController){

    val textState = remember { mutableStateOf(TextFieldValue()) }
    Column(
        modifier = Modifier
    ) {
//        //LOGO

        Image(painter = painterResource(id = R.drawable.bloodbank_img), contentDescription = "",
            modifier =  Modifier.align(Alignment.CenterHorizontally))
        Text(
            text = "Welcome back, Please login to continue.",
            modifier = Modifier.padding(horizontal = 20.dp).fillMaxWidth(),
            style = TextStyle(
                textAlign = TextAlign.Center,
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )

        )

        //CARDVIEW
        Card(
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(16.dp)
            ) {


                OutlinedTextField(
                    value = textState.value, onValueChange = {
                        textState.value = it
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, color = Purple80),
                    placeholder = { Text(text = "Email") },

                )

                OutlinedTextField(
                    value = textState.value, onValueChange = {
                        textState.value = it
                    }, modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .border(1.dp, color = Purple80),

                    placeholder = { Text(text = "Password") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    
                )
                Spacer(modifier = Modifier.height(30.dp))
                CustomButton(text = "Login", onClick = {
                    navController.navigate(BloodbankScreens.AboutUs.name)
                })
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Create an account",
                    modifier = Modifier.padding(horizontal = 20.dp).fillMaxWidth()
                        .clickable {
                            navController.navigate(BloodbankScreens.SignupScreen.name)
                        },
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )

                )

            }

        }



    } }