package com.example.ratingresource.controller;

import com.example.ratingresource.model.Rating;
import com.example.ratingresource.model.RatingDTO;
import com.example.ratingresource.service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired private RatingService ratingService;

    @GetMapping("/{movieId}")
    public Flux<Rating> getRatingByMovieId(@PathVariable Long movieId) {
        return ratingService.findByMovieId(movieId);
    }

    @GetMapping("/findByUser/{userId}")
    public Flux<Rating> getRatingByUserId(@PathVariable Long userId) {
        return ratingService.findByUserId(userId);
    }

    @PostMapping()
    public Mono<Rating> save(@RequestBody RatingDTO dto) {
        return ratingService.save(Rating.from(dto));
    }
}
