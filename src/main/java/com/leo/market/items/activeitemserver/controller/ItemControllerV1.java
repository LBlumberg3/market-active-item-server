package com.leo.market.items.activeitemserver.controller;


import com.leo.market.items.activeitemserver.beans.SimpleItem;
import com.leo.market.items.activeitemserver.constants.Constants;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller representing the presentation layer for the service interface. Mostly just CRUD and some metadata
 *
 * @author Leonard
 */
@RestController
@RequestMapping(value = "/item/v1")
public class ItemControllerV1 {

    public static final Logger logger = LoggerFactory.getLogger(ItemControllerV1.class);

    /**
     * Controller-specific health check, because the Spring Boot actuator can return non-OK responses
     * if you have some specific dependencies without proper configuration
     *
     * @return HTTP 200 response with simple JSON message
     */
    @GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("{\"Status\": \"UP\"}", HttpStatus.OK);
    }

    /**
     * returns item details in response to a GET request with the ID included directly as a path variable
     * (i.e, a GET to "/item/v1/123" instead of "/item/v1?id=123"
     *
     * @param id item's id
     * @return details on the requested item, or 204 if id not found
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getItemById(@PathVariable("id") Integer id) {
        logger.debug("get item with id = {}", id);
        if (id == null || id < 1) {
            // if the client sends a null / zero id, that's their problem
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        SimpleItem item = null; // fill in body later
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    /**
     * Allows clients to persist a new item to the DB, and responds with the data that were persisted after the operation completes
     * Neither this class nor the client know if it is a hard commit, or even if it is SQL/NoSQL; This controller knows
     * nothing about the DB
     *
     * @param item item to persist
     * @return 201 response and data that were persisted, or an HTTP error code and message
     */
    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> postNewItem(@RequestBody SimpleItem item) {
        logger.debug("create new item with id = {}, description = {}", item.getId(), item.getDescription());
        // call service layer for new item
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updateItem(@PathVariable("id") Integer id, @RequestBody SimpleItem item) {
        if (id == null || id < 1 || item == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!item.getId().equals(id)) {
            return new ResponseEntity<>(Constants.INVALID_ID_JSON_RESPONSE, HttpStatus.BAD_REQUEST);
        }

        // call service layer with update data
        SimpleItem updatedItem = null;

        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> deactivateItem(@PathVariable("id") Integer id) {
        if (id == null || id < 1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // call service later for deactivation of item (which will eventually have it removed from the db)
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
