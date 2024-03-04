package mbk.io.sabrina_hm1_m7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import mbk.io.sabrina_hm1_m7.databinding.ActivityMainBinding
import mbk.io.sabrina_hm1_m7.ui.adapters.VPAdapter
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.viewPager.adapter = VPAdapter(
            supportFragmentManager,
            lifecycle
        )

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Cameras"
                else -> "Doors"
            }
        }.attach()
    }
}