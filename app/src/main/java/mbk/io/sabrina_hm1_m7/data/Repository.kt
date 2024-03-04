package mbk.io.sabrina_hm1_m7.data

import androidx.lifecycle.LiveData
import mbk.io.sabrina_hm1_m7.base.BaseRepository
import mbk.io.sabrina_hm1_m7.model.CameraModel
import mbk.io.sabrina_hm1_m7.model.DoorModel
import javax.inject.Inject

class Repository @Inject constructor(private val api: AppApiService) : BaseRepository(api) {
    fun getCameras(): LiveData<Resource<CameraModel>> = apiRequest {
        api.getCameras().body()!!
    }
    fun getDoors(): LiveData<Resource<DoorModel>> = apiRequest {
        api.getDoors().body()!!
    }

}