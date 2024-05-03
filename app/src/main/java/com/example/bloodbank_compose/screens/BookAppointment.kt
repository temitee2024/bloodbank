package com.example.bloodbank_compose.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bloodbank_compose.components.CustomButton
import com.example.bloodbank_compose.navigation.BloodbankScreens
import com.example.bloodbank_compose.navigation.BottomNavigation
import com.example.bloodbank_compose.ui.theme.Purple80
import com.example.bloodbank_compose.util.DateUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(navController: NavController){

    val textState = remember { mutableStateOf(TextFieldValue()) }
    val state = rememberScrollState()
    val showDateDialog = remember { mutableStateOf(false) }
    val dateState = rememberDatePickerState()
    val date = remember { mutableStateOf("") }
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

                ), verticalArrangement = Arrangement.Center){
            Card( modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
                Column (  modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)){
                    Text(text = "Booking An Appointment" ,style = TextStyle(
                            color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center

                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp))

                    OutlinedTextField(
                        value = textState.value, onValueChange = {
                            textState.value = it
                        }, modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                            .border(1.dp, color = Purple80),

                        placeholder = { Text(text = "Name") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                        )
                    OutlinedTextField(
                        value = textState.value, onValueChange = {
                            textState.value = it
                        }, modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                            .border(1.dp, color = Purple80),

                        placeholder = { Text(text = "Email") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                        )
                    OutlinedTextField(
                        value = textState.value, onValueChange = {
                            textState.value = it
                        }, modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                            .border(1.dp, color = Purple80),

                        placeholder = { Text(text = "Phome number") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                        )
                    
                    Text(text = "DAte", modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .border(1.dp, color = Purple80)
                        .clickable { showDateDialog.value = true },)
                    OutlinedTextField(
                        value = textState.value, onValueChange = {
                            textState.value = it
                        }, modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                            .border(1.dp, color = Purple80)
                            .clickable { showDateDialog.value = true },

                        placeholder = { Text(text = "Date") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                        )

                    
                    Spacer(modifier = Modifier.height(30.dp))
                    CustomButton(text = "Submit", onClick = {
                        navController.navigate(BloodbankScreens.AboutUs.name)
                    })

                    DatePickerWithDialog(modifier = Modifier,showDateDialog, dateState) { date.value = it }
                }
            }

                }


    }}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerWithDialog(
    modifier: Modifier = Modifier,
    showDateDialog: MutableState<Boolean>,
    dateState: DatePickerState,
    onChange: (newDate: String) -> Unit = {}
) {
//    val dateState = rememberDatePickerState()


    @RequiresApi(Build.VERSION_CODES.O)
    fun dateStateToString(dates: DatePickerState): String {
        val millisToLocalDate = dates.selectedDateMillis?.let {
            DateUtils().convertMillisToLocalDate(it)
        }
        val dateToString = millisToLocalDate?.let {
            DateUtils().dateToString(millisToLocalDate)
        } ?: "Choose Date"

        Log.d("date", dateToString)
        return dateToString
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showDateDialog.value) {
            DatePickerDialog(
                onDismissRequest = { showDateDialog.value = false },
                confirmButton = {
                    Button(
                        onClick = {
                            onChange(dateStateToString(dateState))
                            showDateDialog.value = false

                        }
                    ) {
                        Text(text = "OK")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = { showDateDialog.value = false }
                    ) {
                        Text(text = "Cancel")
                    }
                }
            ) {
                DatePicker(
                    state =  dateState,
                    showModeToggle = true
                )
            }
        }
    }
}