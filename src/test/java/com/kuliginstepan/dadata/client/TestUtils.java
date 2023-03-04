package com.kuliginstepan.dadata.client;

import com.kuliginstepan.dadata.client.domain.Suggestion;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtils {

    public static final String TOKEN = "d0a06c568347cb09905d9a0fe9009380eb6b25d3";

    public static final DadataClient CLIENT = new DadataClientBuilder()
        .clientProperties(
            new DadataClientProperties() {{
                setToken(TOKEN);
            }}
        )
        .build();

    public static <T, R> List<T> getDistinctList(Function<Suggestion<R>, T> mapper, List<Suggestion<R>> suggestions) {
        return suggestions.stream()
            .map(mapper)
            .distinct()
            .collect(Collectors.toList());
    }
}
