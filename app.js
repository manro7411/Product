const express = require('express');
const router = require('./router/myRouter');
const path = require('path');
const app = express();
const session = require('express-session');
const cookieParser = require('cookie-parser');
//view

app.set('views ', path.join(__dirname, 'views'))
app.set('view engine', 'ejs')
app.use(express.urlencoded({ extended: false }))
app.use(cookieParser())
app.use(session({ secret: "mysession", resave: false, saveUninitialized: false }))
app.use(router)
app.use(express.static(path.join(__dirname, 'public')))

app.listen(8080, () => {
    console.log("Server Running...")
})