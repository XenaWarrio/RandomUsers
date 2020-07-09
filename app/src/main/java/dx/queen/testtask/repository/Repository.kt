package dx.queen.testtask.repository

import dx.queen.testtask.data_source.NetworkDataSource

class Repository (private val networkDataSource : NetworkDataSource){
    suspend fun getResponse(usersCount: Int) = networkDataSource.getUsers(usersCount)

}