var fs = require('fs');

var readableStream = fs.createReadStream('fs_module.txt');
var writableStream = fs.createWriteStream('text.txt');
readableStream.pipe(writableStream);