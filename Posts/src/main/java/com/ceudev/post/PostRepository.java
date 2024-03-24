package com.ceudev.post;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepository {
    private final Map<Long, Post> postMap = new HashMap<>();
    private long nextPostId = 1;

    // Save a post to the in-memory storage
    public Post save(Post post) {
        if (post.getId() == null) {
            // If the post doesn't have an ID, assign one
            post.setId(nextPostId++);
        }
        postMap.put(post.getId(), post);
        return post;
    }

    // Retrieve a post by ID
    public Optional<Post> findById(Long id) {
        Post post = postMap.get(id);
        if (post == null) {
            return Optional.empty();
        }
        return Optional.of(post);
    }

    // Retrieve all posts
    public List<Post> findAll(Long userId) {
        return postMap.values().stream().filter(post -> Objects.equals(post.getUserId(), userId)).collect(Collectors.toList());
    }

    // Delete a post by ID
    public void deleteById(Long id) {
        postMap.remove(id);
    }
}
