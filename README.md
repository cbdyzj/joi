# joi

Object schema validation 

> see: [joi](https://github.com/hapijs/joi)

## Dependencies

- [JOOR](https://github.com/jooq/joor)

## Usage

```java
assert Joi.integer().min(5).less(10).validate(7);
// true if 5 <= 7 < 10

assert Joi.string().regex("hello.*").validate("hello!");
// true if "hello!" matchs regex "hello.*"

assert Joi.string().email().validate("cbdyzj@jianzhao.org");
// true if "cbdyzj@jianzhao.org" matchs regex email

Teacher alice = new Teacher("Alice", 10);
Schema<Human> personSchema = Joi.<Human>object().type(Teacher.class)
        .field("name", Joi.string().regex("Alice").required())
        .field(Human::getAge, Joi.integer().min(8).max(18).required());

assert personSchema.validate(alice);
// bean validate

```

## Api

- any
  - required
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
