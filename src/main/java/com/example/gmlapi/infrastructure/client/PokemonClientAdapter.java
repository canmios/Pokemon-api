package com.example.gmlapi.infrastructure.client;

import com.example.gmlapi.infrastructure.pokemon.PokemonClientResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class PokemonClientAdapter implements PokemonClient {

    private final FeignPokemonClient feignPokemonClient;

    @Override
    public PokemonClientResponse getPokemons(int offset, int limit) {
       return feignPokemonClient.getPokemons(offset, limit);
    }
}
