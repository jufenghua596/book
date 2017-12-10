#include "DuckSimulator.hpp"

using namespace HeadFirstDesignPatterns::Compound::Observer;

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

	std::cout << std::endl << "Duck Simulator: With Observer" << std::endl;

	Quackologist* quackologist = new Quackologist();
	flockOfDucks->registerObserver(quackologist);

	simulate(flockOfDucks);

	std::cout << std::endl << "The ducks quacked " << QuackCounter::getQuacks() << " times" << std::endl;

	return 0;
}