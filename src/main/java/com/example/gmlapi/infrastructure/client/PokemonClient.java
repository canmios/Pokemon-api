package com.example.gmlapi.infrastructure.client;

import com.example.gmlapi.infrastructure.pokemon.PokemonClientResponse;

public interface PokemonClient {

    PokemonClientResponse getPokemons(int offset, int limit);

}
