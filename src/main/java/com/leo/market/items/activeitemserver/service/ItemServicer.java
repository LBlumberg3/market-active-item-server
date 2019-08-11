package com.leo.market.items.activeitemserver.service;

import com.leo.market.items.activeitemserver.beans.AbstractItem;
import com.leo.market.items.activeitemserver.exception.IdNotFoundException;
import com.leo.market.items.activeitemserver.exception.NonUniqueIdException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Interface for different item service implementations. Defines the signatures for the CRUD methods
 *
 * @param <T>  Type of item handled
 * @param <ID> ID type of the item
 */
public interface ItemServicer<T extends AbstractItem, ID> {

    /**
     * Invokes data layer for the relevant getById method
     *
     * @param id id of desired item
     * @return Optional wrapping desired item
     */
    public Optional<T> getItemById(ID id);

    /**
     * Method allowing for tag searches
     *
     * @param tags   list of tags to match against
     * @param strict if all tags must match (true) or of any tag can match (false)
     * @return list of results from data layer
     */
    public List<T> getItemsByTag(List<String> tags, Boolean strict);

    /**
     * Method allowing for a search by description
     *
     * @param description item description to search for
     * @return list of possible matches from data layer
     * @throws IllegalArgumentException if the description is null or empty
     */
    public List<T> getItemsByDescription(String description);

    /**
     * Method to allow chronological searches of items;
     * Implementing classes should support at least one parameter being null
     *
     * @param start beginning date to search for, or null for "everything before [endDate]"
     * @param end   ending date to search for, or null for "everything after [startDate]"
     * @return list of items created or modified in the defined date interval
     */
    public List<T> getItemsByDate(LocalDateTime start, LocalDateTime end);

    /**
     * Method to have data layer persist the object provided, with the option to overwrite if a record with
     * a matching id is found
     *
     * @param item   item to persist
     * @param update if the provided ID already exists, if the data layer should overwrite the existing record or not
     * @return data that was persisted
     * @throws NonUniqueIdException if the item's id already exists, and update is set to false
     */
    public T newItem(T item, Boolean update);

    /**
     * Method to persist changes to an existing item, or create the item if the ID is not found
     *
     * @param item data to persist
     * @param create if the ID is not found, should a new record be created (true) or not (false)
     * @return data that were persisted
     * @throws IdNotFoundException if the id is not found, and create is set to false
     */
    public T updateItem(T item, Boolean create);

    /**
     * Deactivates item in the database, marking it for later removal and stopping it from appearing in search results
     *
     * @param id item to delete
     * @throws IdNotFoundException if the desired id wasn't found by the data layer
     */
    public void deleteItemById(ID id);

}
