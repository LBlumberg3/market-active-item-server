package com.leo.market.items.activeitemserver.beans;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Abstract POJO acting as the canonical data model that the service interacts with; child classes can add annotations
 * and support for SQL / NoSQL repositories as needed.
 *
 * @author Leonard
 */
public abstract class AbstractItem<ID> {

    public AbstractItem() {
        super();
        this.createdAt = LocalDateTime.now();
        this.lastChangeTs = LocalDateTime.now();
        this.lastChangeUserId = ""; // empty string implying it was just created
    }

    // required parts of the key
    protected ID id;

    // metadata for a UI to use
    protected String description;
    protected List<String> tags;
    protected LocalDateTime createdAt;
    protected LocalDateTime lastChangeTs;
    protected String lastChangeUserId;

    public abstract ID getId();

    public abstract void setId(ID id);

    public abstract String getDescription();

    public abstract void setDescription(String description);

    public abstract List<String> getTags();

    public abstract void setTags(List<String> tags);

    public abstract LocalDateTime getCreatedAt();

    public abstract LocalDateTime getLastChangeTs();

    public abstract String getLastChangeUserId();


}
