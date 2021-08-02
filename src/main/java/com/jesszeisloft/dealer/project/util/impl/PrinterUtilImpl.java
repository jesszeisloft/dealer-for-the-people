package com.jesszeisloft.dealer.project.util.impl;

import com.jesszeisloft.dealer.project.util.Constants;
import com.jesszeisloft.dealer.project.util.PrinterUtil;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.IntStream;

public class PrinterUtilImpl implements PrinterUtil {
    private final Logger logger = LogManager.getLogger(getClass());

    /**
     * Prints the top N (NUM_TOP_REVIEWS) reviews if enough reviews exists,
     *  otherwise prints all reviews.
     * @param reviews list of reviews to be printed
     */
    @Override
    public void printTopReviews(List<String> reviews) {
        IntStream.range(0, Math.min(Constants.NUM_TOP_REVIEWS, reviews.size())).forEach(
                r -> logger.log(Level.INFO, (r + 1) + ". " + reviews.get(r))
        );
    }
}
