package mbk.io.sabrina_hm1_m7.domain.usecases

import androidx.lifecycle.LiveData
import mbk.io.sabrina_hm1_m7.data.Resource
import mbk.io.sabrina_hm1_m7.data.local.models.CameraEntity
import mbk.io.sabrina_hm1_m7.data.local.models.DoorEntity
import mbk.io.sabrina_hm1_m7.data.response.door.DoorModel
import mbk.io.sabrina_hm1_m7.domain.repositories.DoorsRepository
import javax.inject.Inject

class GetDoorUseCase @Inject constructor(private val doorsRepository: DoorsRepository) {
    fun getDoors():LiveData<Resource<DoorModel>> = doorsRepository.getDoors()

    suspend fun getDBDoors(): List<DoorEntity> = doorsRepository.getDBDoors()
    suspend fun insert(doorEntity: DoorEntity) = doorsRepository.insert(doorEntity)
    suspend fun clearAll() = doorsRepository.clearAllDoors()

    suspend fun deleteDoor(doorEntity: DoorEntity) = doorsRepository.deleteDoor(doorEntity)

}