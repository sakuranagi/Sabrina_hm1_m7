package mbk.io.sabrina_hm1_m7.domain.usecases

import androidx.lifecycle.LiveData
import mbk.io.sabrina_hm1_m7.data.Resource
import mbk.io.sabrina_hm1_m7.data.local.models.CameraEntity
import mbk.io.sabrina_hm1_m7.data.response.camera.CameraModel
import mbk.io.sabrina_hm1_m7.domain.repositories.CamerasRepository
import javax.inject.Inject

class GetCameraUseCase @Inject constructor(private val camerasRepository: CamerasRepository) {
    fun getCameras(): LiveData<Resource<CameraModel>> = camerasRepository.getCameras()

    suspend fun getDBCameras(): List<CameraEntity> = camerasRepository.getDBCameras()

    suspend fun clearAll() = camerasRepository.clearAll()

    suspend fun deleteCamera(cameraEntity: CameraEntity) = camerasRepository.deleteCamera(cameraEntity)

    suspend fun insert(cameraEntity: CameraEntity) = camerasRepository.insert(cameraEntity)
}