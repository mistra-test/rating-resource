package com.example.ratingresource.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Rating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long movieId;
    private int score;

    public static Rating from(RatingDTO dto) {
        Rating rating = new Rating();
        rating.id = dto.getId();
        rating.userId = dto.getUserId();
        rating.movieId = dto.getMovieId();
        rating.score = dto.getScore();
        return rating;
    }
}
