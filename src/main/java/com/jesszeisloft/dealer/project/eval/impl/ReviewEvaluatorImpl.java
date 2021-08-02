package com.jesszeisloft.dealer.project.eval.impl;

import com.jesszeisloft.dealer.project.eval.ReviewEvaluator;
import com.jesszeisloft.dealer.project.util.Constants;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class ReviewEvaluatorImpl implements ReviewEvaluator {

    @Override
    public List<String> evaluateReviews(List<String> allReviews) {
        PriorityQueue<String> pq = new PriorityQueue<>(new ReviewComparator());
        pq.addAll(allReviews);
        List<String> topReviews = new ArrayList<>();
        IntStream.range(0, Constants.NUM_TOP_REVIEWS).forEach(r -> topReviews.add(pq.poll()));
        return topReviews;
    }

    private static class ReviewComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            long numExclamationPoints1 = s1.chars().filter(c -> c == Constants.EXCLAMATION_POINT).count();
            long numExclamationPoints2 = s2.chars().filter(c -> c == Constants.EXCLAMATION_POINT).count();
            return Math.multiplyExact(Constants.NEGATIVE_ONE, Long.compare(numExclamationPoints1, numExclamationPoints2));
        }
    }
}
