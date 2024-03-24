package com.ceudev.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) throws Exception {
        return postRepository.findById(id)
                .orElseThrow(() -> new Exception("com.ceudev.post.Post not found with id " + id));
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post post) throws Exception {
        getPostById(id);
        post.setId(id);
        return postRepository.save(post);
    }

    public void deletePost(Long id) throws Exception {
        getPostById(id); // Check if the post exists
        postRepository.deleteById(id);
    }
}