package com.example.gmlapi.application.controller;

import com.example.gmlapi.application.PokemonController;
import com.example.gmlapi.application.dto.PokemonResponse;
import com.example.gmlapi.application.mapper.PokemonMapper;
import com.example.gmlapi.infrastructure.pokemon.PokemonClientResponse;
import com.example.gmlapi.service.PokemonService;
import com.example.gmlapi.util.UtilDataClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class PokemonControllerTest {

    @Mock
    private PokemonService pokemonService;

    private PokemonMapper pokemonMapper;

    @InjectMocks
    private PokemonController pokemonController;

    private PokemonClientResponse pokemonClientResponse;

    @BeforeEach
    public void setUp() {
        pokemonService = mock(PokemonService.class);
        pokemonMapper = mock(PokemonMapper.class);

        pokemonController = new PokemonController(pokemonService);
        pokemonClientResponse = UtilDataClass.createPokemonClientResponse();
    }

    @Test
    public void testGetPokemon() {
        when(pokemonService.getAllPokemons(anyInt(),anyInt()))
                .thenReturn(pokemonClientResponse);

        PokemonResponse pokemonResponse = pokemonController.getPokemons(anyInt(),anyInt());

        lenient().when(pokemonMapper.toPokemonResponse(pokemonClientResponse)).thenReturn(pokemonResponse);
        assertEquals(pokemonClientResponse.getCount(), pokemonResponse.getCount());
        assertEquals(pokemonClientResponse.getNext(), pokemonResponse.getNext());
        assertEquals(pokemonClientResponse.getPrevious(), pokemonResponse.getPrevious());
        assertEquals(pokemonClientResponse.getResults().get(0).name, pokemonResponse.getResults().get(0).name);
        assertEquals(pokemonClientResponse.getResults().get(0).url, pokemonResponse.getResults().get(0).url);
    }
}