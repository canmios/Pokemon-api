package com.example.gmlapi.service;

import com.example.gmlapi.infrastructure.client.PokemonClientAdapter;
import com.example.gmlapi.infrastructure.pokemon.PokemonClientResponse;
import com.example.gmlapi.util.UtilDataClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PokemonServiceIAdapterTest {

    @Mock
    private PokemonServiceAdapter pokemonServiceAdapter;

    @Mock
    private PokemonClientAdapter pokemonClientAdapter;

    private PokemonClientResponse pokemonClientResponse;

    @BeforeEach
    public void setUp() {
        pokemonServiceAdapter = mock(PokemonServiceAdapter.class);
        pokemonClientAdapter = mock(PokemonClientAdapter.class);

        pokemonClientResponse = UtilDataClass.createPokemonClientResponse();

    }

    @Test
    void getPokemonClientFromService() {
        when(pokemonServiceAdapter.getAllPokemons(anyInt(), anyInt()))
                .thenReturn(pokemonClientResponse);

        when(pokemonClientAdapter.getPokemons(anyInt(), anyInt()))
                .thenReturn(pokemonClientResponse);

        assertEquals(pokemonClientResponse, pokemonClientAdapter.getPokemons(anyInt(), anyInt()));

    }
}
