package bike.rapido.analytics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import android.view.Menu
import android.view.MenuItem
import bike.rapido.analytics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        // Fully Typed autocomplete example - better type safety & abstraction - no mention of any trackers in call site
        AnalyticsManager.sendSplashScreenEvent("Splash", 470068, "Mumbai")

        // Generic implementation - lacks type safety, more verbose , would need refactoring if we removed a tracker or added one
        AnalyticsManager.sendEvent(listOf(AnalyticTrackers.FIREBASE), "Splash", "value for splash")
    }
}