package practice_13.TestTask_4;

import Task_4.Movie;
import Task_4.MovieService;
import Task_4.Rating;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestMovieService {


    @Test
    public void checkAddRatingForMovie() {
        MovieService movieService = new MovieService();
        Movie expectedMovie = new Movie("Movie One", true);
        Rating<Double> expectedRating = new Rating<>(5.0);
        movieService.addRatingForMovie(expectedMovie, expectedRating);
        String actualMovie = movieService.getAll().entrySet().stream()
                .findFirst()
                .map(e -> e.getKey().getName())
                .orElse("Фильмов нет");

        assertFalse(movieService.getAll().isEmpty());
        assertEquals(actualMovie, expectedMovie.getName());
    }
    @Test
    public void checkExceptionAddRatingForMovie() {
        MovieService movieService = new MovieService();
        Movie expectedMovie = new Movie("Movie One", true);
        Rating<Double> expectedRating = new Rating<>(12.0);


        Exception exception = assertThrows(IllegalArgumentException.class,()->{
            movieService.addRatingForMovie(expectedMovie, expectedRating);
        });

        assertEquals("Введите оценку от 1 до 10",exception.getMessage());
    }

    @Test
    public void checkAvgRatingForMovie() {
        MovieService movieService = new MovieService();
        Movie movieOne = new Movie("Movie One", true);
        Movie movieTwo = new Movie("Movie Two", true);
        movieService.addRatingForMovie(movieOne, new Rating<>(10.0));
        movieService.addRatingForMovie(movieOne, new Rating<>(9.4));
        movieService.addRatingForMovie(movieOne, new Rating<>(5.4));
        movieService.addRatingForMovie(movieTwo, new Rating<>(5.0));
        movieService.addRatingForMovie(movieTwo, new Rating<>(2.0));

       double avgMovie  =  movieService.getAvgRatingForMoviesAndSorted().entrySet().stream()
                  .filter(m-> m.getKey().getName().equals("Movie One"))
                  .findFirst()
                  .map(r -> r.getValue())
               .orElse(0.0);

       assertEquals(8.266666666666667,avgMovie);
    }

    @Test
    public void checkSortedRatingForMovie() {
        MovieService movieService = new MovieService();
        Movie movieOne = new Movie("Movie One", true);
        Movie movieTwo = new Movie("Movie Two", true);
        movieService.addRatingForMovie(movieOne, new Rating<>(10.0));
        movieService.addRatingForMovie(movieOne, new Rating<>(9.4));
        movieService.addRatingForMovie(movieOne, new Rating<>(5.4));
        movieService.addRatingForMovie(movieTwo, new Rating<>(5.0));
        movieService.addRatingForMovie(movieTwo, new Rating<>(2.0));

        List<Double> avgList =  movieService.getAvgRatingForMoviesAndSorted().entrySet().stream()
                .map(r -> r.getValue())
                        .collect(Collectors.toList());

        List<Double> avgListSorted = avgList.stream()
                .sorted((e1,e2) -> Double.compare(e2,e1))
                        .collect(Collectors.toList());


        assertEquals(avgList.get(0),8.266666666666667);
        assertEquals(avgList.get(1),3.5);
        assertEquals(avgList,avgListSorted);

    }


}
