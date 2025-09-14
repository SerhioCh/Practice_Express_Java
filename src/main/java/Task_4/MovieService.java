package Task_4;

import java.util.*;
import java.util.stream.Collectors;

public class MovieService {
    Map<Movie, List<Rating>>  ratingMovies = new HashMap<>();


    public Map <Movie, List<Rating>> getAll (){
        return Map.copyOf(ratingMovies);
    }


    public synchronized void addRatingForMovie(Movie movie, Rating rating){

        if (rating.getRating().doubleValue()>=1&&rating.getRating().doubleValue()<=10){
            List<Rating> ratings = ratingMovies.getOrDefault(movie,new ArrayList<>());
            ratings.add(rating);
            ratingMovies.put(movie,ratings);
        }
        else {
            throw  new IllegalArgumentException("Введите оценку от 1 до 10");
        }
    }

    public Map <Movie,Double> getAvgRatingForMoviesAndSorted(){
      return   ratingMovies.entrySet().stream()
               .map(e -> {
                  Movie movie = e.getKey();
                  double avgRating = e.getValue().stream()
                          .mapToDouble(r -> r.getRating().doubleValue())
                          .average()
                          .orElse(0.0);
                  return Map.entry(movie,avgRating);
               })
               .sorted((e1,e2) -> Double.compare(e2.getValue(),e1.getValue()))
               .collect(Collectors.toMap(
                       Map.Entry::getKey,
                       Map.Entry::getValue,
                       (oldValue,newValue) -> oldValue,
                       LinkedHashMap::new
               ));
    }
}
