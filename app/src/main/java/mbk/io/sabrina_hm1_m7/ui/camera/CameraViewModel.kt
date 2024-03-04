package mbk.io.sabrina_hm1_m7.ui.camera

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mbk.io.sabrina_hm1_m7.data.Repository
import mbk.io.sabrina_hm1_m7.data.Resource
import mbk.io.sabrina_hm1_m7.model.CameraModel
import javax.inject.Inject


@HiltViewModel
class CameraViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getCameras(): LiveData<Resource<CameraModel>> = repository.getCameras()
}
