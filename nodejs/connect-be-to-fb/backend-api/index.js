const express = require("express")
const cors = require("cors")
const dotenv = require("dotenv")
const mongoose = require("mongoose")
const cookieParse = require("cookie-parser")
const authRoute = require("./routes/auth")

dotenv.config();
const app = express();

mongoose.connect(process.env.MONGODB_URL,() => {
    console.log("connected to mongodb")
})

app.use(cors());
app.use(cookieParse())
app.use(express.json())

//routes
app.use("/v1/auth",authRoute)

app.listen(8000, () => {
    console.log("Server is running")
})

// authentication

// authorization

