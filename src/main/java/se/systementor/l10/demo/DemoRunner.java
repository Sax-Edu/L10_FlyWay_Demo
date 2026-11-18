package se.systementor.l10.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.systementor.l10.repository.PokemonRepository;

@Component
public class DemoRunner implements CommandLineRunner {

    private final PokemonRepository pokemonRepository;

    public DemoRunner(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("\n=== Pokémon som lästs från PostgreSQL ===");
        pokemonRepository.findAll().forEach(System.out::println);
        System.out.println("\nFlyway har kontrollerat och tillämpat tillgängliga migrationer före JPA-kontrollen.");
    }
}
