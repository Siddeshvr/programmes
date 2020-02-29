console.log("Wake-up Alerter !");

const electron = require("electron");
const app = electron.app;
const BrowserWindow = electron.BrowserWindow;
const path = require("path");
const url = require("url");
const Menu = electron.Menu;
const nativeImage = electron.nativeImage;

let demoIcon = nativeImage.createFromPath(path.join(__dirname,'Appicon.png'));
let win;

function createWindow()
{
    win = new BrowserWindow({ width: 1365, height: 820, icon: demoIcon});
    win.loadURL(url.format({
        pathname: path.join(__dirname,'./NewFront/index.html'),
        protocol: 'file',
        slashes: true
    }));

    win.on('closed',() =>{
        win = null;
    })
}

app.on('ready',function(){
    createWindow();
    const template = [
        {
            label: 'Welcome'
        }
    ]
    const menu = Menu.buildFromTemplate(template);
    Menu.setApplicationMenu(menu);
});
