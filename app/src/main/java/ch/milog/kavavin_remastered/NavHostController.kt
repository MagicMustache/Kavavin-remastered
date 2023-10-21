package ch.milog.kavavin_remastered

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ch.milog.kavavin_remastered.presentation.add_bottle.AddBottleScreen
import ch.milog.kavavin_remastered.presentation.add_bottle.AddBottleViewModel
import ch.milog.kavavin_remastered.presentation.cellar.CellarScreen
import ch.milog.kavavin_remastered.presentation.cellar.CellarViewModel
import ch.milog.kavavin_remastered.presentation.signin.LoginScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun NavHostController(
    cellarViewModel: CellarViewModel,
    addBottleViewModel: AddBottleViewModel,
    auth: FirebaseAuth,
    context: Context
) {
    val navController = rememberNavController()
    NavHost(
        navController,
        startDestination = "cellar"
    ) {
        composable("login") { LoginScreen({ loginSuccess(it, auth, context, navController) }, loginFailure(context)) }
        composable("cellar") { CellarScreen(viewModel = cellarViewModel, navController) }
        composable("add") { AddBottleScreen(viewModel = addBottleViewModel, navController) }
    }
    if (auth.currentUser == null) {
        navController.navigate("login") {
            popUpTo("login")
        }
    }
}

private fun loginSuccess(token: String, auth: FirebaseAuth, context: Context, navController: NavController) {
    val firebaseCredential = GoogleAuthProvider.getCredential(token, null)
    auth.signInWithCredential(firebaseCredential)
        .addOnCompleteListener(context as MainActivity) { task ->
            if (task.isSuccessful) {
                navController.navigate("cellar") {
                    popUpTo("cellar")
                }
            } else {
                Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()
            }
        }
}

private fun loginFailure(context: Context) {
    Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()
}