package gt.edu.galileo.red.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import gt.edu.galileo.red.R
import gt.edu.galileo.red.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configuracionDrawer()
    }

    fun configuracionDrawer() {
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setTitleTextColor(Color.WHITE)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navView.setupWithNavController(navController)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.app_name, R.string.app_name);
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.drawerArrowDrawable.setColor(resources.getColor(R.color.white))
        binding.navView.setNavigationItemSelectedListener(this)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        Toast.makeText(binding.root.context, "Entro al click", Toast.LENGTH_SHORT).show()
        val navController = navHostFragment.navController
        if (item.itemId == R.id.menu_op_ingreso) {
            navController.navigate(R.id.ingresoFragment)
            Toast.makeText(binding.root.context, "Ingreso", Toast.LENGTH_SHORT).show()
        } else if (item.itemId == R.id.menu_op_listado) {
            navController.navigate(R.id.listadoFragment)
            Toast.makeText(binding.root.context, "Listado", Toast.LENGTH_SHORT).show()
        }
        binding.drawerLayout.closeDrawers()
        return true
    }
}