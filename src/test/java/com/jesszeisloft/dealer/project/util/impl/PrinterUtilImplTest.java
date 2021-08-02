package com.jesszeisloft.dealer.project.util.impl;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrinterUtilImplTest {

    private final PrinterUtilImpl printerUtil = new PrinterUtilImpl();
    private final String REVIEW = "abc";


    @Test
    void test_exceptionCheckInputSizeEqualToNumTopReviews() {
        List<String> reviews = Arrays.asList(REVIEW, REVIEW, REVIEW);
        boolean throwsException = false;
        try {
            printerUtil.printTopReviews(reviews);
        } catch (Exception e) {
            throwsException = true;
        }
        assertFalse(throwsException);
    }

    @Test
    void test_exceptionCheckInputSizeLessThanNumTopReviews() {
        List<String> reviews = Collections.singletonList(REVIEW);
        boolean throwsException = false;
        try {
            printerUtil.printTopReviews(reviews);
        } catch (Exception e) {
            throwsException = true;
        }
        assertFalse(throwsException);
    }

    @Test
    void test_exceptionCheckEmpty() {
        boolean throwsException = false;
        try {
            printerUtil.printTopReviews(Collections.emptyList());
        } catch (Exception e) {
            throwsException = true;
        }
        assertFalse(throwsException);
    }

    @Test
    void test_exceptionCheckNull() {
        boolean throwsException = false;
        try {
            printerUtil.printTopReviews(null);
        } catch (Exception e) {
            throwsException = true;
        }
        assertFalse(throwsException);
    }
}