package com.example.gmlapi.service;


import com.example.gmlapi.infrastructure.pokemon.PokemonClientResponse;

public interface PokemonService {

    PokemonClientResponse getAllPokemons(int offset, int limit);

}