package dev.sentinel.sdk;

/** Client-specific business logic applied after scoring. May override the decision. */
public interface DecisionHook {

    PluginDescriptor describe();

    Decision apply(Transaction tx, double score, Decision proposed);
}
