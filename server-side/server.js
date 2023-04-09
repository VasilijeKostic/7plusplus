const express = require('express')
const bodyParser = require('body-parser')
const database = require('./db.js')

const port = 3000

const app = express()

// Use the body-parser middleware to parse plain text
app.use(bodyParser.text())

let onlineUsersCourse = {}

app.post('/insertUser', (req, res) => {
    let [Username, Name, Surname] = req.body.split('$')
    database.db.run(`
        INSER INTO User(Username, Name, Surname)
        VALUES(?, ?, ?, ?)
    `, [Username, Name, Surname], (err) => {
        if (err) {
            console.log(err)
        }
    })
})

app.post('/getUser', (req, res) => {
    let Username = req.body
    database.db.all(`
        SELECT Username, Name, Surname
        FROM User
        WHERE Username=?
    `, [Username], (err, rows) => {
        if (err) {
            console.log(err)
        }
        else {
            let Username = rows[0]['Username']
            let Name = rows[0]['Name']
            let Surname = rows[0]['Surname']
            res.send(Username + '$' + Name + '$' + Surname)
        }
    })
})

app.post('/getCourses', (req, res) => {
    let Username = req.body
    database.db.all(`
        SELECT C.Name
        FROM User U, Course C, UserCourse UC
        WHERE U.Username=? AND U.ID_User=UC.ID_User AND C.ID_Course=UC.ID_Course
    `, [Username], (err, rows) => {
        if (err) {
            console.log(err)
        }
        else {
            res.send(rows.map(element => element['Name']).join('$'))
        }
    })
})

app.post('/getLectures', (req, res) => {
    let courseName = req.body
    database.db.all(`
        SELECT L.Name
        FROM Course C, Lecture L
        WHERE C.Name=? AND L.ID_Course=C.ID_Course
    `, [courseName], (err, rows) => {
        if (err) {
            console.log(err)
        }
        else {
            res.send(rows.map(element => element['Name']).join('$'))
        }
    })
})

app.post('/insertUsernameLecture', (req, res) => {
    let [Username, lectureName] = req.body.split('$')
    if (lectureName in onlineUsersCourse) {
        onlineUsersCourse[lectureName].add(Username)
    }
    else {
        onlineUsersCourse[lectureName] = new Set()
    }
})

app.post('removeUsernameLecture', (req, res) => {
    let [Username, lectureName] = req.body.split('$')
    onlineUsersCourse[lectureName].delete(Username)
})

app.listen(port, () => {
    console.log('Server listening on port 3000')
})

add.post('/getOnlineUsers', (req, res) => {
    let lectureName = req.body
    res.send(Array.from(onlineUsersCourse[lectureName]).join('$'))
})
