package com.leo.market.items.activeitemserver.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Concrete POJO represnting the bare minimum data about an item required. Things like a picture, item status, price,
 * etc., will be added in child classes (also because I don't want to dink with it at the moment)
 *
 * @author Leonard
 */
public class SimpleItem extends AbstractItem<Integer> {

    public SimpleItem(Integer id, String description) {
        super();
        this.id = id;
        this.description = description;
        this.tags = new ArrayList<>();
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public List<String> getTags() {
        return this.tags;
    }

    @Override
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public LocalDateTime getLastChangeTs() {
        return this.lastChangeTs;
    }

    @Override
    public String getLastChangeUserId() {
        return this.lastChangeUserId;
    }
}
