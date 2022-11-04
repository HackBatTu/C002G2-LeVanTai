let express = require('express');
let router = express.Router();
let dbConnect = require("../database/connect")

/* get list student. */
router.get("/", (req, res, next) => {
    let sql = 'SELECT * FROM student';
    dbConnect.query(sql,  (err, data) => {
        if (err) throw err;
        res.render('index', {data: data});
    })
});

// add student
router.get("/add", (req, res) => {
    res.render("add")
});
router.post("/add",  (req, res) => {
    let data = req.body;
    let sql = 'INSERT INTO student SET ?';
    dbConnect.query(sql, data, (err, d) => {
        if (err) throw err;
        res.redirect("/")
    });
});

// delete student
router.get("/delete/:id", (req, res) => {
    let sql = `DELETE FROM student WHERE id=${req.params.id}`
    dbConnect.query(sql,  (err) => {
        if (err) throw err
        res.redirect("/")
    })
});

// edit student
router.get("/edit/:id", (req, res) => {
    let sql = `SELECT * FROM student WHERE id=${req.params.id}`
    let data = dbConnect.query(sql, (err,result) => {
        if (err) throw err
       data= {
            id:result[0].id,
            name:result[0].name,
            age:result[0].age,
           address:result[0].address,
           class:result[0].class,
       }
        res.render("edit",{data})
    })
});

router.post('/edit', (req, res, next) => {
    let data = req.body;
    let id = req.params.id;
    let sql = `UPDATE student SET ? WHERE id = ?`;
    dbConnect.query(sql, [data, id], (err,d) => {
        if (err) throw err;
        res.redirect("/")
    });
});

// tìm kiếm học sinh
router.get("/search", (req, res) => {
    dbConnect.query(`select * FROM student WHERE name like ${req.params.id}`, err => {
        if (err) throw err
        res.redirect("/")
    })
});
module.exports = router;
