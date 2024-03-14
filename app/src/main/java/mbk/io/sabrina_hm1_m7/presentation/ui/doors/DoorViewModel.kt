package mbk.io.sabrina_hm1_m7.presentation.ui.doors

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mbk.io.sabrina_hm1_m7.data.Resource
import mbk.io.sabrina_hm1_m7.data.local.models.CameraEntity
import mbk.io.sabrina_hm1_m7.data.local.models.DoorEntity
import mbk.io.sabrina_hm1_m7.data.response.door.DoorModel
import mbk.io.sabrina_hm1_m7.domain.usecases.GetDoorUseCase
import javax.inject.Inject

@HiltViewModel
class DoorViewModel @Inject constructor(private val doorUseCase: GetDoorUseCase) : ViewModel() {
    fun getDoors(): LiveData<Resource<DoorModel>> = doorUseCase.getDoors()

    suspend fun getDBDoors(): List<DoorEntity> = doorUseCase.getDBDoors()

    suspend fun deleteDoor(doorEntity: DoorEntity) = doorUseCase.deleteDoor(doorEntity)

    suspend fun clearAll() = doorUseCase.clearAll()

    suspend fun insert(doorEntity: DoorEntity) = doorUseCase.insert(doorEntity)
}
