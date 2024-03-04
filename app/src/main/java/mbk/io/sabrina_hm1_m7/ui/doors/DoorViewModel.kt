package mbk.io.sabrina_hm1_m7.ui.doors

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mbk.io.sabrina_hm1_m7.data.Repository
import mbk.io.sabrina_hm1_m7.data.Resource
import mbk.io.sabrina_hm1_m7.model.CameraModel
import mbk.io.sabrina_hm1_m7.model.DoorModel
import javax.inject.Inject

@HiltViewModel
class DoprViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getCameras(): LiveData<Resource<DoorModel>> = repository.getDoors()
}
