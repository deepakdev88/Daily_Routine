package com.example.dailyroutine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyroutine.ui.theme.DailyRoutineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyRoutineTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    RoutineApp()
                }
            }
        }
    }
}

@Composable
fun RoutinePresentation(modifier: Modifier = Modifier){
    var currentStep by remember { mutableStateOf(1) }
    val imageResources = when(currentStep){
        1 -> R.drawable.routine_1
        2 -> R.drawable.routine_2
        3 -> R.drawable.routine_3
        4 -> R.drawable.routine_4
        5 -> R.drawable.routine_5
        6 -> R.drawable.routine_6
        7 -> R.drawable.routine_7
        else -> R.drawable.routine_1
    }

    val titleText = when(currentStep){
        1 -> R.string.title_1
        2 -> R.string.title_2
        3 -> R.string.title_3
        4 -> R.string.title_4
        5 -> R.string.title_5
        6 -> R.string.title_6
        7 -> R.string.title_7
        else -> R.string.title_1
    }

    val tapText = when(currentStep){
        1 -> R.string.text_1
        2 -> R.string.text_2
        3 -> R.string.text_3
        4 -> R.string.text_4
        5 -> R.string.text_5
        6 -> R.string.text_6
        7 -> R.string.text_7
        else -> R.string.text_1
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF6200EE))
                .padding(vertical = 18.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.App_headerName),
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = Bold
            )
        }
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = titleText),
                fontSize = 20.sp,
                fontWeight = SemiBold,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(imageResources),
                contentDescription = stringResource(id = tapText),
                modifier = Modifier
                    .clickable {
                        currentStep = if (currentStep < 7) currentStep + 1 else 1
                    }
                    .size(250.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = tapText),
                fontSize = 16.sp,
            )
        }

    }



@Preview(showBackground = true)
@Composable
fun RoutineApp(){
    RoutinePresentation(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}
