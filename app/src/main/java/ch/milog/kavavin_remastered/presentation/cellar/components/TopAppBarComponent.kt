package ch.milog.kavavin_remastered.presentation.cellar.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sort
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
            Text(text = stringResource(id = R.string.myCellar))
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White,
        ),
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Sort,
                    contentDescription = stringResource(id = R.string.sortDescription),
                    tint = Color.White
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.FilterAlt,
                    contentDescription = stringResource(id = R.string.filterDescription),
                    tint = Color.White
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.searchDescription),
                    tint = Color.White
                )
            }
        }
    )
}