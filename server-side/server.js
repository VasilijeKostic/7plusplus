const express = require('express')
const port = 3000

const User = require('./User.js')

const app = express()

app.listen(port, () => {
    console.log('server running on port ' + port)
})
app.use(express.urlencoded({ extended: true }))

app.post('/', (req, res) => {
    console.log(req)
})