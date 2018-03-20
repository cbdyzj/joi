package org.jianzhao.joi.test;

import org.jianzhao.joi.Joi;
import org.jianzhao.joi.Result;
import org.jianzhao.joi.Schema;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@SuppressWarnings("WeakerAccess")
public class JoiTest {

    @Test
    public void test() {
        Joi.integer().min(5).less(10).validate(7).assertValid();

        Joi.string().regex("hello.*").validate("hello!").assertValid();
        Joi.string().empty().validate("\n").assertValid();

        Joi.string().email().validate("cbdyzj@jianzhao.org").assertValid();

        Human alice = new Teacher("Alice", null, new String[]{"reading", "film"});
        Schema<Human> humanSchema = Joi.<Human>object().type(Teacher.class)
                .field(Human::getName, Joi.string().regex("Alice").required().message("Wrong name!"))
                .field(Human::getAge, Joi.integer().min(8).max(18))
                .field(Human::getHobbies, hobbies -> hobbies.length >= 3 ? Result.valid() : Result.of("Hobbies number to small!"));

        Result result = humanSchema.validate(alice);
        assert !result.isValid();
        assert "Hobbies number to small!".equals(result.message());
    }
}
