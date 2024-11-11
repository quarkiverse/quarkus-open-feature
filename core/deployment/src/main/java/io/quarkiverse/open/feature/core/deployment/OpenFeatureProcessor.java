package io.quarkiverse.open.feature.core.deployment;

import jakarta.enterprise.context.ApplicationScoped;

import org.jboss.jandex.DotName;

import dev.openfeature.sdk.Client;
import dev.openfeature.sdk.OpenFeatureAPI;
import io.quarkiverse.open.feature.core.runtime.OpenFeatureRecorder;
import io.quarkus.arc.deployment.SyntheticBeanBuildItem;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class OpenFeatureProcessor {

    public static final DotName OPEN_FEATURE_API = DotName.createSimple(OpenFeatureAPI.class);
    public static final DotName OPEN_FEATURE_CLIENT = DotName.createSimple(Client.class);

    private static final String FEATURE = "open-feature";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    @Record(ExecutionTime.RUNTIME_INIT)
    void produceBeans(BuildProducer<SyntheticBeanBuildItem> producer, OpenFeatureRecorder recorder) {

        producer.produce(SyntheticBeanBuildItem.configure(OPEN_FEATURE_API)
                .setRuntimeInit()
                .scope(ApplicationScoped.class)
                .createWith(recorder.createOpenFeatureApi())
                .done());

        producer.produce(SyntheticBeanBuildItem.configure(OPEN_FEATURE_CLIENT)
                .setRuntimeInit()
                .scope(ApplicationScoped.class)
                .createWith(recorder.createClient())
                .done());
    }
}
