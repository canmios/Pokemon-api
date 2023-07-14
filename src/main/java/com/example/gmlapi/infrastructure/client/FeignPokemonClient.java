package com.example.gmlapi.infrastructure.client;

import com.example.gmlapi.infrastructure.pokemon.PokemonClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "pokemon-api", url = "https://pokeapi.co/api/v2")
public interface FeignPokemonClient {

    @GetMapping("/pokemon")
    PokemonClientResponse getPokemons(@RequestParam(defaultValue = "0") int offset,
                                      @RequestParam(defaultValue = "10") int limit);

}
