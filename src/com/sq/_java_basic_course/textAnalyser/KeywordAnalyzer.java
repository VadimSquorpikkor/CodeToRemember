package com.sq._java_basic_course.textAnalyser; // Created by SquorpikkoR on 07.02.2017.

abstract class KeywordAnalyzer implements TextAnalyzer {


    @Override
    public Label processText(String text) {
        for (int i = 0; i < getKeywords().length; i++) {
            if (text.contains(getKeywords()[i]))
                return getLabel();
        }
        return Label.OK;
    }

    abstract protected String[] getKeywords();

    abstract protected Label getLabel();
}
