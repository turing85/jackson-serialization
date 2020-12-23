package de.turing85;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String... args) throws JsonProcessingException {
        mapperWithNonEmptyEntityWithoutAnnotation();
        mapperWithNonEmptyEntityWithAnnotation();
        mapperWithAlwaysEntityWithoutAnnotation();
    }

    private static void mapperWithNonEmptyEntityWithoutAnnotation() throws JsonProcessingException {
        final BusinessModel model = new BusinessModel();
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        System.out.println("mapper with NON_EMPTY, model without annotation: " +  mapper.writeValueAsString(model));
    }

    private static void mapperWithNonEmptyEntityWithAnnotation() throws JsonProcessingException {
        final BusinessModelWithAnnotation model = new BusinessModelWithAnnotation();
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        System.out.println("mapper with NON_EMPTY, model with annotation: " +  mapper.writeValueAsString(model));
    }

    private static void mapperWithAlwaysEntityWithoutAnnotation() throws JsonProcessingException {
        final BusinessModel model = new BusinessModel();
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        System.out.println("mapper with EMPTY, model without annotation: " +  mapper.writeValueAsString(model));
    }
}
