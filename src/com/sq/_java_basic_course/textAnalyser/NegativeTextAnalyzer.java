package com.sq._java_basic_course.textAnalyser; // Created by SquorpikkoR on 07.02.2017.

class NegativeTextAnalyzer extends KeywordAnalyzer {

    private String[] keywords = {":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
