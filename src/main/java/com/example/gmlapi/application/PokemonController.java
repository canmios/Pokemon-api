package com.example.gmlapi.application;

import com.example.gmlapi.application.dto.PokemonResponse;
import com.example.gmlapi.application.mapper.PokemonMapper;
import com.example.gmlapi.service.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    private final PokemonMapper pokemonMapper = PokemonMapper.INSTANCE;


    @Operation(summary =  "Get Pokemons", description = "Get list of pokemons /" +
            " pagination by default 0 - 10")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pokemons found",content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PokemonResponse.class)) }),
            @ApiResponse(responseCode = "404", description = "No clones found", content = @Content)
    })
    @GetMapping
    public PokemonResponse getPokemons(@RequestParam(defaultValue = "0") int offset,
                                             @RequestParam(defaultValue = "10") int limit) {

        return pokemonMapper.toPokemonResponse(pokemonService.getAllPokemons(offset, limit));
    }

}
