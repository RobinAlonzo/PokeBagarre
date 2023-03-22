package com.montaury.pokebagarre.metier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void le_premier_pokemon_gagne_grace_a_une_meilleur_attaque() {
        Pokemon pokemon1 = new Pokemon("PokemonUn", "", new Stats(5, 2));
        Pokemon pokemon2 = new Pokemon("PokemonDeux", "", new Stats(3, 2));
        assertTrue(pokemon1.estVainqueurContre(pokemon2));
    }

    @Test
    void le_second_pokemon_gagne_grace_a_une_meilleur_attaque() {
        Pokemon pokemon1 = new Pokemon("PokemonUn", "", new Stats(3, 2));
        Pokemon pokemon2 = new Pokemon("PokemonDeux", "", new Stats(5, 2));
        assertFalse(pokemon1.estVainqueurContre(pokemon2));
    }

    @Test
    void le_premier_pokemon_gagne_grace_a_une_meilleur_defense() {
        Pokemon pokemon1 = new Pokemon("PokemonUn", "", new Stats(5, 3));
        Pokemon pokemon2 = new Pokemon("PokemonDeux", "", new Stats(5, 2));
        assertTrue(pokemon1.estVainqueurContre(pokemon2));
    }

    @Test
    void le_second_pokemon_gagne_grace_a_une_meilleur_defense() {
        Pokemon pokemon1 = new Pokemon("PokemonUn", "", new Stats(5, 5));
        Pokemon pokemon2 = new Pokemon("PokemonDeux", "", new Stats(5, 6));
        assertFalse(pokemon1.estVainqueurContre(pokemon2));
    }

    @Test
    void le_premier_pokemon_gagne_car_meme_stats() {
        Pokemon pokemon1 = new Pokemon("PokemonUn", "", new Stats(5, 5));
        Pokemon pokemon2 = new Pokemon("PokemonDeux", "", new Stats(5, 5));
        assertTrue(pokemon1.estVainqueurContre(pokemon2));
    }
}