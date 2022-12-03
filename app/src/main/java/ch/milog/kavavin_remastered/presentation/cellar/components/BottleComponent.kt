package ch.milog.kavavin_remastered.presentation.cellar.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ch.milog.kavavin_remastered.R
import ch.milog.kavavin_remastered.domain.model.Bottle

@Composable
fun BottleComponent(bottle: Bottle) {
    var painter = painterResource(id = R.drawable.wine_bottle)
    when (bottle.type) {
        1L -> painter = painterResource(id = R.drawable.wine_bottle)
        2L -> painter = painterResource(id = R.drawable.wine_bottle_white)
        3L -> painter = painterResource(id = R.drawable.champagne_bottle)
        4L -> painter = painterResource(id = R.drawable.wine_bottle_other)
    }
    Box(
        modifier = Modifier
            .padding(8.dp)
            .height(75.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "${bottle.quantity}x", modifier = Modifier.padding(start = 8.dp))
            Image(
                painter = painter,
                contentDescription = stringResource(id = R.string.bottle_image_description),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .scale(1.7f)
            )
            Text(
                text = stringResource(id = R.string.bottle_name, bottle.name, bottle.year ?: "n/a"),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}
