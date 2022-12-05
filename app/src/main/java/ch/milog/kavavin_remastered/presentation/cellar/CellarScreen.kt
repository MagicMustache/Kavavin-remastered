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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import ch.milog.kavavin_remastered.R
import ch.milog.kavavin_remastered.presentation.cellar.components.BottleComponent
import ch.milog.kavavin_remastered.presentation.cellar.components.TopAppBarComponent
import ch.milog.kavavin_remastered.ui.theme.primary
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CellarScreen(viewModel: CellarViewModel) {

    val state = viewModel.state.value
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    var refreshing by remember { mutableStateOf(false) }

    LaunchedEffect(refreshing) {
        if (refreshing) {
            //too quick without delay, can't see the refresh animation
            delay(500)
            viewModel.onEvent(CellarEvent.Refresh(state.cellarOrder))
            refreshing = false
        }
    }

    Scaffold(
        topBar = {
            TopAppBarComponent(viewModel)
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
                if (state.bottles.isEmpty()) {
                    Text(text = stringResource(id = R.string.no_bottles))
                } else {
                    SwipeRefresh(
                        state = rememberSwipeRefreshState(isRefreshing = refreshing),
                        onRefresh = { refreshing = true }) {
                        LazyColumn(
                            modifier = Modifier
                                .padding(8.dp, 0.dp)
                                .fillMaxSize()
                        ) {
                            items(state.bottles) { bottle ->
                                BottleComponent(bottle)
                                Divider()
                            }
                        }
                    }
                }
            }
        }
    )
}