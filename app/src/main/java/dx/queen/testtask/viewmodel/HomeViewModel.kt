package dx.queen.testtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dx.queen.testtask.data_source.INetworkDataSource
import dx.queen.testtask.data_source.NetworkDataSource
import dx.queen.testtask.data_source.retrofit
import dx.queen.testtask.model.User
import dx.queen.testtask.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val networkDataSource =
        NetworkDataSource(
            retrofit.create(
                INetworkDataSource::class.java
            )
        )

    private val repository =
        Repository(networkDataSource)


    private val userListMutableLiveData = MutableLiveData<List<User>>()
    val userListLiveData: LiveData<List<User>> = userListMutableLiveData


    fun getListUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getResponse(20)

            userListMutableLiveData.postValue(result.results)
        }
    }


}