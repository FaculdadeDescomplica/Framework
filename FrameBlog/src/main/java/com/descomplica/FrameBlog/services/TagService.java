package com.descomplica.FrameBlog.services;

import com.descomplica.FrameBlog.models.Tag;

import java.util.List;

public interface TagService {

    Tag save(final Tag tag);
    List<Tag> getAll();
    Tag get(final Long id);
    Tag update(final Long id, final Tag tag);
    void delete(final Long id);
}
