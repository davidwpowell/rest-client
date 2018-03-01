package com.prototype.restclient.constants;

import org.springframework.http.HttpMethod;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AppConstants {

    private AppConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, HttpMethod> httpMethodMap() {
        return Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>("GET", HttpMethod.GET),
                new AbstractMap.SimpleEntry<>("POST", HttpMethod.POST),
                new AbstractMap.SimpleEntry<>("PUT", HttpMethod.PUT),
                new AbstractMap.SimpleEntry<>("DELETE", HttpMethod.DELETE))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)));
    }
}
