"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
console.log("Hello, TypeScript 6.0.2 with ESNext modules and ES2024 target!");
let message = "Welcome to the TypeScript world!";
console.log(message);
let object = { name: "Alice", age: 30 };
console.log(`Name: ${object.name}, Age: ${object.age}`);
// function
function greet(name) {
    return `Hello, ${name}!`;
}
console.log(greet("Bob"));
// default parameters
function greetWithDefault(name = "Guest") {
    return `Hello, ${name}!`;
}
// optional parameters
function greetOptional(name) {
    return `Hello, ${name ?? "Guest"}!`;
}
console.log(greetWithDefault());
console.log(greetWithDefault("Charlie"));
console.log(greetOptional());
console.log(greetOptional("David"));
// rest parameters
function sum(...numbers) {
    return numbers.reduce((acc, curr) => acc + curr, 0);
}
console.log(sum(1, 2, 3)); // Output: 6
// arraw function
const multiply = (a, b) => a * b;
console.log(multiply(4, 5)); // Output: 20
// annonimous function
const add = function (a, b) {
    return a + b;
};
console.log(add(10, 15)); // Output: 25
// void function
function logMessage(message) {
    console.log(`Log: ${message}`);
}
logMessage("This is a void function example.");
// never function
function throwError(message) {
    throw new Error(message);
}
// Uncommenting the following line will throw an error
// throwError("This is a never function example.");
// union types
let unionValue = "Hello";
console.log(unionValue);
unionValue = 42;
console.log(unionValue);
let direction = "North";
console.log(`Direction: ${direction}`);
// nullable types
let nullableValue = "I can be null";
console.log(nullableValue);
nullableValue = null;
console.log(nullableValue);
let user = { name: "Eve", age: 25 };
console.log(`User Name: ${user.name}, User Age: ${user.age}`);
let elevatedEmployee = {
    name: "Frank",
    privileges: ["create-server"],
    startDate: new Date(),
};
console.log(`Elevated Employee Name: ${elevatedEmployee.name}`);
console.log(`Privileges: ${elevatedEmployee.privileges.join(", ")}`);
console.log(`Start Date: ${elevatedEmployee.startDate.toDateString()}`);
// array types
let numberArray = [1, 2, 3, 4, 5];
console.log(`Number Array: ${numberArray.join(", ")}`);
let arrayOfStrOrNumber = ["Hello", 42, "World", 100];
console.log(`Array of String or Number: ${arrayOfStrOrNumber.join(", ")}`);
// tuple types
let tuple = ["Alice", 30];
console.log(`Tuple: Name - ${tuple[0]}, Age - ${tuple[1]}`);
const [name, age] = tuple;
console.log(`Destructured Tuple: Name - ${name}, Age - ${age}`);
// enum types
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
let color = Color.Green;
console.log(`Color: ${Color[color]}`); // Output: Color: Green
let person = {
    name: "Grace",
    age: 28,
    occupation: "Software Developer", // This will cause an error since occupation is not defined in the Person interface
    greet() {
        return `Hello, my name is ${this.name} and I am ${this.age} years old.`;
    },
};
console.log(person.greet());
// classes
class Animal {
    // public variable
    name;
    // private, protected variables
    // private age: number;
    // protected species: string;
    // static variable
    // static count: number = 0;
    age;
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    makeSound() {
        console.log(`${this.name} makes a sound.`);
    }
}
class Dog extends Animal {
    constructor(name, age) {
        super(name, age);
    }
    makeSound() {
        console.log(`${this.name} barks.`);
    }
}
const dog = new Dog("Buddy ", 5);
dog.makeSound(); // Output: Buddy barks.
// abstract classes
class Shape {
}
class Circle extends Shape {
    radius;
    constructor(radius) {
        super();
        this.radius = radius;
    }
    area() {
        return Math.PI * this.radius * this.radius;
    }
}
const circle = new Circle(5);
console.log(`Area of the circle: ${circle.area()}`);
// polymorphism, encapsulation, inheritance are also supported in TypeScript classes.
// generics
function identity(arg) {
    return arg;
}
console.log(identity("Hello, Generics!")); // Output: Hello, Generics!
console.log(identity(42)); // Output: 42    
// type assertions
let someValue = "This is a string.";
let strLength = someValue.length;
console.log(`String Length: ${strLength}`); // Output: String Length: 17
//# sourceMappingURL=index.js.map