package com.ceudev.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/{userId}")
    public List<Post> getAllPosts(@PathVariable Long userId) {
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) throws Exception {
        return postService.getPostById(id);
    }

    @PostMapping
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) throws Exception {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) throws Exception {
        postService.deletePost(id);
    }
}