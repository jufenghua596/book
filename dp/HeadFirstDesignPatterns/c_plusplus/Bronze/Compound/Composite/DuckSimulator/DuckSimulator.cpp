#include "DuckSimulator.hpp"

using namespace HeadFirstDesignPatterns::Compound::Composite;

int QuackCounter::numberOfQuacks = 0;

void simulate(Quackable* duck) {
	duck->quack();
}

int main(int argc, char* argv[]) {
	AbstractDuckFactory* duckFactory = new CountingDuckFactory();

	Quackable* redheadDuck = duckFactory->createRedheadDuck();
	Quackable* duckCall = duckFactory->createDuckCall();
	Quackable* rubberDuck = duckFactory->createRubberDuck();
	Quackable* gooseDuck = new GooseAdapter(new Goose());

	std::cout << std::endl << "Duck Simulator: With Composite - Flocks" << std::endl;

	Flock* flockOfDucks = new Flock();

	flockOfDucks->add(redheadDuck);
	flockOfDucks->add(duckCall);
	flockOfDucks->add(rubberDuck);
	flockOfDucks->add(gooseDuck);

	Flock* flockOfMallards = new Flock();

	Quackable* mallardOne = duckFactory->createMallardDuck();
	Quackable* mallardTwo = duckFactory->createMallardDuck();
	Quackable* mallardThree = duckFactory->createMallardDuck();
	Quackable* mallardFour = duckFactory->createMallardDuck();

	flockOfMallards->add(mallardOne);
	flockOfMallards->add(mallardTwo);
	flockOfMallards->add(mallardThree);
	flockOfMallards->add(mallardFour);

	flockOfDucks->add(flockOfMallards);

	std::cout << std::endl << "Duck Simulator: Whole Flock Simulation" << std::endl;
	simulate(flockOfDucks);

	std::cout << std::endl << "Duck Simulator: Mallard Flock Simulation" << std::endl;
	simulate(flockOfMallards);

	std::cout << std::endl << "The ducks quacked " << QuackCounter::getQuacks() << " times" << std::endl;

	return 0;
}