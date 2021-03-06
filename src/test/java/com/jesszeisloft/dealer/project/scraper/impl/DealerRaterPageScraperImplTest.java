package com.jesszeisloft.dealer.project.scraper.impl;

import com.jesszeisloft.dealer.project.scraper.DealerRaterPageScraper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealerRaterPageScraperImplTest {
    private final DealerRaterPageScraper pageScraper = new DealerRaterPageScraperImpl();

    @Test
    void test_scrapePages() {
        List<String> pages = pageScraper.getReviews();
        assertFalse(pages.isEmpty());
    }
}
