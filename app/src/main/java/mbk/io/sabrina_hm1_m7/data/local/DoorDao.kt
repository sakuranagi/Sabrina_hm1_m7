package mbk.io.sabrina_hm1_m7.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import mbk.io.sabrina_hm1_m7.data.local.models.CameraEntity
import mbk.io.sabrina_hm1_m7.data.local.models.DoorEntity
@Dao
interface DoorDao {

    @Query("SELECT*FROM door")
    suspend fun getAll(): List<DoorEntity>

    @Insert
    suspend fun insertDoor(camera: DoorEntity)

    @Query("DELETE FROM door")
    suspend fun clearAll()

    @Delete
    suspend fun deleteDoor(doorEntity: DoorEntity)
}