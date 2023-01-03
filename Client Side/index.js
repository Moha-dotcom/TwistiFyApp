

const path = require('path');
const bodyParser = require('body-parser')
const express = require('express');
const { default: axios } = require('axios');
const app = express()
const cookieSession = require('cookie-session');

app.use(express.static(__dirname));
app.use(bodyParser.urlencoded({extended : true}));
app.get('/signup',function(req,res){
    res.sendFile(path.join(__dirname +'/src/index.html'));
  });
  

app.post("/signup", async (req, res) => {
  const {email, username, password, passwordConfirmation} = req.body

  if(password === passwordConfirmation){

    await axios({
      url: "http://localhost:8080/register",
      method: "post",
      data : {
        "email": email, "username": username, "password": password
      }
    }).then((response) => {
      if(res.status(201)){
        res.send("Successfully Logged In")
        console.log(response.data)
      }
    }).catch((err) => {
      res.send("Wrong Email")
    })
  
  }

  res.send("Password Not the same")
  res.redirect('/signup')


});








app.listen(9003, ()=> {
  console.log("Listening")
})
