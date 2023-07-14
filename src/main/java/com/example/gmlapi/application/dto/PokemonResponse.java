package com.example.gmlapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonResponse {

    public int count;
    public String next;
    public Object previous;
    public ArrayList<Pokemon> results;

}
