var mysql = require("mysql");
var db = mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'levantai1496',
    database:'nodejs'
})

db.connect();
module.exports=db;
