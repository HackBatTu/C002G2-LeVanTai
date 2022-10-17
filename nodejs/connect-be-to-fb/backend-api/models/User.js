const mongoose = require("mongoose")

const userSchema = new mongoose.Schema({
    username:{
        type: String,
        require:true,
        minLength:6,
        maxLength: 20,
        unique: true
    },
    email:{
        type: String,
        require:true,
        minLength: 10,
        maxLength: 50,
        unique: true
    },
    password:{
        type: String,
        require:true,
        minLength: 6
    },
    admin:{
        type: Boolean,
        default: false
    }
},{timestamps: true});

module.exports = mongoose.model("User", userSchema);