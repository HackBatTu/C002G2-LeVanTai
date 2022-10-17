const express = require("express")
const cors = require("cors")
const dotenv = require("dotenv")
const mongoose = require("mongoose")
const cookieParser = require("cookie-parser")
const authRouter = require("./routes/auth")
const userRouter = require("./routes/user")

dotenv.config();
const app = express();

mongoose.connect(process.env.MONGODB_URL,()=>{
    console.log("Connected to mongo db")
})

app.use(cors());
app.use(cookieParser())
app.use(express.json())

//routes
app.use("/v1/auth", authRouter)
app.use("/v1/user". userRouter)

app.listen(8000, () => {
    console.log("Server is running")
});
