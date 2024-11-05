package io.quarkiverse.open.feature.deployment;

import io.quarkus.arc.deployment.SyntheticBeanBuildItem;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import org.jboss.jandex.DotName;
import dev.openfeature.sdk.OpenFeatureAPI;


class OpenFeatureProcessor {

    public static final DotName OPEN_FEATURE_API = DotName.createSimple(OpenFeatureAPI.class);

    private static final String FEATURE = "open-feature";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    void produceBeans(BuildProducer<SyntheticBeanBuildItem> producer){

    }
}
