package mbk.io.sabrina_hm1_m7.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "camera")
data class CameraEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int ?=null,
    val favorites: Boolean,
    val name: String,
    val rec: Boolean,
    val room: String,
    val snapshot: String
):Serializable