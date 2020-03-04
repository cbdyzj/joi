# joi

Object schema validation 

[![Build Status](https://travis-ci.org/cbdyzj/joi.svg?branch=master)](https://travis-ci.org/cbdyzj/joi)
[![Release](https://jitpack.io/v/cbdyzj/joi.svg)](https://jitpack.io/#cbdyzj/joi)

> See: [joi](https://github.com/hapijs/joi): Object schema validation in JavaScript

## Dependencies

None!

## Usage

### Download

See [JitPack](https://jitpack.io/#cbdyzj/joi/0.3.2)

### Simple example

```java
 // integer
Joi.integer().min(5).less(10).validate(7).assertValid();
// long integer
Joi.longInteger().min(3_000_000_000L).less(5_000_000_000L)
        .validate(4_000_000_000L)
        .assertValid();
// string
Joi.string().regex("hello.*").message("Not hello!").validate("hello!")
        .assertValid(IllegalArgumentException::new);
Joi.string().empty().validate("\n").assertValid();
Joi.string().email().validate("cbdyzj@jianzhao.org").assertValid();
// object
Human alice = new Teacher("Alice", null, new String[]{"reading", "film"});
Schema<Human> humanSchema = Joi.<Human>object().type(Teacher.class)
        .field(Human::getName, Joi.string().regex("Alice").required().message("Wrong name!"))
        .field(Human::getAge, Joi.integer().min(8).max(18))
        .field(Human::getHobbies, hobbies -> hobbies.length >= 3
                ? Result.valid()
                : Result.of("Hobbies number to small!"));

Result result = humanSchema.validate(alice);
Assertions.assertTrue(result.isInvalid());
Assertions.assertEquals("[Hobbies number to small!]", String.valueOf(result.getMessages()));
// array
Joi.array().notEmpty().validate(new Object[]{0}).assertValid();
// list
Joi.<String>list().every(Joi.string().alphanum())
        .validate(Arrays.asList("1a", "2b", "3c"))
        .assertValid();
// map
Joi.<String, Integer>map().entry("key", Joi.integer().greater(7))
        .validate(Collections.singletonMap("key", 8))
        .assertValid();
```

## Api

See code

## Licence

[WTFPL](https://en.wikipedia.org/wiki/WTFPL)
