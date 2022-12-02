package ch.milog.kavavin_remastered

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ch.milog.kavavin_remastered.presentation.cellar.CellarScreen
import ch.milog.kavavin_remastered.presentation.cellar.CellarViewModel
import ch.milog.kavavin_remastered.presentation.signin.LoginScreen
import ch.milog.kavavin_remastered.ui.theme.KavavinRemasteredTheme
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val cellarViewModel: CellarViewModel by inject()
    private val auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentUser = auth.currentUser
        if (currentUser == null) {
            setContent {
                KavavinRemasteredTheme {
                    LoginScreen({ loginSuccess(it) }, loginFailure())
                }
            }
        } else {
            setContent {
                KavavinRemasteredTheme {
                    CellarScreen(cellarViewModel)
                }
            }
        }
    }

    private fun loginSuccess(token: String) {
        val firebaseCredential = GoogleAuthProvider.getCredential(token, null)
        auth.signInWithCredential(firebaseCredential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    setContent {
                        KavavinRemasteredTheme {
                            CellarScreen(cellarViewModel)
                        }
                    }
                } else {
                    Log.d("login", "fail")
                }
            }
    }

    private fun loginFailure() {
        Log.d("login", "fail2")
    }

}
