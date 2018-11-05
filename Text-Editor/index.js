const fs = require("fs");  //javascript file-system...
const {dialog} = require("electron").remote;  //import elecron...
const path = require("path");   //import current directory path...


//To move the cursor to end...(to set line number)
function temp()
{
    var element = document.getElementById("content-editor");
    element.focus();
    element.setSelectionRange(element.value.length,element.value.length); //to focus at end of text...
}


//Creating a new file...
//and write the content of the editor area to that file...
document.getElementById("btn-createfile").addEventListener("click",()=>{
    let content = document.getElementById("content-editor").value;
    dialog.showSaveDialog((fileName)=>{
        if(fileName === undefined)       //If I don't specify any file name...
        {
            console.log("File not created");
            return;
        }
        else
        {
            document.getElementById("file-dir").value = path.basename(path.dirname(fileName));    //for file-path...
            fs.writeFile(fileName,content,(err)=>{
                if(err)
                {
                    console.log("Error in creation "+err.message);
                    return;
                }
                document.getElementById("actual-file").value = path.basename(fileName);
                alert("File created succesfully");
            });
        }   
    });
},false);


//Opening an existing file...
document.getElementById("btn-readfile").addEventListener("click",()=>{
    dialog.showOpenDialog((fileNames)=>{
        if(fileNames === undefined)
        {
            console.log("No files were selected");
            return;
        }
        else
        {
            //document.getElementById("actual-file").value = fileNames[0];           //for file-path...
            document.getElementById("file-dir").value = path.basename(path.dirname(fileNames[0]));
            document.getElementById("actual-file").value = path.basename(fileNames[0]);  //for file-name...
            fs.readFile(fileNames[0],"utf-8",(err,data)=>{
                if(err)
                {
                    console.log("Cannot read file",err);
                    return;
                }
                document.getElementById("content-editor").value = data;
                temp();
            });
        }
    });
}, false);



//Reading multiple files...
var filelist,input,count,reader;
var openFile = function(event) 
{
    document.getElementById("file-dir").value = null;
    document.getElementById("actual-file").value = null;
    document.getElementById("content-editor").value = null;
    temp();
    filelist = document.getElementById('mul-files').files;
    input = event.target;
    reader = new FileReader();
    reader.onload = function()
    {
        document.getElementById('content-editor').value = reader.result;
        temp();
        document.getElementById('actual-file').value = filelist[count-1].name;
        document.getElementById("file-dir").value = path.basename(__dirname);
    };
    count=0;
    reader.readAsText(input.files[count]);
    count = count+1;
    document.getElementById("btn-mul").addEventListener("click",()=>{
        if(count>=filelist.length) count = 0;
        reader.readAsText(input.files[count]);
        count = count+1;
    });
};


//Closing an opened file...
document.getElementById("btn-close").addEventListener("click",()=>{
    var fileName = document.getElementById("actual-file").value;
    if(!fileName)
    {
        alert("No file opened");
        return;
    }
    else
    {
        document.getElementById("file-dir").value = null;
        document.getElementById("actual-file").value = null;
        document.getElementById("content-editor").value = null;
        temp();
        filelist = null;
        document.getElementById('mul-files').value = "";
    }
},false);


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
        if(!fs.existsSync(fileNames[0])) //To check whether a file present or not...
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
document.getElementById("btn-exit").addEventListener("click",()=>{
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
    $('#content-editor').linenumbers({col_width:'1px'});	
});


//Minimizing the window...
document.getElementById("btn-minimize").addEventListener("click",()=>{
    var window = remote.getCurrentWindow()
    window.minimize();
});
//Ribbon control...minimize and maximize window...
document.getElementById("btn-ribbon").addEventListener("click",()=>{
    var window = remote.getCurrentWindow()
    if(!window.isMaximized()) {window.maximize();}
    else {window.unmaximize();}
});


//Cut,Copy and Paste...
document.getElementById("btn-cut").addEventListener("click",()=>{
    document.execCommand("cut");      //cut selected text and copy to clipboard...
});

document.getElementById("btn-copy").addEventListener("click",()=>{
    document.execCommand("copy");    //copy selected text to clipboard...
});

document.getElementById("btn-paste").addEventListener("click",()=>{
    document.execCommand("paste");   //paste clipboard content at caret position...
    temp();
});


//Undo and Redo on textarea...
document.getElementById("btn-undo").addEventListener("click",()=>{
    document.execCommand("undo");
    temp();
});

document.getElementById("btn-redo").addEventListener("click",()=>{
    document.execCommand("redo");
    temp();
});

//Select content of textArea...
document.getElementById("btn-all").addEventListener("click",()=>{
    document.execCommand("selectAll");
});


//For tab...
$(document).delegate('#content-editor', 'keydown', function(e) {
    var keyCode = e.keyCode || e.which;
  
    if (keyCode == 9) {
      e.preventDefault();
      var start = this.selectionStart;
      var end = this.selectionEnd;
  
      // set textarea value to: text before caret + tab + text after caret
      $(this).val($(this).val().substring(0, start)
                  + "\t"
                  + $(this).val().substring(end));
  
      // put caret at right position again
      this.selectionStart =
      this.selectionEnd = start + 1;
    }
});
  

//Auto-indentation...
function doAutoIndent(ta, indent) 
{
    indent || (indent = "\t");
    
    function setValue(text) {
        ta.value = text;
        return ta.value;
    }

    function str_repeat(str, n) {
        var out = '';
        while (n--) out += str;
        return out;
    }
    
    function isIndented(line) {
        var regex = new RegExp('^(' + indent + '+)', 'g'),
            match = line.match(regex);
        return match && match[0].length / indent.length || 0;
    }

    function addIndent(before, after, num) {
        // num = num ? ~~num : 1;
        if ( !num ) return;
        ta._lastValue = setValue(before + str_repeat(indent, num) + after);
        ta.selectionStart = ta.selectionEnd = before.length + indent.length * num;
    }
    
    function removeIndent(before, after) {
        var remove = before.slice(before.length - 1 - indent.length, before.length - 1);
        if ( remove != indent ) {
            return;
        }
        
        ta._lastValue = setValue(before.slice(0, -1-indent.length) + '}' + after);
        ta.selectionStart = ta.selectionEnd = before.length - indent.length;
    }

    function getPrevLine(before) {
        var lines = ta.value.split(/\n/g),
            line = before.trimRight().split(/\n/g).length - 1;
        return lines[line] || '';
    }
    
    function onKeyUp(e) 
    {
        var lastValue = ta._lastValue === undefined ? ta.defaultValue : ta._lastValue,
            change = ta.value.length - lastValue.length;
        ta._lastValue = ta.value;
        if ( !change ) {
            return;
        }
        var caret = ta.selectionStart,
            added = change > 0 && ta.value.substr(caret - change, change) || '',
            removed = change < 0 && lastValue.substr(caret, -change) || '';
        
        var code = e.keyCode;
        var value = ta.value,
            before = value.substr(0, caret),
            after = value.substr(caret),
            lastChar = before.trim().slice(-1),
            nextChar = after.substr(0, 1);
        
        if ( code == 13 ) {
            // Immediately after a {
            if ( lastChar == '{' ) {
                var prevLine = getPrevLine(before),
                    indents = isIndented(prevLine),
                    more = nextChar == '}' ? 0 : 1;
                return addIndent(before, after, indents + more);
            }

            // After an indented line
            var prevLine = getPrevLine(before),
                indents = isIndented(prevLine),
                more = nextChar == '}' ? -1 : 0;
            if ( indents + more > 0 ) {
                addIndent(before, after, indents + more);
            }
        }
        else if ( added == '}' ) {
            removeIndent(before, after);
        }
    }
    
    ta.addEventListener('keyup', onKeyUp, false);
}

var tas = document.querySelectorAll('textarea');
[].forEach.call(tas, function(ta) {
    doAutoIndent(ta, "\t");
});



/*
const electron = require('electron');
const clipboard = electron.clipboard;
clipboard.writeText(document.getElementById('content-editor').value);
`${clipboard.readText()}`           //clipboard content...
*/