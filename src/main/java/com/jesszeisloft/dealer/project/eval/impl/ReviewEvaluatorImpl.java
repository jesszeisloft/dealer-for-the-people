package com.jesszeisloft.dealer.project.eval.impl;

import com.jesszeisloft.dealer.project.eval.ReviewEvaluator;
import com.jesszeisloft.dealer.project.util.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class ReviewEvaluatorImpl implements ReviewEvaluator {

    /**
     *
     * @param allReviews list of all scraped reviews to be evaluated
     * @return top N (NUM_TOP_REVIEWS) based on evaluation criteria
     */
    @Override
    public List<String> evaluateReviews(List<String> allReviews) {
        if(allReviews == null) return Collections.emptyList();
        PriorityQueue<String> pq = new PriorityQueue<>(new ReviewComparator());
        pq.addAll(allReviews);
        List<String> topReviews = new ArrayList<>();
        IntStream.range(0, Math.min(Constants.NUM_TOP_REVIEWS, allReviews.size())).forEach(
                r -> topReviews.add(pq.poll())
        );
        return topReviews;
    }


    /**
     * Comparator to determine which reviews are most enthusiastic
     */
    private static class ReviewComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            int compareExclamations = compareExclamations(s1, s2);
            int compareLength = compareLength(s1, s2);
            return (compareExclamations != 0) ? compareExclamations : compareLength;
        }

        private int compareExclamations(String s1, String s2) {
            long numExclamationPoints1 = s1.chars().filter(c -> c == Constants.EXCLAMATION_POINT).count();
            long numExclamationPoints2 = s2.chars().filter(c -> c == Constants.EXCLAMATION_POINT).count();
            return Math.multiplyExact(
                    Constants.NEGATIVE_ONE, Long.compare(numExclamationPoints1, numExclamationPoints2));
        }

        private int compareLength(String s1, String s2) {
            return Math.multiplyExact(
                    Constants.NEGATIVE_ONE, Integer.compare(s1.length(), s2.length()));
        }

        // add more criteria here to fine tune evaluation logic
    }
}
