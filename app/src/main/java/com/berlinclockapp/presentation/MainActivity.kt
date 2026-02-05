package com.berlinclockapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.berlinclockapp.presentation.theme.ui.BerlinClockAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BerlinClockAppTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BerlinClockAppTheme {}
}