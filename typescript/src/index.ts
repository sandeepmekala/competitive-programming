console.log("Hello, TypeScript 6.0.2 with ESNext modules and ES2024 target!");

let message: string = "Welcome to the TypeScript world!";
console.log(message);

let object: { name: string; age: number } = { name: "Alice", age: 30 };
console.log(`Name: ${object.name}, Age: ${object.age}`);


// function
function greet(name: string): string {
    return `Hello, ${name}!`;
}

console.log(greet("Bob"));


// default parameters
function greetWithDefault(name: string = "Guest"): string {
    return `Hello, ${name}!`;
}


// optional parameters
function greetOptional(name?: string): string {
    return `Hello, ${name ?? "Guest"}!`;
}

console.log(greetWithDefault());
console.log(greetWithDefault("Charlie"));
console.log(greetOptional());
console.log(greetOptional("David"));


// rest parameters
function sum(...numbers: number[]): number {
    return numbers.reduce((acc, curr) => acc + curr, 0);
}

console.log(sum(1, 2, 3)); // Output: 6


// arraw function
const multiply = (a: number, b: number): number => a * b;
console.log(multiply(4, 5)); // Output: 20


// annonimous function
const add = function (a: number, b: number): number {
    return a + b;
};
console.log(add(10, 15)); // Output: 25


// void function
function logMessage(message: string): void {
    console.log(`Log: ${message}`);
}

logMessage("This is a void function example.");


// never function
function throwError(message: string): never {
    throw new Error(message);
}

// Uncommenting the following line will throw an error
// throwError("This is a never function example.");


// union types
let unionValue: string | number = "Hello";
console.log(unionValue);
unionValue = 42;
console.log(unionValue);


// literal types
type Direction = "North" | "South" | "East" | "West";
let direction: Direction = "North";
console.log(`Direction: ${direction}`);


// nullable types
let nullableValue: string | null = "I can be null";
console.log(nullableValue);
nullableValue = null;
console.log(nullableValue);


// type aliases
type User = {
    name: string;
    age: number;
};

let user: User = { name: "Eve", age: 25 };
console.log(`User Name: ${user.name}, User Age: ${user.age}`);


// intersection types
type Admin = {
    name: string;
    privileges: string[];
};

type Employee = {
    name: string;
    startDate: Date;
};

type ElevatedEmployee = Admin & Employee;

let elevatedEmployee: ElevatedEmployee = {
    name: "Frank",
    privileges: ["create-server"],
    startDate: new Date(),
};

console.log(`Elevated Employee Name: ${elevatedEmployee.name}`);
console.log(`Privileges: ${elevatedEmployee.privileges.join(", ")}`);
console.log(`Start Date: ${elevatedEmployee.startDate.toDateString()}`);


// array types
let numberArray: number[] = [1, 2, 3, 4, 5];
console.log(`Number Array: ${numberArray.join(", ")}`);

let arrayOfStrOrNumber: (string | number)[] = ["Hello", 42, "World", 100];
console.log(`Array of String or Number: ${arrayOfStrOrNumber.join(", ")}`);


// tuple types
let tuple: [string, number] = ["Alice", 30];
console.log(`Tuple: Name - ${tuple[0]}, Age - ${tuple[1]}`);

const [name, age] = tuple;
console.log(`Destructured Tuple: Name - ${name}, Age - ${age}`);


// enum types
enum Color {
    Red,
    Green,
    Blue,
}

let color: Color = Color.Green;
console.log(`Color: ${Color[color]}`); // Output: Color: Green


// interface types
interface Person {
    name: string;
    age: number;
    greet(): string;
}


// interface reopening
interface Person {
    occupation: string;
}

let person: Person = {
    name: "Grace",
    age: 28,
    occupation: "Software Developer", // This will cause an error since occupation is not defined in the Person interface
    greet() {
        return `Hello, my name is ${this.name} and I am ${this.age} years old.`;
    },
};

console.log(person.greet());


// interfaces vs type aliases
// Interfaces can be extended and implemented, while type aliases cannot.
// Interfaces can be merged, while type aliases cannot.
// Type aliases can represent more complex types (e.g., union types, intersection types), while interfaces are primarily used for object shapes.

interface LivingBeing {
    name: string;
}

// classes
class Animal implements LivingBeing {

    // public variable
    public name: string;

    // private, protected variables
    // private age: number;
    // protected species: string;

    // static variable
    // static count: number = 0;

    age: number;

    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }

    makeSound(): void {
        console.log(`${this.name} makes a sound.`);
    }
}

class Dog extends Animal {
    constructor(name: string, age: number) {
        super(name, age);
    }

    makeSound(): void {
        console.log(`${this.name} barks.`);
    }
}

const dog = new Dog("Buddy ", 5);
dog.makeSound(); // Output: Buddy barks.


// abstract classes
abstract class Shape {
    abstract area(): number;
}

class Circle extends Shape {
    radius: number;

    constructor(radius: number) {
        super();
        this.radius = radius;
    }

    area(): number {
        return Math.PI * this.radius * this.radius;
    }
}

const circle = new Circle(5);
console.log(`Area of the circle: ${circle.area()}`);

// polymorphism, encapsulation, inheritance are also supported in TypeScript classes.


// generics
function identity<T>(arg: T): T {
    return arg;
}

console.log(identity<string>("Hello, Generics!")); // Output: Hello, Generics!
console.log(identity<number>(42)); // Output: 42    


// type assertions
let someValue: unknown = "This is a string.";
let strLength: number = (someValue as string).length;
console.log(`String Length: ${strLength}`); // Output: String Length: 17
