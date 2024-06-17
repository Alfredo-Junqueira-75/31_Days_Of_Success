package com.junqueira.a31daysofsucess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.junqueira.a31daysofsucess.ui.theme._31DaysOfSucessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _31DaysOfSucessTheme {
                DaysOfSuccessApp()
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaysOfSuccessTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Text(stringResource(R.string.app_name))
    }, modifier = modifier
    )
}

@Composable
fun DaysOfSuccessApp() {
    Scaffold(
        topBar = {
            DaysOfSuccessTopAppBar()
        }
    ) {
        QuoteCardList(
            modifier = Modifier.padding(it)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DaysOfSuccessAppPreview() {
    _31DaysOfSucessTheme {
        DaysOfSuccessApp()
    }
}