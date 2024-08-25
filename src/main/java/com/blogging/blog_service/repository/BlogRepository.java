package com.blogging.blog_service.repository;



import com.blogging.blog_service.model.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends MongoRepository<BlogPost, String> {
    List<BlogPost> findByAuthor(String author);
    List<BlogPost> findByTitleContaining(String title);
}
