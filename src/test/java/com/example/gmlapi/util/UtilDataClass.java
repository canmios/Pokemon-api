package com.example.gmlapi.util;

import com.example.gmlapi.infrastructure.pokemon.Pokemon;
import com.example.gmlapi.infrastructure.pokemon.PokemonClientResponse;

import java.util.ArrayList;
import java.util.Collections;

public final class UtilDataClass {

    public static PokemonClientResponse createPokemonClientResponse() {
        return PokemonClientResponse.builder()
                .count(1)
                .next("test")
                .previous("object")
                .results(new ArrayList<>(Collections.singleton(new Pokemon("test", "test"))))
                .build();
    }
}
