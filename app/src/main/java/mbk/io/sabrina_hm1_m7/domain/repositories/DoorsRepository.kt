package mbk.io.sabrina_hm1_m7.domain.repositories

import androidx.lifecycle.LiveData
import mbk.io.sabrina_hm1_m7.data.Resource
import mbk.io.sabrina_hm1_m7.data.local.models.CameraEntity
import mbk.io.sabrina_hm1_m7.data.local.models.DoorEntity
import mbk.io.sabrina_hm1_m7.data.response.door.DoorModel

interface DoorsRepository {
    fun getDoors(): LiveData<Resource<DoorModel>>

    suspend fun  getDBDoors():List<DoorEntity>
    suspend fun clearAllDoors()

    suspend fun insert(doorEntity: DoorEntity)
    suspend fun deleteDoor(doorEntity: DoorEntity)
}