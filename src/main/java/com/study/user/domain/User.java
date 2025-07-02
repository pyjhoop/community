package com.study.user.domain;

import com.study.common.domain.PositiveIntegerCounter;

import java.util.Objects;

public class User {

    private final Long id;
    private final UserInfo userInfo;
    private final PositiveIntegerCounter followingCount;
    private final PositiveIntegerCounter followerCount;

    public User(Long id, UserInfo userInfo) {
        this.id = id;
        this.userInfo = userInfo;
        this.followerCount = new PositiveIntegerCounter();
        this.followingCount = new PositiveIntegerCounter();
    }

    public void follow(User targetUser){
        if(targetUser.equals(this)){
            throw new IllegalArgumentException();
        }

        followingCount.increase();
        targetUser.increaseFollowerCount();
    }

    public void unfollow(User targetUser){
        if(this.equals(targetUser)){
            throw new IllegalArgumentException();
        }

        followingCount.decrease();
        targetUser.decreaseFollowerCount();
    }

    private void increaseFollowerCount(){
        followerCount.increase();
    }

    private void decreaseFollowerCount(){
        followerCount.decrease();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
