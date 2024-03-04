package mbk.io.sabrina_hm1_m7.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import mbk.io.sabrina_hm1_m7.model.CameraEntity
import mbk.io.sabrina_hm1_m7.model.CameraModel

@Dao
interface CameraDao {

    @Query("SELECT*FROM camera")
    suspend fun getAll(): List<CameraEntity>

    @Insert
    suspend fun insertCamera(camera:CameraEntity)

    @Query("DELETE FROM camera")
    suspend fun clearAll()
}