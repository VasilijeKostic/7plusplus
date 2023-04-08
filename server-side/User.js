class User {
    constructor(username, name, surname) {
        this.username = username
        this.name = name
        this.surname = surname
    }

    setUsername(username) {
        this.username = username
    }

    setName(name) {
        this.name = name
    }

    getUsername() {
        return this.username
    }

    printUser() {
        console.log(this.name, this.surname)
    }
}

module.exports = User
