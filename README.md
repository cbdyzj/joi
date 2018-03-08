# joi

Object schema validation 

> see: [joi](https://github.com/hapijs/joi)

## Dependencies

- [jOOR](https://github.com/jooq/joor)

## Usage

```java
assert Joi.integer().min(5).less(10).validate(7);
// true if 5 <= 7 < 10

assert Joi.string().regex("hello.*").validate("hello!");
// true if "hello!" matchs regex "hello.*"

assert Joi.string().email().validate("cbdyzj@jianzhao.org");
// true if "cbdyzj@jianzhao.org" matchs regex email

Person person = new Person("Alice", 10);
Schema personSchema = Joi.object().type(Person.class)
        .field("name", Joi.string().required().regex("Alice").required())
        .field("age", Joi.integer().min(8).max(18).required());
assert personSchema.validate(person);
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