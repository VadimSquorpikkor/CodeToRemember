package com.sq._java_basic_course.textAnalyser; // Created by SquorpikkoR on 07.02.2017.

class SpamAnalyzer extends KeywordAnalyzer {


    private String[] keywords;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}
