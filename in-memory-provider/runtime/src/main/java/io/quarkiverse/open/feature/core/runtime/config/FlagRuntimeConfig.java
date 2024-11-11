package io.quarkiverse.open.feature.core.runtime.config;

import java.util.Map;
import java.util.Objects;

import io.quarkus.runtime.annotations.ConfigGroup;

@ConfigGroup
public interface FlagRuntimeConfig {

    /**
     * Variants for this flag
     */
    Map<String, Objects> variants();

    /**
     * Default Variant
     */
    String defaultVariant();
}
