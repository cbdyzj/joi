package org.jianzhao.joi.schema;

import org.jianzhao.joi.AnySchema;
import org.jianzhao.joi.Schema;

import java.util.Map;
import java.util.function.Supplier;

public class MapSchema<K, V> extends AnySchema<Map<K, V>, MapSchema<K, V>> {

    public MapSchema() {
        this.predicate(Map.class::isInstance);
    }

    public MapSchema<K, V> entry(K key, Schema<V> valueSchema) {
        return this.entry(() -> key, valueSchema);
    }

    public MapSchema<K, V> entry(Supplier<K> keyGetter, Schema<V> valueSchema) {
        this.compose(target -> valueSchema.validate(target.get(keyGetter.get())));
        return this;
    }
}
