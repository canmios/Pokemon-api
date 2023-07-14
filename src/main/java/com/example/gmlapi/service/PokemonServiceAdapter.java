package com.example.gmlapi.service;

import com.example.gmlapi.infrastructure.client.PokemonClientAdapter;
import com.example.gmlapi.infrastructure.pokemon.PokemonClientResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PokemonServiceAdapter implements PokemonService {

    private final PokemonClientAdapter pokemonProviderClient;

    @Override
    public PokemonClientResponse getAllPokemons(int offset, int limit) {
        return pokemonProviderClient.getPokemons(offset, limit);
    }

}
