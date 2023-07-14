package com.example.gmlapi.application.mapper;

import com.example.gmlapi.application.dto.PokemonResponse;
import com.example.gmlapi.infrastructure.pokemon.PokemonClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PokemonMapper {

    PokemonMapper INSTANCE = Mappers.getMapper(PokemonMapper.class);

    PokemonResponse toPokemonResponse(PokemonClientResponse pokemonClientResponse);
}
