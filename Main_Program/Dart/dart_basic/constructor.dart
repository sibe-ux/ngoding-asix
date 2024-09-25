class Person {
  var name;
  var age;

  Person({this.name, this.age});
}

void main(List<String> args) {
  Person person1 = Person(name: 'sibe', age: 21);
  var person2 = Person(age: 21, name: 'habi');

  print(person1.name);
  print(person2.age);
}
