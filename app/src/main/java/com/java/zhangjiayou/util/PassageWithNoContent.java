package com.java.zhangjiayou.util;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provide interfaces to access the title, the content and other properties of a passage.
 *
 * @author 田倍闻
 * @version 1.1
 */
@Entity(tableName = "Passages")
public class PassageWithNoContent {
    @PrimaryKey
    @NonNull
    private String _id;
    private Date date;
    private String title;

    @Ignore
    private Map<String, Object> properties = new HashMap<>();
    @JsonIgnore
    public String rawJSON;

    /**
     * This method aims to create a Passage instance from JSON text.
     * This method is meant to be called by Jackson module.
     * **Do not call this method manually!**
     *
     * @param id      The id of the passage
     * @param title   The title of the passage
     */
    @JsonCreator
    public PassageWithNoContent(
            @JsonProperty("_id") String id,
            @JsonProperty("title") String title,
            @JsonProperty("date") Date date
    ) {
        this._id = id;
        this.title = title;
        this.date = date;
//        try {
//            this.rawJSON = new PassagePortal().getNewsJSONFromId(id);
//        } catch (NoResponseError noResponseError) {
//            noResponseError.printStackTrace();
//        }

    }

    /**
     * This method aims to add additional properties provided by the JSON text.
     * This method is meant to be called by Jackson module.
     * Do not call this method manually!
     * @param key Property key provided in JSON text
     * @param value Property value provided in JSON text
     */
    @JsonAnySetter
    public void add(String key, Object value) {
        properties.put(key, value);
    }

    /**
     * This method returns the id of the passage.
     *
     * @return The id of the passage
     */
    public String getId() {
        return this._id;
    }

    public void setId(String id) {
        this._id = id;
    }

    /**
     * This method returns the id of the passage.
     *
     * @return The title of the passage
     */
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method returns a map with additional properties of the passage
     * Available properties:
     * authors, category, doi, entities, geoInfo, influence, lang, pdf,
     * regionIDs, related_events, seg_text, source, tflag, time, type,
     * urls, year,
     *
     * @return A map containing all additional properties of the passage
     */
    final public Map<String, Object> getProperties() {
        return properties;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}


