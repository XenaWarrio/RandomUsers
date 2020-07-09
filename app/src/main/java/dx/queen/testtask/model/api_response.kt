package dx.queen.testtask.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

data class Response(
    @field:Json(name = "results") val results: List<User>,
    @field:Json(name = "info") val info: Info
)



@Parcelize
data class User(
    @field:Json(name = "name") val name: Name,
    @field:Json(name = "location") val location: Location,
    @field:Json(name = "cell") val cell: String,
    @field:Json(name = "email") val email: String,
    @field:Json(name = "registered") val registered: Registered,
    @field:Json(name = "phone") val phone: String,
    @field:Json(name = "picture") val picture: Picture
) : Parcelable



@Parcelize
data class Registered(
    @field:Json(name = "age") val age: Int
) : Parcelable



@Parcelize
data class Name(
    @field:Json(name = "first") val first: String,
    @field:Json(name = "last") val last: String
) : Parcelable

@Parcelize
data class Picture(
    @field:Json(name = "medium") val medium: String
) : Parcelable



@Parcelize
data class Info(
    @field:Json(name = "results") val results: Int
) : Parcelable



@Parcelize
data class Location(
    @field:Json(name = "city") val city: String
) : Parcelable

