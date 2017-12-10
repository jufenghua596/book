#include "DuckSimulator.hpp"

using namespace HeadFirstDesignPatterns::Compound::Adapter;

void simulate(Quackable* duck) {
	duck->quack();
}

int main(int argc, char* argv[]) {
	Quackable* mallardDuck = new MallardDuck();
	Quackable* redheadDuck = new RedheadDuck();
	Quackable* duckCall = new DuckCall();
	Quackable* rubberDuck = new RubberDuck();
	Quackable* gooseDuck = new GooseAdapter(new Goose());

	std::cout << std::endl << "Duck Simulator: With Goose Adapter" << std::endl;

	simulate(mallardDuck);
	simulate(redheadDuck);
	simulate(duckCall);
	simulate(rubberDuck);
	simulate(gooseDuck);

	return 0;
}