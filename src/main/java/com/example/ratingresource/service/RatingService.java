package com.example.ratingresource.service;

import com.example.ratingresource.model.Rating;
import com.example.ratingresource.repository.RatingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired private RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> findByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    public List<Rating> findByUserIds(List<Long> userIdList) {
        return ratingRepository.findByUserIdIn(userIdList);
    }

    public List<Rating> findByMovieId(Long movieId) {
        return ratingRepository.findByMovieId(movieId);
    }

    public Rating save(Rating rating) {
        ratingRepository.findByMovieId(rating.getMovieId()).stream()
                .filter(r -> r.getUserId().equals(rating.getUserId()))
                .findAny()
                .ifPresent(r -> rating.setId(r.getId()));
        return ratingRepository.save(rating);
    }
}
