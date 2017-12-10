#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_PIZZA_STORE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_PIZZA_STORE_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class PizzaStore {
	public: virtual Pizza* createPizza(std::string type) = 0;
	public: virtual Pizza* orderPizza(std::string type) {
		Pizza* pizza = createPizza(type);
		std::cout << "--- Making a " << pizza->getName() << " ---" << std::endl;
		pizza->prepare();
		pizza->bake();
		pizza->cut();
		pizza->box();
		return pizza;
	}
};

} // namespace Method
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif