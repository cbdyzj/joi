# joi

Object schema validation 

[![Build Status](https://travis-ci.org/cbdyzj/joi.svg?branch=master)](https://travis-ci.org/cbdyzj/joi)
[![Release](https://jitpack.io/v/cbdyzj/joi.svg)](https://jitpack.io/#cbdyzj/joi)

> See: [joi](https://github.com/hapijs/joi): Object schema validation in JavaScript

## Dependencies

None!

## Usage

### Download

See [JitPack](https://jitpack.io/#cbdyzj/joi/0.0.8)

### Simple example

```java
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
assert result.nonValid();
assert "Hobbies number to small!".equals(result.message());
```

## Api

- Any
  - validate
  - required
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
- Object
  - type
  - field
