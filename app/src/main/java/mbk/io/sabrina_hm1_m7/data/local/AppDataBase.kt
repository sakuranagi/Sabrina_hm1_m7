package mbk.io.sabrina_hm1_m7.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import mbk.io.sabrina_hm1_m7.model.CameraEntity
import mbk.io.sabrina_hm1_m7.model.DoorEntity

@Database(entities = [CameraEntity::class, DoorEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cameraDao(): CameraDao
    abstract fun doorDao(): DoorDao
}