const fs = require("fs");
const {dialog} = require("electron").remote;


//Creating a new file...
document.getElementById("btn-createfile").addEventListener("click",()=>{
    let content = document.getElementById("content-editor").value;
    dialog.showSaveDialog((fileName)=>{
        if(fileName === undefined)
        {
            console.log("File didn't created");
            return;
        }
        else
        {
            document.getElementById("actual-file").value = fileName;
            fs.writeFile(fileName,content,(err)=>{
                if(err)
                {
                    console.log("Error in creation "+err.message);
                    return;
                }
                alert("File created succesfully");
            });
        }   
    });
},false);


//Reading a existing file...
document.getElementById("btn-readfile").addEventListener("click",()=>{
    dialog.showOpenDialog((fileNames)=>{
        if(fileNames === undefined)
        {
            console.log("No files were selected");
            return;
        }
        else
        {
            document.getElementById("actual-file").value = fileNames[0];
            fs.readFile(fileNames[0],"utf-8",(err,data)=>{
                if(err)
                {
                    console.log("Cannot read file",err);
                    return;
                }
                document.getElementById("content-editor").value = data;
            });
        }
    });
}, false);


//Save changes...
document.getElementById('save-changes').addEventListener('click',function(){
    var actualFilePath = document.getElementById("actual-file").value;
    
    if(actualFilePath){
        saveChanges(actualFilePath,document.getElementById('content-editor').value);
    }else{
        alert("Please select a file first");
    }
},false);
function saveChanges(filepath,content){
    fs.writeFile(filepath, content, function (err) {
        if(err){
            alert("An error ocurred updating the file"+ err.message);
            console.log(err);
            return;
        }
        
        alert("The file has been succesfully saved");
    }); 
}


//Deleteing a file...
document.getElementById("btn-delete").addEventListener("click",()=>{
    dialog.showOpenDialog((fileNames)=>{
        if(fileNames === undefined)
        {
            console.log("No files were selected");
            return;
        }
        if(!fs.existsSync(fileNames[0]))
        {
            alert("The file in "+fileNames[0]+" doesn't exist");
            return;
        }
        fs.unlink(fileNames[0],(err)=>{
            if(err)
            {
                console.log("Cannot delete file",err);
                return;
            }
            alert("File successfully deleted");
        });
    });
},false);


//Closing a editor...
const remote = require('electron').remote
document.getElementById("btn-close").addEventListener("click",()=>{
    var window = remote.getCurrentWindow()
    window.close();
},false);


//Searching a String...
const searchInPage = require('electron-in-page-search').default;
const inPageSearch = searchInPage(remote.getCurrentWebContents());

document.getElementById("btn-search").addEventListener('click', () => {
    inPageSearch.openSearchWindow();
},false);


//line numbers in textarea...
window.$ = window.jQuery = require("jquery");
$(function() {   
    $('textarea').linenumbers({col_width:'1px'});	
});
