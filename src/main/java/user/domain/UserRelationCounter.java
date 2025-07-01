package user.domain;

public class UserRelationCounter {

    private int count;

    public UserRelationCounter() {
    }

    public void increase() {
        this.count++;
    }

    public void decrease() {
        if(count <= 0){
            return;
        }
        this.count--;
    }
}
