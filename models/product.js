//ใช้งาน mongoose
const mongoose = require('mongoose');

// เชื่อมไปยัง mongodb
const dburl = 'mongodb://localhost:27017/productDB'
mongoose.connect(dburl, {
    useNewUrlParser: true,
    useUnifiedTopology: true
}).catch(err => console.log(err))

// ออกแบบ schema
let productSchema = mongoose.Schema({
    name: String,
    price: Number,
    image: String,
    description: String
})

// create models
let Product = mongoose.model("product", productSchema)

//exports models

module.exports = Product

//ระบบบันทึกข้อมูล

module.exports.saveProduct=function (model,data) {
  model.save(data)  
    
}