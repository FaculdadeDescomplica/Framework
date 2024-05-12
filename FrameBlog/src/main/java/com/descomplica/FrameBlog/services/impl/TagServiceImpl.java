package com.descomplica.FrameBlog.services.impl;

import com.descomplica.FrameBlog.models.Tag;
import com.descomplica.FrameBlog.repositories.TagRepository;
import com.descomplica.FrameBlog.services.TagService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag save(final Tag tag) {
        Tag existingTag = tagRepository.findById(tag.getTagId()).orElse(null);

        if (Objects.nonNull(existingTag)) {
            throw new RuntimeException("Existing Tag");
        }

        Tag entity = new Tag(tag.getTagId(), tag.getName());
        return tagRepository.save(entity);
    }

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag get(final Long id) {
        return tagRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Tag not found")
        );
    }

    @Override
    public Tag update(final Long id, final Tag tag) {
        Tag tagUpdate = tagRepository.findById(id).orElse(null);
        if (Objects.nonNull(tagUpdate)) {
            tagUpdate.setName(tag.getName());
            return tagRepository.save(tagUpdate);
        }
        return null;
    }

    @Override
    public void delete(final Long id) {
        tagRepository.deleteById(id);
    }
}

