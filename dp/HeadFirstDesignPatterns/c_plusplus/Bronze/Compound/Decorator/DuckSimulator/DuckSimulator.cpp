#include "DuckSimulator.hpp"

using namespace HeadFirstDesignPatterns::Compound::Decorator;

int QuackCounter::numberOfQuacks = 0;

void simulate(Quackable* duck) {
	duck->quack();
}

int main(int argc, char* argv[]) {
	Quackable* mallardDuck = new QuackCounter(new MallardDuck());
	Quackable* redheadDuck = new QuackCounter(new RedheadDuck());
	Quackable* duckCall = new QuackCounter(new DuckCall());
	Quackable* rubberDuck = new QuackCounter(new RubberDuck());
	Quackable* gooseDuck = new GooseAdapter(new Goose());

	std::cout << std::endl << "Duck Simulator: With Decorator" << std::endl;

	simulate(mallardDuck);
	simulate(redheadDuck);
	simulate(duckCall);
	simulate(rubberDuck);
	simulate(gooseDuck);

	std::cout << "The ducks quacked " << QuackCounter::getQuacks() << " times" << std::endl;

	return 0;
}