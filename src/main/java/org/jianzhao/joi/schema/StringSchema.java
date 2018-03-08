package org.jianzhao.joi.schema;

import java.util.regex.Pattern;

public class StringSchema extends SchemaWare<StringSchema> {

    public StringSchema() {
        this.add(target -> target instanceof String);
    }

    public StringSchema regex(String pattern) {
        Pattern p = Pattern.compile(pattern);
        return this.add(target -> p.matcher((String) target).matches());
    }

    public StringSchema alphanum() {
        return this.regex("^[a-zA-Z0-9]+$");
    }

    public StringSchema email() {
        return this.regex("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
    }

    public StringSchema length(int limit) {
        return this.add(target -> ((String) target).length() == limit);
    }

    public StringSchema min(int limit) {
        return this.add(target -> ((String) target).length() >= limit);
    }

    public StringSchema max(int limit) {
        return this.add(target -> ((String) target).length() <= limit);
    }

}
