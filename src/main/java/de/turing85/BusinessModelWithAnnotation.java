package de.turing85;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BusinessModelWithAnnotation {
    @JsonInclude(JsonInclude.Include.ALWAYS)
    protected String foo;
}