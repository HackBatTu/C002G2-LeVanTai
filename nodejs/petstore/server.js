let express = require('express');
let app = express();
let morgan = require('morgan');
let bodyParser = require('body-parser');
let port = process.env.PORT || 1996;
let pet = require('./routes/pet');

//don't show the log when it is test
if(process.env.NODE_ENV !== 'test') {
    //use morgan to log at command line
    app.use(morgan('combined')); //'combined' outputs the Apache style LOGs
}

//parse application/json and look for raw text
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.text());
app.use(bodyParser.json({ type: 'application/json'}));

app.get("/", (req, res) => res.json({message: "Welcome to our Petstore!"}));

app.route("/pets")
    .get(pet.getListPets)
    .post(pet.postPet);
app.route("/pets/:id")
    .get(pet.getPet)
    .delete(pet.deletePet)
    .put(pet.updatePet);

app.listen(port);
console.log("Listening on port " + port);

module.exports = app; // for testing
