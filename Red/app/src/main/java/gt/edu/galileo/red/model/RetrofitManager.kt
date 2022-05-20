package gt.edu.galileo.red.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager {
    companion object {
        val BASE_URL = "http://192.168.1.17:4000"

        fun create() : ContactoApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ContactoApi::class.java)
        }
    }
}