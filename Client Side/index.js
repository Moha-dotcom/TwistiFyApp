

const path = require('path');
const bodyParser = require('body-parser')
const express = require('express');
const { default: axios } = require('axios');
const app = express()
const cookieSession = require('cookie-session');

const authRouter = require("./routes/admin/auth")

authRouter.use(express.static(__dirname));
app.use(bodyParser.urlencoded({extended : true}));
app.use(authRouter)





app.listen(9003, ()=> {
  console.log("Listening")
})
