package com.example.ratingresource.service;

import com.example.ratingresource.model.Rating;
import com.example.ratingresource.repository.RatingRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    public Flux<Rating> findByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    public Flux<Rating> findByMovieId(Long movieId) {
        return ratingRepository.findByMovieId(movieId);
    }

    public Mono<Rating> save(Rating rating) {
        return ratingRepository
                .findByMovieId(rating.getMovieId())
                .filter(r -> r.getUserId().equals(rating.getUserId()))
                .next()
                .map(r -> this.updateRatingId(r, rating))
                .defaultIfEmpty(rating)
                .flatMap(ratingRepository::save);
    }

    private Rating updateRatingId(Rating promised, Rating actual) {
        log.info(promised);
        log.info(actual);
        actual.setId(promised.getId());
        return actual;
    }
}
