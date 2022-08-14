<template>

    <li v-for="(pokemon, index) in pokemons" :key="index" class="cards col-2">
        <Card>
            <template #header>
                <img :alt="pokemon.name" :src="pokemon.img" class="img">
            </template>

            <template #title>
                {{ pokemon.name }}
            </template>

            <template #content>
                <h4 class="subtitle"> Type: </h4>
                <li v-for="(type, index) in pokemon.types" :key="index" class="types">
                    <span class="description-item">{{ type.type.name }}</span>
                </li>                
                <h4 class="subtitle"> Abilities: </h4>
                <li v-for="(ability, index) in pokemon.abilities" :key="index" class="abilities">
                    <span class="description-item">{{ ability.ability.name }}</span>
                </li>
            </template>
            <template #footer>

            </template>
        </Card>
    </li>
</template>

<script>

import PokeApiService from '@/Services/PokeApiService';

export default {
    name: 'AsistenciaEmpleado',
    data() {
        return {
            pokemons: [],
        }
    },
    pokeApiService: null,
    created() {
        this.pokeApiService = new PokeApiService();
    },
    mounted() {
        this.pintarPokemons()

    },

    methods: {
        getId() {
            this.id = this.$route.params.id;
            return this.id;
        },
        async pintarPokemons() {
            await this.pokeApiService.getData().then(response => {
                response.data.results.forEach(element => {
                    this.pokeApiService.getDataAccurate(element.url).then(res => {
                        let pokemon = {
                            name: "",
                            img: "",
                            types: null,
                            abilities: null
                        }
                        pokemon.img = res.data.sprites.other.dream_world.front_default;
                        pokemon.name = element.name;
                        pokemon.types = res.data.types;
                        pokemon.abilities = res.data.abilities;
                        this.pokemons.push(pokemon);
                    })
                });

            })
        }
    }

}

</script>

<style>
.description-item {
    padding: 3px;
    border: 1px rgb(100, 97, 97) solid;
    border-radius: 5px;
}

.p-card {
    width: 20%;
}

.cards {
    display: inline-block;
    width: 100%;
    margin: 25px;
    list-style: none;
}

.p-card-header {
    width: 5rem;

}

.p-card-header img {
    margin-top: 15px;
    margin-left: 75px;
}


.p-card-content {
    text-align: left;
}

.subtitle {
    margin: 0 0 5px 10px;
}

.types {
    display: inline-block;
    margin: 0 5px 15px 25px;
}

.abilities {
    display: inline-block;
    margin: 0 0 15px 25px;
}
</style>