package br.com.alura.screenmatch.repository;

import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);


    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, Double avaliacao);


    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero (Categoria categoria);
//    O desafio será fazer uma derived query onde podemos fazer uma busca pelas séries que tenham até
//    um número máximo de temporadas e com uma avaliação maior ou igual a um determinado valor.

    List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(Integer numeroTemporadas, Double avaliaçoes);
}
