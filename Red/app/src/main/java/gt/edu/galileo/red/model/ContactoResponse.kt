package gt.edu.galileo.red.model

data class ContactoResponse(
    val status: Int?,
    val mensaje: String?,
    val data: List<Contacto>?
)
