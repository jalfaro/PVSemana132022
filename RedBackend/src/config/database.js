const mysql = require("mysql");
const { rootCertificates } = require("tls");

const conn = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "Abc12345",
    database: "pv"
});

conn.connect(err => {
    if (err) {
        console.log("Error en el servidor de db");
    } else {
        console.log("Servidor de DB activo");
    }
});

module.exports = conn;