package ch.milog.kavavin_remastered.presentation.cellar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ch.milog.kavavin_remastered.presentation.cellar.components.BottleComponent
import ch.milog.kavavin_remastered.presentation.cellar.components.TopAppBarComponent
import ch.milog.kavavin_remastered.ui.theme.primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CellarScreen(viewModel: CellarViewModel) {

    val state = viewModel.state.value
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBarComponent()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = primary,
                shape = FloatingActionButtonDefaults.shape,
                elevation = FloatingActionButtonDefaults.elevation(),

                ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn {
                    items(state.bottles) { bottle ->
                        BottleComponent(bottle)
                    }
                }
            }

        }
    )
}