package com.junjunguo.sae.dao;

import com.junjunguo.sae.model.Location;

import java.util.List;

/**
 * This file is part of spring_hibernate_relation.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 25/10/15.
 */
public interface LocationDao {
    List<Location> findAllLocations();

    Location findById(long id);

    Location findByLocation(Location location);
}
