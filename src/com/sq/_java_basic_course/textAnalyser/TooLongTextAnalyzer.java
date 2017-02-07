package com.sq._java_basic_course.textAnalyser; // Created by SquorpikkoR on 07.02.2017.

class TooLongTextAnalyzer implements TextAnalyzer {
    @Override
    public Label processText(String text) {
        if(text.length()>maxLength)return Label.TOO_LONG;
        else return Label.OK;
    }

    private int maxLength;

    public TooLongTextAnalyzer(int maxLenght) {
        this.maxLength = maxLenght;
    }
}
