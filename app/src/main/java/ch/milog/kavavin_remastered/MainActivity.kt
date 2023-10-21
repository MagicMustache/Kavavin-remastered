package ch.milog.kavavin_remastered

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ch.milog.kavavin_remastered.presentation.add_bottle.AddBottleViewModel
import ch.milog.kavavin_remastered.presentation.cellar.CellarViewModel
import ch.milog.kavavin_remastered.ui.theme.KavavinRemasteredTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val cellarViewModel: CellarViewModel by inject()
    private val addBottleViewModel: AddBottleViewModel by inject()
    private val auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KavavinRemasteredTheme {
                NavHostController(cellarViewModel, addBottleViewModel, auth, this)
            }
        }
    }


}
