package com.montaury.pokebagarre.metier;

import com.montaury.pokebagarre.erreurs.ErreurMemePokemon;
import com.montaury.pokebagarre.erreurs.ErreurPokemonNonRenseigne;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BagarreTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void les_deux_pokemons_meme_nom() {
        Pokemon pokemon1 = new Pokemon("Pikachu", "", new Stats(5, 2));
        Pokemon pokemon2 = new Pokemon("Pikachu", "", new Stats(3, 2));
        Bagarre bagarre = new Bagarre();

        var erreur = catchThrowable(() -> bagarre.demarrer(pokemon1.getNom(), pokemon2.getNom()));

        assertThat(erreur)
                .isInstanceOf(ErreurMemePokemon.class)
                .hasMessage("Impossible de faire se bagarrer un pokemon avec lui-meme");
    }

    @Test
    void premier_nom_vide() {
        Pokemon pokemon1 = new Pokemon("", "", new Stats(5, 2));
        Pokemon pokemon2 = new Pokemon("Raichu", "", new Stats(3, 2));
        Bagarre bagarre = new Bagarre();

        var erreur = catchThrowable(() -> bagarre.demarrer(pokemon1.getNom(), pokemon2.getNom()));
        var position = "premier";

        assertThat(erreur)
                .isInstanceOf(ErreurPokemonNonRenseigne.class)
                .hasMessage("Le " + position + " pokemon n'est pas renseigne");
    }

    @Test
    void second_nom_vide() {
        Pokemon pokemon1 = new Pokemon("Pikachu", "", new Stats(5, 2));
        Pokemon pokemon2 = new Pokemon("", "", new Stats(3, 2));
        Bagarre bagarre = new Bagarre();

        var erreur = catchThrowable(() -> bagarre.demarrer(pokemon1.getNom(), pokemon2.getNom()));
        var position = "second";

        assertThat(erreur)
                .isInstanceOf(ErreurPokemonNonRenseigne.class)
                .hasMessage("Le " + position + " pokemon n'est pas renseigne");
    }


}