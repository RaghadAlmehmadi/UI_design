package com.example.ui_design

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun signUp(navController: NavController) {
    var textField1 by remember { mutableStateOf("") }
    var textField2 by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1E3A))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF13152C))
                .padding(30.dp)
        ) {
            Column(
                modifier = Modifier.padding(top = 64.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.wrapContentWidth(Alignment.Start)
                )
                Text(
                    text = stringResource(id = R.string.enter_details),
                    color = Color.Gray,
                    modifier = Modifier.wrapContentWidth(Alignment.Start)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF1A1E3A))
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFF1A1E3A))
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = stringResource(id = R.string.your_email),
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color.Gray
                )
                TextField(
                    value = textField1,
                    onValueChange = { textField1 = it },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp)),
                    textStyle = LocalTextStyle.current.copy(fontSize = 14.sp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFF2F3458),
                        focusedContainerColor = Color(0xFF2F3458),
                        disabledContainerColor = Color(0xFF2F3458)
                    )
                )

                Spacer(modifier = Modifier.height(12.dp)) // Slightly reduced space
                Text(
                    text = stringResource(id = R.string.password),
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color.Gray
                )
                TextField(
                    value = textField2,
                    onValueChange = { textField2 = it },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp)),
                    textStyle = LocalTextStyle.current.copy(fontSize = 14.sp),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image =
                            if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = image,
                                contentDescription = "Toggle password visibility"
                            )
                        }
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFF2F3458),
                        focusedContainerColor = Color(0xFF2F3458),
                        disabledContainerColor = Color(0xFF2F3458)
                    )

                )

                Spacer(modifier = Modifier.height(12.dp)) // Slightly reduced space

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth() // Ensures button is same width as TextField
                        .clip(RoundedCornerShape(12.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text(
                        text = stringResource(id = R.string.create_account),
                         color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(12.dp)) // Slightly reduced space

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it }
                    )
                    Text(
                        text = stringResource(id = R.string.agree_terms),
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(12.dp)) // Slightly reduced space

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.dont_have_account),
                        color = Color.Gray)
                    Spacer(modifier = Modifier.width(4.dp)) // Reduced space between texts
                    Text(
                        text = stringResource(id = R.string.log_in),

                        color = Color.Blue,
                        modifier = Modifier.clickable {
                            navController.navigate("login")
                        }
                    )
                }
            }
        }
    }
}
