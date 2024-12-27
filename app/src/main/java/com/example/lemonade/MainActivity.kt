package com.example.lemonade

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                    LemonadeApp(

                    )
                }
            }
        }
    }

@Preview
@Composable
fun LemonadeApp() {
    LemonadeButtonAndImage(modifier=Modifier.fillMaxSize().wrapContentSize(Alignment.Center))

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeButtonAndImage(modifier:Modifier=Modifier) {

    // Current step the app is displaying (remember allows the state to be retained
    // across recompositions).
    var currentStep by remember { mutableStateOf(1) }
    var squeesecount by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade Game",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = stringResource(R.string.Lemon_tree))
                        Spacer(modifier = Modifier.height(32.dp))
                        Box(
                            modifier=Modifier.size(200.dp).background(Color.Gray)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.lemon_tree),
                                contentDescription = stringResource(R.string.Lemon_tree),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .clickable {
                                        currentStep = 2
                                        squeesecount = (2..4).random()

                                    }
                            )
                        }
                    }
                }

                2 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = stringResource(R.string.Lemon))
                        Spacer(
                            modifier = Modifier.height(
                                32
                                    .dp
                            )
                        )
                        Box(
                            modifier=Modifier.size(200.dp).background(Color.Gray)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.lemon_squeeze),
                                contentDescription = stringResource(R.string.lemon_content_description),
                                modifier = Modifier.wrapContentSize().clickable {
                                    squeesecount--
                                    if (squeesecount == 0) {
                                        currentStep = 3
                                    }
                                }
                            )
                        }
                    }
                }

                3 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = stringResource(R.string.Glass_of_lemonade))
                        Spacer(
                            modifier = Modifier.height(
                                32
                                    .dp
                            )
                        )
                        Box(
                            modifier=Modifier.size(200.dp).background(Color.Gray)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.lemon_drink),
                                contentDescription = stringResource(R.string.lemonade_content_description),
                                modifier = Modifier.wrapContentSize().clickable {
                                    currentStep = 4

                                }
                            )
                        }
                    }
                }

                4 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = stringResource(R.string.Empty_glass))
                        Spacer(
                            modifier = Modifier.height(
                                32
                                    .dp
                            )
                        )
                        Box(
                            modifier=Modifier.size(200.dp).background(Color.Gray)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.lemon_restart),
                                contentDescription = stringResource(R.string.empty_glass_content_description),
                                modifier = Modifier.wrapContentSize().clickable {
                                    currentStep = 1
                                }
                            )
                        }
                    }
                }

            }
        }
    }
}




