const express = require('express')
const bodyParser = require('body-parser')

const app = express()

// Use the body-parser middleware to parse plain text
app.use(bodyParser.text())

app.post('/getUser', (req, res) => {
    console.log(req.body)
    res.send('podaci o korisniku')
})

app.post('/getUserCourses', (req, res) => {
    console.log(req.body)
    res.send('kursevi koje slusa korisnik')
})

app.listen(port, () => {
    console.log('Server listening on port 3000')
})
