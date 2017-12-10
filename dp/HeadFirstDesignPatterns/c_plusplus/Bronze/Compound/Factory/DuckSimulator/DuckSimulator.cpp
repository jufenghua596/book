#include "DuckSimulator.hpp"

using namespace HeadFirstDesignPatterns::Compound::Factory;

int QuackCounter::numberOfQuacks = 0;

void simulate(Quackable* duck) {
	duck->quack();
}

int main(int argc, char* argv[]) {

	AbstractDuckFactory* duckFactory = new CountingDuckFactory();

	Quackable* mallardDuck = duckFactory->createMallardDuck();
	Quackable* redheadDuck = duckFactory->createRedheadDuck();
	Quackable* duckCall = duckFactory->createDuckCall();
	Quackable* rubberDuck = duckFactory->createRubberDuck();
	Quackable* gooseDuck = new GooseAdapter(new Goose());

	std::cout << std::endl << "Duck Simulator: With Abstract Factory" << std::endl;

	simulate(mallardDuck);
	simulate(redheadDuck);
	simulate(duckCall);
	simulate(rubberDuck);
	simulate(gooseDuck);

	std::cout << "The ducks quacked " << QuackCounter::getQuacks() << " times" << std::endl;

	return 0;
}
