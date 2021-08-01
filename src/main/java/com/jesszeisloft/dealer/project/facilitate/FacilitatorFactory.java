package com.jesszeisloft.dealer.project.facilitate;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class FacilitatorFactory {
    @Inject
    private static Provider<Facilitator> facilitatorProvider;

    public static Facilitator getInstance(){
        return facilitatorProvider.get();
    }

}
