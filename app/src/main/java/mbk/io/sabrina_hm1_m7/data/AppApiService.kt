package mbk.io.sabrina_hm1_m7.data

import mbk.io.sabrina_hm1_m7.model.CameraModel
import mbk.io.sabrina_hm1_m7.model.DoorModel
import retrofit2.Response
import retrofit2.http.GET

interface AppApiService {
    @GET("cameras/")
    suspend fun getCameras(): Response<CameraModel>

    @GET("doors/")
    suspend fun getDoors(): Response<DoorModel>
}