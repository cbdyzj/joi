package org.jianzhao.joi.schema;

import org.jianzhao.joi.AnySchema;

import java.util.regex.Pattern;

public class StringSchema extends AnySchema<String, StringSchema> {

    public StringSchema() {
        this.predicate(String.class::isInstance);
    }

    public StringSchema regex(String pattern) {
        Pattern p = Pattern.compile(pattern);
        return this.predicate(target -> p.matcher(target).matches());
    }

    public StringSchema alphanum() {
        return this.regex("^[a-zA-Z0-9]+$");
    }

    public StringSchema email() {
        return this.regex("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
    }

    public StringSchema length(int limit) {
        return this.predicate(target -> target.length() == limit);
    }

    public StringSchema min(int limit) {
        return this.predicate(target -> target.length() >= limit);
    }

    public StringSchema max(int limit) {
        return this.predicate(target -> target.length() <= limit);
    }

    public StringSchema empty(){
        return this.regex("^\\s*$");
    }

}
