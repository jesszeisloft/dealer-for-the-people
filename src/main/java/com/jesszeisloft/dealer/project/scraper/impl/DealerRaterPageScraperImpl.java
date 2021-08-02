package com.jesszeisloft.dealer.project.scraper.impl;

import com.jesszeisloft.dealer.project.scraper.DealerRaterPageScraper;
import com.jesszeisloft.dealer.project.util.Constants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DealerRaterPageScraperImpl implements DealerRaterPageScraper {
    private final Logger logger = LogManager.getLogger(getClass());

    private static final String DEALER_REVIEW_PAGE_URL =
            Constants.DEALER_RATE_BASE_URL + Constants.MCKAIG_CHEVROLET_REVIEW_ENDPOINT + Constants.PAGE;

    /**
     *
     * @return scraped reviews from first N (TOTAL_PAGES) pages of dealer URL
     */
    @Override
    public List<String> getReviews() {
        List<String> allReviews = new ArrayList<>();

        IntStream.range(1, Constants.TOTAL_PAGES + 1).forEach(r -> {
            try {
                allReviews.addAll(fetchReviewForPage(r));
            } catch (IOException e) {
                logger.log(Level.ERROR, "Unable to scrape reviews page " + r, e);
            }
        });

        return allReviews;
    }

    /**
     *
     * @param pageNum page to fetch review from
     * @return List of text elements of the reviews for the pageNum page
     * @throws IOException on .get() if remote call to request URL fails
     */
    private List<String> fetchReviewForPage(int pageNum) throws IOException {
        Document doc = Jsoup.connect(DEALER_REVIEW_PAGE_URL + pageNum).get();
        Elements elements = doc.select(Constants.REVIEW_CSS_QUERY);
        return elements.stream().map(Element::text).collect(Collectors.toList());
    }
}
