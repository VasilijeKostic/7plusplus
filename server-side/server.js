const express = require('express')
const bodyParser = require('body-parser')
const database = require('./db.js')

// SOCKETS Milos
const socket = require('socket.io');

const port = 3000

const app = express()

// Use the body-parser middleware to parse plain text
app.use(bodyParser.text())

let onlineUsersCourse = {}

function test(input) {
    let [Username, lectureName] = input.split('$')
    database.db.all(`
        SELECT U.Name, L.Name
        FROM User U, UserCourse UC, Lecture L
        WHERE U.Username=? AND UC.ID_User=U.ID_User AND L.Name=? AND L.ID_Course=UC.ID_Course
    `, [Username, lectureName], (err, rows) => {
        if (err) {
            console.log('[insertUsernameLecture]', err)
        }
        else {
            if (rows.length > 0) {
                if (!(lectureName in onlineUsersCourse)) {
                    onlineUsersCourse[lectureName] = new Set()
                }
                onlineUsersCourse[lectureName].add(Username)
            }
            console.log('online: ', onlineUsersCourse)
        }
    })
}

app.post('/insertUser', (req, res) => {
    let [Username, Name, Surname] = req.body.split('$')
    database.db.run(`
        INSERT INTO User(Username, Name, Surname)
        VALUES(?, ?, ?)
    `, [Username, Name, Surname], (err) => {
        if (err) {
            console.log(err)
        }
        else {
            res.send('success')
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
    database.db.all(`
        SELECT U.Name, L.Name
        FROM User U, UserCourse UC, Lecture L
        WHERE U.Username=? AND UC.ID_User=U.ID_User AND L.Name=? AND L.ID_Course=UC.ID_Course
    `, [Username, lectureName], (err, rows) => {
        if (err) {
            console.log(err)
        }
        else {
            if (rows.length > 0) {
                if (!(lectureName in onlineUsersCourse)) {
                    onlineUsersCourse[lectureName] = new Set()
                }
                onlineUsersCourse[lectureName].add(Username)
                res.send('success')
            }
            else {
                res.send('failure')
            }
        }
    })
})

app.post('/removeUsernameLecture', (req, res) => {
    let [Username, lectureName] = req.body.split('$')
    if (lectureName in onlineUsersCourse && onlineUsersCourse[lectureName].size > 0) {
        onlineUsersCourse[lectureName].delete(Username)
        res.send('success')
    }
    else {
        res.send('failure')
    }
})

app.post('/getOnlineUsers', (req, res) => {
    let lectureName = req.body
    res.send(Array.from(onlineUsersCourse[lectureName]).join('$'))
})

// Milos - dodao sam const server = ...
const server = app.listen(port, () => {
    console.log('Server listening on port 3000')
})

// SOCKETS Milos START
const io = socket(server);

io.on('connection', (socket) => {
  console.log('a user connected');

  socket.on('chat message', (msg) => {
    console.log('message: ' + msg);
    io.emit('chat message', msg);
  });

  socket.on('disconnect', () => {
    console.log('user disconnected');
  });
});
// SOCKETS Milos END
