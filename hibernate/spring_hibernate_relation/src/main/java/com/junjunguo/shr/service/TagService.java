package com.junjunguo.shr.service;

import com.junjunguo.shr.model.Tag;

import java.util.List;

/**
 * This file is part of spring_hibernate_relation.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 25/10/15.
 */
public interface TagService {
    /**
     * @param label
     * @return Tag (contains list of videos)
     */
    Tag findByLabel(String label);

    /**
     * @param id
     * @return Tag (only tag)
     */
    Tag findByTagId(int id);

    /**
     * @return a list of tags
     */
    List<Tag> findAllTags();
}