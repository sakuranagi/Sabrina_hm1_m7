package mbk.io.sabrina_hm1_m7.ui.doors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mbk.io.sabrina_hm1_m7.app.App
import mbk.io.sabrina_hm1_m7.base.BaseFragment
import mbk.io.sabrina_hm1_m7.databinding.FragmentDoorBinding
import mbk.io.sabrina_hm1_m7.model.CameraEntity
import mbk.io.sabrina_hm1_m7.model.DoorEntity
import mbk.io.sabrina_hm1_m7.ui.doors.adapter.DoorAdapter

@AndroidEntryPoint
class DoorFragment : BaseFragment() {
    private lateinit var binding: FragmentDoorBinding
    private val viewModel: DoprViewModel by viewModels()
    private val adapter = DoorAdapter(true)
    private var list: List<DoorEntity> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCameras.adapter = adapter
        CoroutineScope(Dispatchers.IO).launch {
            list = App.db.doorDao().getAll()
            withContext(Dispatchers.Main) {
                if (list.isEmpty()) {
                    getData()
                } else {
                    adapter.submitList(list)
                    adapter.notifyDataSetChanged()
                }
            }
        }

        binding.swiperefresh.setOnRefreshListener {
            getData()
        }
    }

    fun getData() {
        viewModel.getCameras().stateHandler(
            success = { it ->
                val list = it.data
                CoroutineScope(Dispatchers.IO).launch {
                App.db.doorDao().clearAll()
                list.forEach {
                    val door = DoorEntity(
                        favorites = it.favorites,
                        name = it.name,
                        room = it.room,
                        snapshot = it.snapshot
                    )
                    CoroutineScope(Dispatchers.IO).launch {
                        App.db.doorDao().insertDoor(door)
                    }
                }
                    val listDB = App.db.doorDao().getAll()
                    withContext(Dispatchers.Main) {
                        adapter.submitList(listDB)
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        )
    }
}