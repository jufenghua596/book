#include "Pizzaaf.hpp"

using namespace HeadFirstDesignPatterns::Factory::Abstract;

int main(int argc, char* argv[]) {
	PizzaStore* nyStore = new NYPizzaStore();
	PizzaStore* chicagoStore = new ChicagoPizzaStore();

	Pizza* pizza = nyStore->orderPizza("cheese");
	std::cout << "Ethan ordered a " << pizza->toString() << std::endl;

	pizza = chicagoStore->orderPizza("cheese");
	std::cout << "Joel ordered a " << pizza->toString() << std::endl;

	pizza = nyStore->orderPizza("clam");
	std::cout << "Ethan ordered a " << pizza->toString() << std::endl;
 
	pizza = chicagoStore->orderPizza("clam");
	std::cout << "Joel ordered a " << pizza->toString() << std::endl;

	pizza = nyStore->orderPizza("pepperoni");
	std::cout << "Ethan ordered a " << pizza->toString() << std::endl;
 
	pizza = chicagoStore->orderPizza("pepperoni");
	std::cout << "Joel ordered a " << pizza->toString() << std::endl;

	pizza = nyStore->orderPizza("veggie");
	std::cout << "Ethan ordered a " + pizza->toString() << std::endl;
 
	pizza = chicagoStore->orderPizza("veggie");
	std::cout << "Joel ordered a " << pizza->toString() << std::endl;

	return 0;
}

