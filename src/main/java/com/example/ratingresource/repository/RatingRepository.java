package com.example.ratingresource.repository;

import com.example.ratingresource.model.Rating;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUserId(Long userId);

    List<Rating> findByUserIdIn(List<Long> userIdList);

    List<Rating> findByMovieId(Long movieId);
}
