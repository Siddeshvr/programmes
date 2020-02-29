//module to start detector...
function start()
{     
  const { spawn } = require('child_process');
  const child = spawn('python3', ['drowsiness_detection.py']);

  child.on('close', (code, signal) => {
    console.log(
    `child process terminated due to receipt of signal ${signal}`);
  });
};

document.getElementById('start').addEventListener('click',function()
{
  start();
},false);


//module to stop detector...
function stop() 
{ 
	var spawn = require("child_process").spawn; 
	
	var process = spawn('python3',["./bi.py"] ); 

	process.stdout.on('data', function(data) { 
        console.log(data.toString());
	} ) 
} 

document.getElementById('stop').addEventListener('click',function()
{
  stop();
},false);


//module to end detection...
const remote = require('electron').remote
const path = require("path"); 
document.getElementById("quit").addEventListener("click",()=>{
    var window = remote.getCurrentWindow()
    window.close();
},false);

