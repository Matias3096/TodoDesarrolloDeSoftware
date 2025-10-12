// Definimos una funcion asíncrona
async function obtenerPersonajeSimpsons() {
    try {
        //Hacer la peticion
        const response = await fetch ("https://thesimpsonsapi.com/api/characters/random");

        //Verificar si la respuesta fue exitosa
        if (!response.ok){
            
        }
        
    }    
}