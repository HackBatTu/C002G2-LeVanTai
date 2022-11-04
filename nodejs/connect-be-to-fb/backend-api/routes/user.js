const router = require("express").Router();

// get all user
router.get("/",userController.get);

module.exports = router;