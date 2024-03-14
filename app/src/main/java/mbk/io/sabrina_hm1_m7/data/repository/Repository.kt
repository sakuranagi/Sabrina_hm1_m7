package mbk.io.sabrina_hm1_m7.data.repository

import androidx.lifecycle.LiveData
import mbk.io.sabrina_hm1_m7.base.BaseRepository
import mbk.io.sabrina_hm1_m7.data.Resource
import mbk.io.sabrina_hm1_m7.data.local.AppDatabase
import mbk.io.sabrina_hm1_m7.data.local.models.CameraEntity
import mbk.io.sabrina_hm1_m7.data.local.models.DoorEntity
import mbk.io.sabrina_hm1_m7.data.remote.AppApiService
import mbk.io.sabrina_hm1_m7.data.response.camera.CameraModel
import mbk.io.sabrina_hm1_m7.data.response.door.DoorModel
import mbk.io.sabrina_hm1_m7.domain.repositories.CamerasRepository
import mbk.io.sabrina_hm1_m7.domain.repositories.DoorsRepository
import javax.inject.Inject

class Repository @Inject constructor(private val api: AppApiService, private val db: AppDatabase) :
    BaseRepository(), CamerasRepository, DoorsRepository {


    override fun getCameras(): LiveData<Resource<CameraModel>> = apiRequest {
        api.getCameras().body()!!
    }

    override fun getDoors(): LiveData<Resource<DoorModel>> = apiRequest {
        api.getDoors().body()!!
    }


    override suspend fun getDBCameras(): List<CameraEntity> = db.cameraDao().getAll()

    override suspend fun clearAll() = db.cameraDao().clearAll()
    override suspend fun deleteCamera(cameraEntity: CameraEntity) = db.cameraDao().delete(cameraEntity)


    override suspend fun insert(cameraEntity: CameraEntity) =
        db.cameraDao().insertCamera(cameraEntity)


    override suspend fun insert(doorEntity: DoorEntity) = db.doorDao().insertDoor(doorEntity)
    override suspend fun deleteDoor(doorEntity: DoorEntity) {
        db.doorDao().deleteDoor(doorEntity)
    }

    override suspend fun getDBDoors(): List<DoorEntity> = db.doorDao().getAll()
    override suspend fun clearAllDoors() = db.doorDao().clearAll()


}