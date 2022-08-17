package com.github.jhamin0511.mystudy.ui.bottomnavigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.ActivityBottomInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomInActivity : AppCompatActivity() {
    companion object {
        fun start(context: Context): Intent {
            return Intent(context, BottomInActivity::class.java).apply {
            }
        }
    }

    private lateinit var binding: ActivityBottomInBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_bottom_in)
        binding.lifecycleOwner = this

        val hostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = hostFragment.findNavController()
        binding.bottomNavigation.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.jetpackFragment,
                R.id.libraryFragment,
                R.id.customFragment,
                R.id.uiUxFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }
}
