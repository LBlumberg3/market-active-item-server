package com.leo.market.items.activeitemserver.dao;

import com.leo.market.items.activeitemserver.beans.SimpleItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Extension of Spring Data's CrudRepository to leverage the auto-injected implementation for simple stuff
 *
 * @author Leonard
 */
@Repository
public interface SimpleItemRepository extends CrudRepository<SimpleItem, Integer> {

    @Override
    public List<SimpleItem> findAll();

}
