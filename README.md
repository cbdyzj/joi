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
assert !Joi.integer().min(5).less(10).validate(7).isPresent();

assert !Joi.string().regex("hello.*").validate("hello!").isPresent();

assert !Joi.string().email().validate("cbdyzj@jianzhao.org").isPresent();

Human alice = new Teacher("Alice", null, new String[]{"reading", "film"});
Schema<Human> humanSchema = Joi.<Human>object().type(Teacher.class)
        .field("name", Joi.string().regex("Alice").required())
        .field(Human::getAge, Joi.integer().min(8).max(18))
        .field(Human::getHobbies, hobbies -> hobbies.length >= 3 ? Optional.empty() : Optional.of("Hobbies number to small!"));

Optional<String> os = humanSchema.validate(alice);
assert os.isPresent();
assert os.get().equals("Hobbies number to small!");
```

## Api

- Any
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
