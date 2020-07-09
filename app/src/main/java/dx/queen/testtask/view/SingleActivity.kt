package dx.queen.testtask.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dx.queen.testtask.R
import dx.queen.testtask.model.User

class SingleActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        navController = Navigation.findNavController(
            this,
            R.id.nav_host_fragment
        )
        navController.navigate(R.id.listFragment)

    }

    fun openDetailFragment(user: User) {
        val bundle = bundleOf("user" to user)
        navController.navigate(R.id.action_listFragment_to_detailFragment, bundle)
    }


}

