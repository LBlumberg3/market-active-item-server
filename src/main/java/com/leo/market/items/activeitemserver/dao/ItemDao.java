package com.leo.market.items.activeitemserver.dao;

import com.leo.market.items.activeitemserver.beans.SimpleItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * Data layer class for items, leveraging the functionality of the CrudRepository extensions where appropriate
 *
 * @author Leonard
 */
@Repository
public class ItemDao {

    public static final Logger logger = LoggerFactory.getLogger(ItemDao.class);

    @Autowired
    private SimpleItemRepository itemRepo;

    @PersistenceContext
    private EntityManager em;

    /**
     * Primary Key lookup. Nothing special here
     * @param id the primary key of the desired record
     * @return Optional wrapping the item desired
     */
    public Optional<SimpleItem> findById(Integer id){
        return itemRepo.findById(id);
    }





}
