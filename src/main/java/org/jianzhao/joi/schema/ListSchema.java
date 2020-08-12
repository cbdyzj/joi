package org.jianzhao.joi.schema;

import org.jianzhao.joi.AnySchema;
import org.jianzhao.joi.Result;
import org.jianzhao.joi.Schema;
import org.jianzhao.joi.util.SchemaUtils;

import java.util.List;

public class ListSchema<T> extends AnySchema<List<T>, ListSchema<T>> {

    public ListSchema() {
        this.predicate(List.class::isInstance);
    }

    public ListSchema<T> every(Schema<T> schema) {
        this.compose(target -> {
            Result result = Result.valid();
            for (T item : target) {
                result = SchemaUtils.mergeResult(schema.validate(item), result);
            }
            return result;
        });
        return this;
    }
}
