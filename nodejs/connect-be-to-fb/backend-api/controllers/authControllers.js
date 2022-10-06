const User = require("../models/User")
const bcrypt = require("bcrypt")
const authController={
    //register
    registerUser: async(req, res) => {
        try {
            const salt = bcrypt.genSalt(10)
            const hashed = await bcrypt.hash(req.body.password, salt)

            //create new user
            const newUser = await new User({
                username: req.body.username,
                email: req.body.email,
                password: hashed,
            })
            // save to db
            const user = await newUser.save();
            res.status(200).json(user);

        }catch (err) {
            res.status(500).json(err)
        }
    }
}
module.exports = authController;
