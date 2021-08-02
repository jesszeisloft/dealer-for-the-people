package com.jesszeisloft.dealer.project.config;

import com.google.inject.AbstractModule;
import com.jesszeisloft.dealer.project.client.DealerRaterPageScraper;
import com.jesszeisloft.dealer.project.client.impl.DealerRaterPageScraperImpl;
import com.jesszeisloft.dealer.project.eval.ReviewEvaluator;
import com.jesszeisloft.dealer.project.eval.impl.ReviewEvaluatorImpl;
import com.jesszeisloft.dealer.project.facilitate.FacilitatorFactory;
import com.jesszeisloft.dealer.project.util.PrinterUtil;
import com.jesszeisloft.dealer.project.util.impl.PrinterUtilImpl;

public class DealerModule extends AbstractModule {


    @Override
    protected void configure() {
        bind(ReviewEvaluator.class).to(ReviewEvaluatorImpl.class).asEagerSingleton();
        bind(DealerRaterPageScraper.class).to(DealerRaterPageScraperImpl.class).asEagerSingleton();
        bind(PrinterUtil.class).to(PrinterUtilImpl.class).asEagerSingleton();

        requestStaticInjection(FacilitatorFactory.class);
    }
}
