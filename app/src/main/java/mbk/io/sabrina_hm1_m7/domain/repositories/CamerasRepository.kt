package mbk.io.sabrina_hm1_m7.domain.repositories

import androidx.lifecycle.LiveData
import mbk.io.sabrina_hm1_m7.data.Resource
import mbk.io.sabrina_hm1_m7.data.local.models.CameraEntity
import mbk.io.sabrina_hm1_m7.data.response.camera.CameraModel

interface CamerasRepository {
    fun getCameras(): LiveData<Resource<CameraModel>>
   suspend fun  getDBCameras():List<CameraEntity>
   suspend fun clearAll()

   suspend fun insert(cameraEntity: CameraEntity)
}