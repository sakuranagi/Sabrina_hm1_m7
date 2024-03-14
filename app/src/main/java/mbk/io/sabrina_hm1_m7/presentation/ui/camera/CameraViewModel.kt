package mbk.io.sabrina_hm1_m7.presentation.ui.camera

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mbk.io.sabrina_hm1_m7.data.Resource
import mbk.io.sabrina_hm1_m7.data.local.models.CameraEntity
import mbk.io.sabrina_hm1_m7.data.response.camera.CameraModel
import mbk.io.sabrina_hm1_m7.domain.usecases.GetCameraUseCase
import javax.inject.Inject


@HiltViewModel
class CameraViewModel @Inject constructor(private val cameraUseCase: GetCameraUseCase) : ViewModel() {
    fun getCameras(): LiveData<Resource<CameraModel>> = cameraUseCase.getCameras()

    suspend fun getDBCameras(): List<CameraEntity> = cameraUseCase.getDBCameras()

    suspend fun clearAll() = cameraUseCase.clearAll()

    suspend fun deleteCamera(cameraEntity: CameraEntity) = cameraUseCase.deleteCamera(cameraEntity)
    suspend fun insertCamera(cameraEntity: CameraEntity) = cameraUseCase.insert(cameraEntity)
}
