package com.study.post.domain.content;

public class PostContent extends Content {

    private static final int MIN_POST_LENGTH = 5;
    private static final int MAX_POST_LENGTH = 500;

    public PostContent(String content) {
        super(content);

    }

    @Override
    protected void checkText(String text) {
        if(text == null || text.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if(text.length() > MAX_POST_LENGTH) {
            throw new IllegalArgumentException();
        }

        if(text.length() < MIN_POST_LENGTH) {
            throw new IllegalArgumentException();
        }

    }

}
