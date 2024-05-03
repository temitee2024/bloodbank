package com.example.bloodbank_compose.screens.AuthScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bloodbank_compose.R
import com.example.bloodbank_compose.components.CustomButton
import com.example.bloodbank_compose.navigation.BloodbankScreens
import com.example.bloodbank_compose.ui.theme.Purple80

@Composable
fun SignupScreen(navController: NavController){
    Column(
        modifier = Modifier
    ) {
//        //LOGO

        Image(painter = painterResource(id = R.drawable.bloodbank_img), contentDescription = "",
            modifier =  Modifier.align(Alignment.CenterHorizontally))
        Text(
            text = "Please sign up to continue.",
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
                val textState = remember { mutableStateOf(TextFieldValue()) }



                OutlinedTextField(
                    value = textState.value, onValueChange = {
                        textState.value = it
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, color = Purple80),
                    placeholder = { Text(text = "Full name") },

                    )


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

                    placeholder = { Text(text = "Phone number") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

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
                OutlinedTextField(
                    value = textState.value, onValueChange = {
                        textState.value = it
                    }, modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .border(1.dp, color = Purple80),

                    placeholder = { Text(text = "confirm Password") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                    )

                Spacer(modifier = Modifier.height(30.dp))
                CustomButton(text = "Login", onClick = {

                    navController.navigate(BloodbankScreens.AboutUs.name)
                })
                Spacer(modifier = Modifier.height(30.dp))


                Text(
                    text = "Already have an account ? LOGIN",
                    modifier = Modifier.padding(horizontal = 20.dp).fillMaxWidth()
                        .clickable {
                            navController.navigate(BloodbankScreens.LoginScreen.name)
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

    }
}