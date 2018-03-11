package org.jianzhao.joi.test;

import org.jianzhao.joi.Joi;
import org.jianzhao.joi.Schema;
import org.joor.Reflect;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@SuppressWarnings("WeakerAccess")
public class JoiTest {

    @Test
    public void test() {
        assert !Joi.integer().min(5).less(10).validate(7).isPresent();

        assert !Joi.string().regex("hello.*").validate("hello!").isPresent();
        assert !Joi.string().empty().validate("\n").isPresent();

        assert !Joi.string().email().validate("cbdyzj@jianzhao.org").isPresent();

        Human alice = new Teacher("Alice", null, new String[]{"reading", "film"});
        Schema<Human> humanSchema = Joi.<Human>object().type(Teacher.class)
                .field(target -> Reflect.on(target).field("name").get(), Joi.string().regex("Alice").required().message("Wrong name!"))
                .field(Human::getAge, Joi.integer().min(8).max(18))
                .field(Human::getHobbies, hobbies -> hobbies.length >= 3 ? Optional.empty() : Optional.of("Hobbies number to small!"));

        Optional<String> os = humanSchema.validate(alice);
        assert os.isPresent();
        assert os.get().equals("Hobbies number to small!");
    }
}
