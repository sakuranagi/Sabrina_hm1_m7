package mbk.io.sabrina_hm1_m7.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mbk.io.sabrina_hm1_m7.ui.camera.CameraFragment
import mbk.io.sabrina_hm1_m7.ui.doors.DoorFragment

class VPAdapter (
    private val fragmentManager: FragmentManager,
    private val lifecycle: Lifecycle
    ) : FragmentStateAdapter(fragmentManager, lifecycle)
    {
        private val fragments = listOf(
            CameraFragment(), DoorFragment()
        )

        override fun getItemCount() = fragments.size

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> CameraFragment()
                1 -> DoorFragment()
                else -> CameraFragment()
            }
        }
    }