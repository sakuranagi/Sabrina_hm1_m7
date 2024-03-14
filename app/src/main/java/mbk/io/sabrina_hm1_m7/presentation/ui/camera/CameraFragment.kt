package mbk.io.sabrina_hm1_m7.presentation.ui.camera

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mbk.io.sabrina_hm1_m7.app.App
import mbk.io.sabrina_hm1_m7.base.BaseFragment
import mbk.io.sabrina_hm1_m7.databinding.FragmentCameraBinding
import mbk.io.sabrina_hm1_m7.data.local.models.CameraEntity
import mbk.io.sabrina_hm1_m7.presentation.ui.camera.adapter.CameraAdapter

@AndroidEntryPoint
class CameraFragment : BaseFragment() {

    private lateinit var binding: FragmentCameraBinding
    private val viewModel: CameraViewModel by viewModels()
    private val adapter = CameraAdapter(false)
    private var list: List<CameraEntity> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCameraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCameras.adapter = adapter
        CoroutineScope(Dispatchers.IO).launch {
            list = viewModel.getDBCameras()
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
                val list = it.data.cameras
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.clearAll()
                    list.forEach {
                        val camera = CameraEntity(
                            favorites = it.favorites,
                            name = it.name,
                            rec = it.rec,
                            room = it.room,
                            snapshot = it.snapshot
                        )
                       viewModel.insertCamera(camera)
                    }
                    withContext(Dispatchers.Main) {
                        val listDB = viewModel.getDBCameras()
                        adapter.submitList(listDB)
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        )
    }
}