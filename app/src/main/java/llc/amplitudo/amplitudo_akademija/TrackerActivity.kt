package llc.amplitudo.amplitudo_akademija

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import llc.amplitudo.amplitudo_akademija.databinding.ActivityTrackerBinding

class TrackerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrackerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTrackerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        /**
         * Changes color of status bar.
         */
        window.statusBarColor = ContextCompat.getColor(this@TrackerActivity, R.color.purple)
    }
}