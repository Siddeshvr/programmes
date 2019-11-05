var fs = require('fs');

fs.readFile('fs_module.txt' , function(err,data)
{
    if(err){console.log(err);}
    else
    {
        console.log("Async data is : "+data.toString());
    }
});

var data = fs.readFileSync('fs_module.txt');
console.log("Sync data is : "+data.toString());