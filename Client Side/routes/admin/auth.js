
const { default: axios } = require('axios');
const path = require('path');


const express = require('express');
const router = express.Router();





//Signup

router.get('/signup',function(req,res){
  res.sendFile('/Users/mohamedabdullahi/Desktop/git-repos/TwistiFyApp/Client Side/views/signup.html');
});

router.post("/signup", async (req, res) => {
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
          res.send("Successfully registered ")
          console.log(response.data)
        }
      }).catch((err) => {
        res.send("Wrong Email")
      })
    
    }
  
    res.send("Password Not the same")
    res.redirect('/signup')
  
  
  });
  
  


  // Sign in
  router.get('/signin',function(req,res){
    res.sendFile('/Users/mohamedabdullahi/Desktop/git-repos/TwistiFyApp/Client Side/views/signin.html');
  });



  router.post("/signin", async (req, res) => {
      res.send("Sign in")
  })





  // Signout






  module.exports = router