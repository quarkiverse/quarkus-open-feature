package io.quarkiverse.open.feature.core.runtime;

import java.util.HashMap;
import java.util.Map;

import dev.openfeature.sdk.providers.memory.Flag;
import dev.openfeature.sdk.providers.memory.InMemoryProvider;
import io.quarkiverse.open.feature.core.runtime.config.RuntimeConfig;
import io.quarkus.runtime.annotations.Recorder;

@Recorder
public class InMemoryRecorder {

    private final RuntimeConfig runtimeConfig;

    public InMemoryRecorder(RuntimeConfig runtimeConfig) {
        this.runtimeConfig = runtimeConfig;
    }

    public InMemoryProvider produceProvider() {

        Map<String, Flag<?>> flags = new HashMap<>();

        runtimeConfig.flags().forEach((key, value) -> {
            Flag.FlagBuilder<Object> flagBuilder = Flag.builder();
            value.variants().forEach(flagBuilder::variant);
            flagBuilder.defaultVariant(value.defaultVariant());
            flags.put(key, flagBuilder.build());
        });

        return new InMemoryProvider(flags);
    }
}
