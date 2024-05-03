package com.example.bloodbank_compose.screens.AuthScreens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
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
import java.util.Timer
import kotlin.concurrent.schedule

@Composable
fun SignupScreen(navController: NavController,
                 viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){

    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }

    val password = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val repassword = remember { mutableStateOf("") }


    val isLoading = viewModel.isLoading

    var contest = LocalContext.current
    var loginErr = viewModel.loginErr

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




                OutlinedTextField(
                    value = name.value, onValueChange = {
                        name.value = it
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, color = Purple80),
                    placeholder = { Text(text = "Full name") },

                    )


                OutlinedTextField(
                    value = email.value, onValueChange = {
                        email.value = it
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, color = Purple80),
                    placeholder = { Text(text = "Email") },

                    )
                OutlinedTextField(
                    value = phone.value, onValueChange = {
                        phone.value = it
                    }, modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .border(1.dp, color = Purple80),

                    placeholder = { Text(text = "Phone number") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                    )

                OutlinedTextField(
                    value = password.value, onValueChange = {
                        password.value = it
                    }, modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .border(1.dp, color = Purple80),

                    placeholder = { Text(text = "Password") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                    )
                OutlinedTextField(
                    value = repassword.value, onValueChange = {
                        repassword.value = it
                    }, modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .border(1.dp, color = Purple80),

                    placeholder = { Text(text = "confirm Password") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                    )

                Spacer(modifier = Modifier.height(30.dp))
                CustomButton(text = "Login", onClick = {

Log.d("tag", "${password.value}/${repassword.value}")
                    if( name.value. isEmpty() or password.value.isEmpty() or  phone.value.isEmpty() or email.value.isEmpty()){
                        Toast.makeText(
                            contest,
                            "All field must be filled",
                            Toast.LENGTH_LONG
                        ).show()

                    } else if (password.value != repassword.value) {
                        Toast.makeText(
                            contest,
                            "password does not match",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    else {
                        viewModel.createUserWithEmailAndPassword(email = email.value, password.value, name.value, phone.value) {
                            navController.navigate(BloodbankScreens.AboutUs.name)
                        }
                    }

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

                if (loginErr.isNotEmpty()) {
                    Toast.makeText(contest, loginErr, Toast.LENGTH_SHORT).show()

                    Timer().schedule(5000) {
                        //do something
                        loginErr = ""
                    }
                }
            }

        }

    }
}