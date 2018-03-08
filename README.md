# joi

Object schema validation 

> see: [joi](https://github.com/hapijs/joi)

## Dependencies

- [jOOR](https://github.com/jooq/joor): 

## Usage

```java
Schema intSchema = Joi.integer().min(5).max(10);
assert intSchema.validate(5);
assert !intSchema.validate(12);
assert !intSchema.validate(4);

Schema strSchema = Joi.string().regex("hello.*");
assert strSchema.validate("hello!");
assert !strSchema.validate("hi");

assert Joi.string().alphanum().validate("abc123");

Person person = new Person("Alice", 10);
Schema personSchema = Joi.object().type(Person.class)
        .field("name", Joi.string().required().regex("Alice").required())
        .field("age", Joi.integer().min(8).max(18).required());
assert personSchema.validate(person);
```
