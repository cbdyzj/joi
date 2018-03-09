package org.jianzhao.joi.schema;

import org.jianzhao.joi.Schema;
import org.jianzhao.joi.SchemaContext;

import java.util.regex.Pattern;

public class StringSchema implements Schema<String> {

    private SchemaContext<String> ctx = new SchemaContext<>();

    public StringSchema() {
        this.ctx.add(String.class::isInstance);
    }

    @Override
    public boolean validate(String target) {
        return this.ctx.validate(target);
    }

    public StringSchema required() {
        this.ctx.required();
        return this;
    }

    public StringSchema regex(String pattern) {
        Pattern p = Pattern.compile(pattern);
        this.ctx.add(target -> p.matcher(target).matches());
        return this;
    }

    public StringSchema alphanum() {
        return this.regex("^[a-zA-Z0-9]+$");
    }

    public StringSchema email() {
        return this.regex("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
    }

    public StringSchema length(int limit) {
        this.ctx.add(target -> target.length() == limit);
        return this;
    }

    public StringSchema min(int limit) {
        this.ctx.add(target -> target.length() >= limit);
        return this;
    }

    public StringSchema max(int limit) {
        this.ctx.add(target -> target.length() <= limit);
        return this;
    }


}
