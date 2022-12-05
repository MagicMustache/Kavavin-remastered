package ch.milog.kavavin_remastered.presentation.cellar.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ch.milog.kavavin_remastered.R
import ch.milog.kavavin_remastered.domain.utils.CellarOrder
import ch.milog.kavavin_remastered.domain.utils.OrderType
import ch.milog.kavavin_remastered.presentation.cellar.CellarEvent
import ch.milog.kavavin_remastered.presentation.cellar.CellarViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(viewModel: CellarViewModel) {

    var sortExpanded by remember { mutableStateOf(false) }
    var filterExpanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.myCellar))
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White,
        ),
        actions = {
            Box {
                IconButton(onClick = { sortExpanded = true }) {
                    Icon(
                        imageVector = Icons.Default.Sort,
                        contentDescription = stringResource(id = R.string.sortDescription),
                        tint = Color.White
                    )
                    DropdownMenu(expanded = sortExpanded, onDismissRequest = { sortExpanded = false }) {
                        DropdownMenuItem(
                            onClick = {
                                sortExpanded = false
                                viewModel.onEvent(
                                    CellarEvent.OrderChanged(
                                        CellarOrder.compareAndReverse(
                                            viewModel.state.value.cellarOrder,
                                            CellarOrder.Name(OrderType.Ascending),
                                            viewModel.state.value.cellarOrder.orderType
                                        )
                                    )
                                )
                            },
                            text = { Text(text = stringResource(id = R.string.sortName)) })
                        DropdownMenuItem(
                            onClick = {
                                sortExpanded = false
                                viewModel.onEvent(
                                    CellarEvent.OrderChanged(
                                        CellarOrder.compareAndReverse(
                                            viewModel.state.value.cellarOrder,
                                            CellarOrder.Year(OrderType.Descending),
                                            viewModel.state.value.cellarOrder.orderType
                                        )
                                    )
                                )
                            },
                            text = { Text(text = stringResource(id = R.string.sortYear)) })
                        DropdownMenuItem(
                            onClick = {
                                sortExpanded = false
                                viewModel.onEvent(
                                    CellarEvent.OrderChanged(
                                        CellarOrder.compareAndReverse(
                                            viewModel.state.value.cellarOrder,
                                            CellarOrder.Quantity(OrderType.Descending),
                                            viewModel.state.value.cellarOrder.orderType
                                        )
                                    )
                                )
                            },
                            text = { Text(text = stringResource(id = R.string.sortQuantity)) })
                    }
                }
            }

            IconButton(onClick = { filterExpanded = true }) {
                Box {
                    Icon(
                        imageVector = Icons.Default.FilterAlt,
                        contentDescription = stringResource(id = R.string.filterDescription),
                        tint = Color.White
                    )
                    DropdownMenu(expanded = filterExpanded, onDismissRequest = { filterExpanded = false }) {
                        DropdownMenuItem(
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.all_bottles_small),
                                    contentDescription = "all bottles",
                                    tint = Color.Unspecified
                                )
                            },
                            text = { Text(text = stringResource(id = R.string.all)) },
                            onClick = {
                                filterExpanded = false
                                viewModel.onEvent(CellarEvent.FilteredBottles(viewModel.state.value.cellarOrder, null))
                            })
                        DropdownMenuItem(
                            leadingIcon = {
                                Icon(
                                    painterResource(id = R.drawable.wine_bottle),
                                    contentDescription = "red wine",
                                    tint = Color.Unspecified
                                )
                            },
                            text = { Text(text = stringResource(id = R.string.redWine)) },
                            onClick = {
                                filterExpanded = false
                                viewModel.onEvent(CellarEvent.FilteredBottles(viewModel.state.value.cellarOrder, 1L))
                            })
                        DropdownMenuItem(
                            leadingIcon = {
                                Icon(
                                    painterResource(id = R.drawable.wine_bottle_white),
                                    contentDescription = "white wine",
                                    tint = Color.Unspecified
                                )
                            },
                            text = { Text(text = stringResource(id = R.string.whiteWine)) },
                            onClick = {
                                filterExpanded = false
                                viewModel.onEvent(CellarEvent.FilteredBottles(viewModel.state.value.cellarOrder, 2L))
                            })
                        DropdownMenuItem(
                            leadingIcon = {
                                Icon(
                                    painterResource(id = R.drawable.champagne_bottle),
                                    contentDescription = "champagne",
                                    tint = Color.Unspecified
                                )
                            },
                            text = { Text(text = stringResource(id = R.string.champagne)) },
                            onClick = {
                                filterExpanded = false
                                viewModel.onEvent(CellarEvent.FilteredBottles(viewModel.state.value.cellarOrder, 3L))
                            })
                        DropdownMenuItem(
                            leadingIcon = {
                                Icon(
                                    painterResource(id = R.drawable.wine_bottle_other),
                                    contentDescription = "other",
                                    tint = Color.Unspecified
                                )
                            },
                            text = { Text(text = stringResource(id = R.string.miscWine)) },
                            onClick = {
                                filterExpanded = false
                                viewModel.onEvent(CellarEvent.FilteredBottles(viewModel.state.value.cellarOrder, 4L))
                            })
                    }
                }
            }
            IconButton(onClick = {
                Toast.makeText(context, "Not yet implemented ;)", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.searchDescription),
                    tint = Color.White
                )
            }
        }
    )
}