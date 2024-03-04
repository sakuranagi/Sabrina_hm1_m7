package mbk.io.sabrina_hm1_m7.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import mbk.io.sabrina_hm1_m7.data.AppApiService
import mbk.io.sabrina_hm1_m7.data.Resource

abstract class BaseRepository (private val api: AppApiService){
    fun <T> apiRequest(apiCall: suspend () -> T): LiveData<Resource<T>> =
        liveData(Dispatchers.Main) {
            emit(Resource.Loading())
            try {
                val response = apiCall.invoke()
                if (response != null) {
                    emit(Resource.Success(response))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
            }

        }

}