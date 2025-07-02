package com.study.post.domain;

import com.study.common.domain.PositiveIntegerCounter;
import com.study.post.domain.content.PostContent;
import com.study.post.domain.content.PostPublicationState;
import com.study.user.domain.User;

public class Post {

    private final Long id;
    private final User author;
    private final PostContent content;
    private final PositiveIntegerCounter likeCount;
    private PostPublicationState state;

    public Post(Long id, User author, PostContent content) {
        if(author == null) throw new IllegalArgumentException();

        this.id = id;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
        this.state = PostPublicationState.PUBLIC;
    }

    public void like(User user) {
        if(this.author.equals(user)) throw new IllegalArgumentException();
        likeCount.increase();
    }

    public void unlike() {
        likeCount.decrease();
    }

    public void updatePost(User user, String updateContent, PostPublicationState state) {
        if(!this.author.equals(user)) throw new IllegalArgumentException();

        this.state = state;
        this.content.updateContent(updateContent);
    }
}
