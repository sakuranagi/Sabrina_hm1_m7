package mbk.io.sabrina_hm1_m7.app

import android.app.Application
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp
import mbk.io.sabrina_hm1_m7.data.local.AppDatabase

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database-name"
        ).build()
    }

    companion object {
        lateinit var db: AppDatabase
    }
}