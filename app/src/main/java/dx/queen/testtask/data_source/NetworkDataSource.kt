package dx.queen.testtask.data_source

import dx.queen.testtask.model.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

val retrofit: Retrofit by lazy {
    Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

}



interface INetworkDataSource {

    @GET("api/")
    suspend fun getResponse(@Query("results") results: Int): Response
}



class NetworkDataSource(private val retrofit: INetworkDataSource) {

    suspend fun getUsers(usersCount: Int) = retrofit.getResponse(usersCount)

}