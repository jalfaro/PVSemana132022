package gt.edu.galileo.red.model

import com.google.gson.annotations.SerializedName

data class Contacto(
    @SerializedName("id")
    val id:Int?,
    @SerializedName("nombre")
    val nombre: String?,
    @SerializedName("telefono")
    val telefono: String?
)
