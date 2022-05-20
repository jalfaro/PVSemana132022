package gt.edu.galileo.red.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gt.edu.galileo.red.model.Contacto
import gt.edu.galileo.red.model.ContactoRequest
import gt.edu.galileo.red.model.ContactoResponse
import gt.edu.galileo.red.model.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IngresoViewModel : ViewModel() {
    val mostrarMensaje = MutableLiveData<String>("");
    val isError = MutableLiveData<Boolean>(false)
    fun grabaUsuario(nombre: String, telefono: String) {
        val temporalContacto = ContactoRequest(nombre, telefono);
        var contactos: Call<ContactoResponse> = RetrofitManager.create().saveContacto(temporalContacto)
        contactos.enqueue(object : Callback<ContactoResponse> {
            override fun onResponse(
                call: Call<ContactoResponse>,
                response: Response<ContactoResponse>
            ) {
                mostrarMensaje.value = response.body()?.mensaje
            }

            override fun onFailure(call: Call<ContactoResponse>, t: Throwable) {
                Log.d("PV", "Error datos")
                isError.value = true;
            }

        })
    }
}