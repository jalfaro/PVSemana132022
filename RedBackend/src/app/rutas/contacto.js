const conn = require("../../config/database");

module.exports = (app) => {
    app.get("/contacto", (req, res) => {
        let consulta = "SELECT id,  nombre, telefono FROM contacto";
        conn.query(consulta, (err, rows, cols) => {
            if (err) {
                res.json({status: 0, mensaje: "Error obteniendo los Contactos", datos: []});
            } else {
                res.json({status: 1, mensaje:"Datos obtenidos satisfactoriamente", data: rows})
            }
        })
    });

    app.post("/contacto", (req, res) => {
        console.log(req.body);
        let consulta = `INSERT INTO contacto (nombre, telefono) VALUES ('${req.body.nombre}', '${req.body.telefono}')`;
        console.log(consulta);
        conn.query(consulta, (err, rows, cols) => {
            if (err) {
                res.json({status: 0, mensaje: "Error insertando los Contactos"});
            } else {
                res.json({status: 1, mensaje:"Datos insertados satisfactoriamente"})
            } 
        })
    });
}