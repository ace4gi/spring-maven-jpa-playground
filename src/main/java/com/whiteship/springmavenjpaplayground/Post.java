package com.whiteship.springmavenjpaplayground;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {
    @Id @GeneratedValue
    private Long id;

    private String title;

    /**
     * @fetch
     * eager -> 현재
     * lazy -> 나중에
     * default lazy
     */
    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
    private Set<Comment> comments = new HashSet();

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public void addComment (Comment comment) {
        this.getComments().add(comment);
        comment.setPost(this);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Comment> getComments() {
        return comments;
    }
}
