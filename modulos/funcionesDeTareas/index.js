let fs = require('fs');

function lasTareas(){
    let tareas = fs.readFileSync('tareas.json','utf-8')
    tareas = JSON.parse(tareas);
    return tareas;
}

module.exports = {lasTareas};