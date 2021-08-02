package com.jesszeisloft.dealer.project.eval.impl;

import com.jesszeisloft.dealer.project.eval.ReviewEvaluator;
import com.jesszeisloft.dealer.project.util.Constants;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReviewEvaluatorImplTest {
    private final String EXCLAMATIONS_1 = "!";
    private final String EXCLAMATIONS_2 = "!!";
    private final String EXCLAMATIONS_3 = "!!!";
    private final String EXCLAMATIONS_4 = "!!!!";
    private final String EXCLAMATIONS_5 = "!!!!!";
    private final String EXCLAMATIONS_6 = "!!!!!!";
    private final String EXCLAMATIONS_7 = "!!!!!!!";
    private final String LENGTH_TIEBREAKER = "abc!!!!!";

    private final ReviewEvaluator evaluator = new ReviewEvaluatorImpl();

    @Test
    void test_prioritizeByNumberOfExclamationPoints() {
        List<String> allReviews = Arrays.asList(
                EXCLAMATIONS_1,
                EXCLAMATIONS_2,
                EXCLAMATIONS_3,
                EXCLAMATIONS_4,
                EXCLAMATIONS_5,
                EXCLAMATIONS_6,
                EXCLAMATIONS_7
        );

        List<String> reviews = evaluator.evaluateReviews(allReviews);

        assertEquals(Constants.NUM_TOP_REVIEWS, reviews.size());
        assertEquals(EXCLAMATIONS_7, reviews.get(0));
        assertEquals(EXCLAMATIONS_6, reviews.get(1));
        assertEquals(EXCLAMATIONS_5, reviews.get(2));
    }

    @Test
    void test_lengthTiebreaker() {
        List<String> allReviews = Arrays.asList(
                EXCLAMATIONS_1,
                EXCLAMATIONS_2,
                EXCLAMATIONS_3,
                EXCLAMATIONS_4,
                EXCLAMATIONS_5,
                EXCLAMATIONS_6,
                EXCLAMATIONS_7,
                LENGTH_TIEBREAKER
        );

        List<String> reviews = evaluator.evaluateReviews(allReviews);

        assertEquals(Constants.NUM_TOP_REVIEWS, reviews.size());
        assertEquals(EXCLAMATIONS_7, reviews.get(0));
        assertEquals(EXCLAMATIONS_6, reviews.get(1));
        assertEquals(LENGTH_TIEBREAKER, reviews.get(2));
    }

    @Test
    void test_allSameReview() {
        List<String> allReviews = Arrays.asList(
                EXCLAMATIONS_1,
                EXCLAMATIONS_1,
                EXCLAMATIONS_1,
                EXCLAMATIONS_1
        );

        List<String> reviews = evaluator.evaluateReviews(allReviews);

        assertEquals(Constants.NUM_TOP_REVIEWS, reviews.size());
        assertEquals(EXCLAMATIONS_1, reviews.get(0));
        assertEquals(EXCLAMATIONS_1, reviews.get(1));
        assertEquals(EXCLAMATIONS_1, reviews.get(2));
    }

    @Test
    void test_fewerResultsThanNumTopReviews() {
        List<String> allReviews = Arrays.asList(
                EXCLAMATIONS_6,
                EXCLAMATIONS_7
        );

        List<String> reviews = evaluator.evaluateReviews(allReviews);

        assertEquals(allReviews.size(), reviews.size());
        assertEquals(EXCLAMATIONS_7, reviews.get(0));
        assertEquals(EXCLAMATIONS_6, reviews.get(1));
    }

    @Test
    void test_noReviews() {
        List<String> reviews = evaluator.evaluateReviews(Collections.emptyList());
        assertTrue(reviews.isEmpty());
    }

    @Test
    void test_nullInput() {
        List<String> reviews = evaluator.evaluateReviews(null);
        assertTrue(reviews.isEmpty());
    }
}
