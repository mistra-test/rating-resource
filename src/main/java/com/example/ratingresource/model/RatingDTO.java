package com.example.ratingresource.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@Value
@AllArgsConstructor
public class RatingDTO implements Serializable {
    private Long id;
    private Long userId;
    private Long movieId;
    private int score;
}
