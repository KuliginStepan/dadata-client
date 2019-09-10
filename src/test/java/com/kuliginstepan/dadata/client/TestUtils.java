package com.kuliginstepan.dadata.client;

import com.kuliginstepan.dadata.client.domain.Suggestion;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtils {

    public static final DadataClient CLIENT = new DadataClientBuilder().token("d0a06c568347cb09905d9a0fe9009380eb6b25d3").build();

    public static <T, R> List<T> getDistinctList(Function<Suggestion<R>, T> mapper, List<Suggestion<R>> suggestions) {
        return suggestions.stream()
            .map(mapper)
            .distinct()
            .collect(Collectors.toList());
    }
}
