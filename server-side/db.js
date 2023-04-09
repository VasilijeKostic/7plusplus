const sqlite3 = require('sqlite3').verbose()

let db = new sqlite3.Database('./db/classm8.db', (err) => {
    if (err) {
        console.log(err.message);
    } else {
        console.log('Connected to the database');
    }
});

db.serialize(() => {
    db.run(`
        CREATE TABLE IF NOT EXISTS User (
        ID_User INTEGER PRIMARY KEY,
        Username NCHAR(100) UNIQUE NOT NULL,
        Name NCHAR(50) NOT NULL,
        Surname NCHAR(50) NOT NULL
    )`, (err) => {
        if (err) {
            console.log(err);
        }
    });
    db.run(`
        CREATE TABLE IF NOT EXISTS Course (
        ID_Course INTEGER PRIMARY KEY,
        Name NCHAR(100) UNIQUE NOT NULL
    )`, (err) => {
        if (err) {
            console.log(err);
        }
    });
    db.run(`
        CREATE TABLE IF NOT EXISTS Lecture (
        ID_Lecture INTEGER PRIMARY KEY,
        Name NCHAR(50) NOT NULL,
        ID_Course INTEGER,
        FOREIGN KEY (ID_Course)
            REFERENCES Course (ID_Course)
    )`, (err) => {
        if (err) {
            console.log(err);
        }
    });
    db.run(`
        CREATE TABLE IF NOT EXISTS UserCourse (
        ID_User INTEGER,
        ID_Course INTEGER,
        PRIMARY KEY (ID_User, ID_Course),
        FOREIGN KEY (ID_User)
            REFERENCES User (ID_User),
        FOREIGN KEY (ID_Course)
            REFERENCES Course (ID_Course)

    )`, (err) => {
        if (err) {
            console.log(err);
        }
    });
});

module.exports = { db };
