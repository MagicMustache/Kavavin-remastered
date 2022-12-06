package ch.milog.kavavin_remastered.presentation.add_bottle

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import ch.milog.kavavin_remastered.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent() {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.addBottle))
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White,
        ),
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
            }
        }
    )
}