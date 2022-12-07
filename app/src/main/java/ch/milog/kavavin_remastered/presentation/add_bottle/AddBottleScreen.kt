package ch.milog.kavavin_remastered.presentation.add_bottle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ch.milog.kavavin_remastered.presentation.add_bottle.components.TopAppBarComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBottleScreen(viewModel: AddBottleViewModel, navController: NavController) {

    val name = viewModel.name.value

    Scaffold(
        topBar = {
            TopAppBarComponent(navController)
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = name.text ?: "",
                    label = { Text(text = name.hint) },
                    onValueChange = { viewModel.onEvent(AddBottleEvent.NameChanged(it)) })
            }
        }
    )
}