package gt.edu.galileo.red.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ContactoApi {
    @GET("contacto")
    fun getContactos(): Call<ContactoResponse>

    @Headers("Content-Type: application/json")
    @POST("contacto")
    fun saveContacto(@Body contacto: ContactoRequest): Call<ContactoResponse>
}