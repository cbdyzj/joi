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

        Human alice = new Teacher("Alice", null, new String[]{"reading", "film"});
        Schema<Human> humanSchema = Joi.<Human>object().type(Teacher.class)
                .field("name", Joi.string().regex("Alice").required())
                .field(Human::getAge, Joi.integer().min(8).max(18))
                .field(Human::getHobbies, hobbies -> hobbies.length >= 2);

        assert humanSchema.validate(alice);
    }
}
