const app = require("./config/server");
require("./app/rutas/contacto")(app);

app.listen(4000, () => console.log("Servidor corriendo en puerto 4000"));