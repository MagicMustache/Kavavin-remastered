package ch.milog.kavavin_remastered.presentation.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ch.milog.kavavin_remastered.R
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.stevdzasan.onetap.rememberOneTapSignInState

@Composable
fun LoginScreen(onSucess: (token: String) -> Unit, onError: Unit) {
    val context = LocalContext.current
    val state = rememberOneTapSignInState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OneTapSignInWithGoogle(
            state = state,
            clientId = context.getString(R.string.gcp_id),
            onTokenIdReceived = { tokenId ->
                onSucess(tokenId)
            },
            onDialogDismissed = {
                onError
            }
        )
        Button(
            onClick = { state.open() },
            contentPadding = PaddingValues(15.dp),
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(10.dp, 0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.google_logo),
                        modifier = Modifier
                            .size(18.dp),
                        contentDescription = "drawable_icons",
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = context.getString(R.string.login),
                        fontSize = 16.sp,
                    )
                }
            }
        }
    }
}

