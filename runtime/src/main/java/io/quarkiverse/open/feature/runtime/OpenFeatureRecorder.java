package io.quarkiverse.open.feature.runtime;

import dev.openfeature.sdk.Client;
import dev.openfeature.sdk.FeatureProvider;
import dev.openfeature.sdk.OpenFeatureAPI;
import io.quarkus.arc.SyntheticCreationalContext;
import io.quarkus.runtime.annotations.Recorder;

import java.util.function.Function;

@Recorder
public class OpenFeatureRecorder {

    public Function<SyntheticCreationalContext<OpenFeatureAPI>, OpenFeatureAPI> createOpenFeatureApi() {
        return context -> {
            OpenFeatureAPI instance = OpenFeatureAPI.getInstance();
            instance.setProviderAndWait(context.getInjectedReference(FeatureProvider.class));
            return instance;
        };
    }

    public Function<SyntheticCreationalContext<Client>, Client> createClient() {
        return context -> context.getInjectedReference(OpenFeatureAPI.class).getClient();
    }
}
