#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_SIMPLE_FACTORY_CHEESE_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_SIMPLE_FACTORY_CHEESE_PIZZA_HPP_

#include "Pizzas.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Simple {

class CheesePizza : public Pizza {
	public: CheesePizza() {
		name = "Cheese Pizza";
		dough = "Regular Crust";
		sauce = "Marinara Pizza Sauce";
		toppings.push_back("Shredded Mozzarella");
		toppings.push_back("Parmesan");
	}
};

} // namespace Simple
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif