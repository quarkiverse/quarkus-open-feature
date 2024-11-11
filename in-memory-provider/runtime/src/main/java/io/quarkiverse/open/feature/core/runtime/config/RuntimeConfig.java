package io.quarkiverse.open.feature.core.runtime.config;

import java.util.Map;

import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "quarkus.open-feature.in-memory")
@ConfigRoot(phase = ConfigPhase.RUN_TIME)
public interface RuntimeConfig {

    /**
     * Flag Configuration
     */
    Map<String, FlagRuntimeConfig> flags();
}
