#include "DuckSimulator.hpp"

using namespace HeadFirstDesignPatterns::Compound::Ducks;

void simulate(Quackable* duck) {
	duck->quack();
}

int main(int argc, char* argv[]) {
	Quackable* mallardDuck = new MallardDuck();
	Quackable* redheadDuck = new RedheadDuck();
	Quackable* duckCall = new DuckCall();
	Quackable* rubberDuck = new RubberDuck();
	
	std::cout << std::endl << "Duck Simulator" << std::endl;

	simulate(mallardDuck);
	simulate(redheadDuck);
	simulate(duckCall);
	simulate(rubberDuck);

	return 0;
}