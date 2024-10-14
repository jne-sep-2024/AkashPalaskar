package com.think.restful_web_service.jsonFiltering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class JsonFilteringController {

    @GetMapping("/filtering") //filter field1, field3
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1", "field3");
        FilterProvider filers = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", filter);

        mappingJacksonValue.setFilters(filers);

        System.out.println(new SomeBean("value1", "value2", "value3"));
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list") //filter field2, field3
    public MappingJacksonValue filteringKist() {
        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"),
                new SomeBean("value7", "value8", "value9"));
//to make a filter on json which is return
        //by this filter in th list api just field2 and field3 property will display nothing other than that
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field2", "field3");
        FilterProvider filers = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", filter);

        mappingJacksonValue.setFilters(filers);


        return mappingJacksonValue;
    }
}
