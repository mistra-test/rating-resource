package com.example.ratingresource.repository;

import com.example.ratingresource.model.Rating;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import reactor.core.publisher.Flux;

public interface RatingRepository extends ReactiveSortingRepository<Rating, Long> {
    Flux<Rating> findByUserId(Long userId);

    Flux<Rating> findByMovieId(Long movieId);
}
