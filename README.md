# joi

Object schema validation 

> see: [joi](https://github.com/hapijs/joi): Object schema validation in JavaScript

## Dependencies

- [JOOR](https://github.com/jooq/joor): Fluent Reflection in Java

## Usage

### Download

[![Release](https://jitpack.io/v/cbdyzj/joi.svg)](https://jitpack.io/#cbdyzj/joi)

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
