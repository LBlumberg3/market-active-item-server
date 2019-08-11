package com.leo.market.items.activeitemserver.service;

import com.leo.market.items.activeitemserver.beans.SimpleItem;
import com.leo.market.items.activeitemserver.dao.ItemDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Simple service layer class that links CRUD functionality in the API interface with the data layer,
 * orchestrating calls to the injected dependencies as needed
 *
 * @author Leonard
 */
public class ItemServiceImpl implements ItemServicer<SimpleItem, Integer> {

    public static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemDao dao;

    @Override
    public Optional<SimpleItem> getItemById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<SimpleItem> getItemsByTag(List<String> tags, Boolean strict) {
        return null;
    }

    @Override
    public List<SimpleItem> getItemsByDescription(String description) {
        return null;
    }

    @Override
    public List<SimpleItem> getItemsByDate(LocalDateTime start, LocalDateTime end) {
        return null;
    }

    @Override
    public SimpleItem newItem(SimpleItem item, Boolean update) {
        return null;
    }

    @Override
    public SimpleItem updateItem(SimpleItem item, Boolean create) {
        return null;
    }

    @Override
    public void deleteItemById(Integer integer) {

    }
}
