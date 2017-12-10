#include "Pizzas.hpp"

using namespace HeadFirstDesignPatterns::Factory::Simple;

int main(int argc, char* argv[]) {
	SimplePizzaFactory* factory = new SimplePizzaFactory();
	PizzaStore* store = new PizzaStore(factory);

	Pizza* pizza = store->orderPizza("cheese");
	std::cout << "We ordered a " << pizza->getName() << std::endl;

	pizza = store->orderPizza("veggie");
	std::cout << "We ordered a " << pizza->getName() << std::endl;

	return 0;
}

