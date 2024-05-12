package com.descomplica.FrameBlog.services;

import com.descomplica.FrameBlog.models.Post;

import java.util.List;

public interface PostService {

    Post save(final Post post);
    List<Post> getAll();
    Post get(final Long id);
    Post update(final Long id, final Post post);
    void delete(final Long id);
}