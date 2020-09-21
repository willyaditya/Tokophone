package com.dao;

import java.util.List;

import com.entity.Review;

public interface ReviewDao {
	public List<Review> getAllReviews();
	public Review getReviewById(String id);
	public int addReview(Review review);
	public int updateReview(Review review);
	public int deleteReview(String id);
}
