package io.quarkiverse.open.feature.core.deployment;

import jakarta.enterprise.context.ApplicationScoped;

import dev.openfeature.sdk.FeatureProvider;
import io.quarkiverse.open.feature.core.runtime.InMemoryRecorder;
import io.quarkus.arc.deployment.SyntheticBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class OpenFeatureProcessor {

    private static final String FEATURE = "open-feature-in-memory-provider";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    @Record(ExecutionTime.RUNTIME_INIT)
    public SyntheticBeanBuildItem produceBeans(InMemoryRecorder recorder) {

        return SyntheticBeanBuildItem.configure(FeatureProvider.class)
                .scope(ApplicationScoped.class)
                .setRuntimeInit()
                .supplier(recorder::produceProvider)
                .done();
    }
}
