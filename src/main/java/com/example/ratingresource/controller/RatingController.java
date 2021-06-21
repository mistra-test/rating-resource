package com.example.ratingresource.controller;

import com.example.ratingresource.model.Rating;
import com.example.ratingresource.model.RatingDTO;
import com.example.ratingresource.service.RatingService;

import lombok.AllArgsConstructor;
import lombok.Value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Value
@AllArgsConstructor
class RatingListWrapper {
    private List<Rating> ratingList;
}

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired private RatingService ratingService;

    @GetMapping("/{movieId}")
    public RatingListWrapper getRatingByMovieId(@PathVariable Long movieId) {
        return new RatingListWrapper(ratingService.findByMovieId(movieId));
    }

    @GetMapping("/findByUser/{userId}")
    public RatingListWrapper getRatingByUserId(@PathVariable Long userId) {
        return new RatingListWrapper(ratingService.findByUserId(userId));
    }

    @PostMapping()
    public Rating save(@RequestBody RatingDTO dto) {
        return ratingService.save(Rating.from(dto));
    }
}
