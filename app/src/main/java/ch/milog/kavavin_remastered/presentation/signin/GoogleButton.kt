package ch.milog.kavavin_remastered.presentation.signin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults.shape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ch.milog.kavavin_remastered.R
import ch.milog.kavavin_remastered.ui.theme.backgroundColor

@Composable
fun GoogleButton(onClick: () -> Unit) {
    Surface(
        modifier = Modifier.clickable(
            onClick = onClick
        ),
        shape = shape,
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onSurface),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.champagne_bottle),
                contentDescription = "SignInButton",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Sign in with Google",
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}