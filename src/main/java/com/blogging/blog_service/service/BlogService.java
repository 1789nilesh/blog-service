package com.blogging.blog_service.service;


import com.blogging.blog_service.model.BlogPost;
import com.blogging.blog_service.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<BlogPost> getAllPosts(int page, int size) {
        return blogRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    public BlogPost getPostById(String id) {
        return blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog post not found"));
    }

    public BlogPost createPost(BlogPost blogPost) {
        blogPost.setCreatedAt(LocalDateTime.now());
        return blogRepository.save(blogPost);
    }

    public BlogPost updatePost(String id, BlogPost blogPost) {
        BlogPost existingPost = getPostById(id);
        existingPost.setTitle(blogPost.getTitle());
        existingPost.setContent(blogPost.getContent());
        existingPost.setUpdatedAt(LocalDateTime.now());
        return blogRepository.save(existingPost);
    }

    public void deletePost(String id) {
        blogRepository.deleteById(id);
    }
}