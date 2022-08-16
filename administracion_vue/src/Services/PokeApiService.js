const axios = require('axios');

export default class PokeApiService {
    // url = "https://pokeapi.co/api/v2/pokemon/150"
    url = "https://pokeapi.co/api/v2/pokemon/"

    getData(){
        return new Promise((resolve)=>{
            resolve(axios.get(this.url));
        });
    }

    getDataAccurate(urlPokemon){
        return new Promise((resolve)=>{
            resolve(axios.get(urlPokemon));
        });
    }

}