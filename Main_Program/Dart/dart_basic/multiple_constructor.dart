class Person {
  var name;
  var age;

  Person({this.name, this.age});

  Person.king({this.name = "king barou"});
}

void main(List<String> args) {
  Person person1 = Person(name: 'sibe', age: 21);
  var person2 = Person(age: 21, name: 'habi');
  var personKing = Person.king();

  print(person1.name);
  print(person2.age);
  print(personKing.name);
}
