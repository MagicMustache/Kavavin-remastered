package ch.milog.kavavin_remastered.presentation.signin

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import ch.milog.kavavin_remastered.R
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.stevdzasan.onetap.rememberOneTapSignInState

@Composable
fun LoginScreen(onSucess:(token:String)-> Unit, onError:  Unit) {
    val context = LocalContext.current
    val state = rememberOneTapSignInState()
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
    Button(onClick = { state.open() }) {
        Text(text = "Sign in")
    }
}

