package org.jianzhao.joi.test;

import org.jianzhao.joi.Joi;
import org.jianzhao.joi.Schema;
import org.junit.jupiter.api.Test;

@SuppressWarnings("WeakerAccess")
public class JoiTest {

    @Test
    public void test() {
        assert Joi.integer().min(5).less(10).validate(7);

        assert Joi.string().regex("hello.*").validate("hello!");

        assert Joi.string().email().validate("cbdyzj@jianzhao.org");

        Person person = new Person("Alice", 10);
        Schema personSchema = Joi.object().type(Person.class)
                .field("name", Joi.string().required().regex("Alice").required())
                .field("age", Joi.integer().min(8).max(18).required());
        assert personSchema.validate(person);
    }
}
