package com.example.ratingresource.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating implements Serializable {

    @Id private Long id;

    private Long userId;
    private Long movieId;
    private int score;

    public static Rating from(RatingDTO dto) {
        var rating = new Rating();
        rating.id = dto.getId();
        rating.userId = dto.getUserId();
        rating.movieId = dto.getMovieId();
        rating.score = dto.getScore();
        return rating;
    }
}
