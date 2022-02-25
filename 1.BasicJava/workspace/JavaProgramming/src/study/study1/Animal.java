package study.study1;

public abstract class Animal {
	abstract void sound();
}

class Dog extends Animal {
	@Override
	void sound() {
		System.out.println("멍멍!!");
	}
}
class Cat extends Animal {
	@Override
	void sound() {
		System.out.println("야옹~");
	}
}
class Lion extends Animal {
	@Override
	void sound() {
		System.out.println("어흥!!!");
	}
}
