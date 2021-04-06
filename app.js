let funcionesDeTareas = require('./modulos/funcionesDeTareas');
let lasTareas = funcionesDeTareas.lasTareas;

let argumento = process.argv[2];

console.log(lasTareas());


switch (argumento){
    case 'listar':
        console.log(lasTareas());
        break;
    case undefined:
        console.log('---------------------------------------');
        console.log('Atención - Tienes que pasar una acción.');
        console.log('---------------------------------------');
        break;
    default:
        console.log('------------------------------');
        console.log('No entiendo qué quieres hacer.');
        console.log('------------------------------');
}
