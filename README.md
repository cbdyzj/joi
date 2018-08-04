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
Joi.integer().min(5).less(10).validate(7).assertValid();
Joi.longInteger().min(3_000_000_000L).less(5_000_000_000L).validate(4_000_000_000L).assertValid();

Joi.string().regex("hello.*").message("Not hello!").validate("hello!")
        .assertValid(IllegalArgumentException::new);

Joi.string().empty().validate("\n").assertValid();

Joi.string().email().validate("cbdyzj@jianzhao.org").assertValid();

Human alice = new Teacher("Alice", null, new String[]{"reading", "film"});
Schema<Human> humanSchema = Joi.<Human>object().type(Teacher.class)
        .field(Human::getName, Joi.string().regex("Alice").required().message("Wrong name!"))
        .field(Human::getAge, Joi.integer().min(8).max(18))
        .field(Human::getHobbies, hobbies -> hobbies.length >= 3 ? Result.valid() : Result.of("Hobbies number to small!"));

Result result = humanSchema.validate(alice);
assert result.isInvalid();
assert "Hobbies number to small!".equals(result.message());
```

## Api

- Any
  - validate
  - required
  - requireValid
  - message
  - schema
  - predicate
- String
  - regex
  - alphanum
  - email
  - length
  - min
  - max
  - empty
- Integer
  - max
  - min
  - greater
  - less
  - positive
  - negative
- LongInteger
  - max
  - min
  - greater
  - less
  - positive
  - negative
- Object
  - type
  - field
