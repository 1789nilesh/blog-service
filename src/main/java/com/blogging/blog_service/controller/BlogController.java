package com.blogging.blog_service.controller;

import com.blogging.blog_service.model.BlogPost;
import com.blogging.blog_service.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/posts")
    public List<BlogPost> getAllPosts(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        return blogService.getAllPosts(page, size);
    }

    @GetMapping("/posts/{id}")
    public BlogPost getPostById(@PathVariable String id) {
        return blogService.getPostById(id);
    }

    @PostMapping("/posts")
    public BlogPost createPost(@RequestBody BlogPost blogPost) {
        return blogService.createPost(blogPost);
    }

    @PutMapping("/posts/{id}")
    public BlogPost updatePost(@PathVariable String id, @RequestBody BlogPost blogPost) {
        return blogService.updatePost(id, blogPost);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable String id) {
        blogService.deletePost(id);
    }
}