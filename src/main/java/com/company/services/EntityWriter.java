package com.company.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jeff Risberg
 * @since 01/13/18
 */
@Slf4j
public class EntityWriter {
    protected ObjectMapper objectMapper;

    public EntityWriter() {
        this.objectMapper = new ObjectMapper();
    }
}
