package mbk.io.sabrina_hm1_m7.data.remote

import mbk.io.sabrina_hm1_m7.data.response.camera.CameraModel
import mbk.io.sabrina_hm1_m7.data.response.door.DoorModel
import retrofit2.Response
import retrofit2.http.GET

interface AppApiService {
    @GET("cameras/")
    suspend fun getCameras(): Response<CameraModel>

    @GET("doors/")
    suspend fun getDoors(): Response<DoorModel>
}