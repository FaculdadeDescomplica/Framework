package com.descomplica.FrameBlog.services.impl;

import com.descomplica.FrameBlog.models.Post;
import com.descomplica.FrameBlog.repositories.PostRepository;
import com.descomplica.FrameBlog.repositories.TagRepository;
import com.descomplica.FrameBlog.services.PostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;

    @Override
    public Post save(final Post post) {
        Post existingPost = postRepository.findById(post.getPostId()).orElse(null);

        if (Objects.nonNull(existingPost)) {
            throw new RuntimeException("Existing Post");
        }

        Post entity = new Post(post.getPostId(), post.getTitle(), post.getContent(), post.getDate(), post.getUserId(), post.getTagId());
        return postRepository.save(entity);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post get(final Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Post not found")
        );
    }

    @Override
    public Post update(final Long id, final Post post) {
        Post postUpdate = postRepository.findById(id).orElse(null);
        if (Objects.nonNull(postUpdate)) {
            postUpdate.setTitle(post.getTitle());
            postUpdate.setContent(post.getContent());
            postUpdate.setDate(post.getDate());
            postUpdate.setUserId(post.getUserId());
            return postRepository.save(postUpdate);
        }
        return null;
    }

    @Override
    public void delete(final Long id) {
        postRepository.deleteById(id);
    }
}
