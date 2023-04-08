const http = require('http')
const port = 3000

const server = http.createServer((req, res) => {
    console.log(req)
    res.setHeader('Content-Type', 'text/plain')
    res.write('nesto')
    res.end()
})

server.listen(port, 'localhost', (error) => {
    console.log('listening for requests on port 3000')
    if (error) {
        console.log('Something went wrong', error)
    }
    else {
        console.log('Server is listening on port ' + port)
    }
})
