package ch.milog.kavavin_remastered.presentation.cellar.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ch.milog.kavavin_remastered.domain.model.Bottle

@Composable
fun BottleComponent(bottle: Bottle) {
    Box(modifier = Modifier.padding(8.dp)) {
        Row(modifier = Modifier.fillMaxSize()) {
            Text(text = bottle.name ?: "N/A")
        }
    }
}
