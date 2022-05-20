package gt.edu.galileo.red.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gt.edu.galileo.red.model.Contacto
import gt.edu.galileo.red.model.ContactoResponse
import gt.edu.galileo.red.model.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListadoViewModel: ViewModel() {
    val listado = MutableLiveData<List<Contacto>>(arrayListOf())
    val isError = MutableLiveData<Boolean>(false)
    fun getContactos() {
        var contactos: Call<ContactoResponse> = RetrofitManager.create().getContactos()
        contactos.enqueue(object : Callback<ContactoResponse> {
            override fun onResponse(
                call: Call<ContactoResponse>,
                response: Response<ContactoResponse>
            ) {
                Log.d("PV", "Cargo datos")
                listado.value = response?.body()?.data ?: arrayListOf()
            }

            override fun onFailure(call: Call<ContactoResponse>, t: Throwable) {
                Log.d("PV", "Error datos")
                isError.value = true
            }

        })
    }
}