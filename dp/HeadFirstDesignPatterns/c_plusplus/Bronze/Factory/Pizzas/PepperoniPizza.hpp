#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_SIMPLE_FACTORY_PEPPERONI_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_SIMPLE_FACTORY_PEPPERONI_PIZZA_HPP_

#include "Pizzas.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Simple {

class PepperoniPizza : public Pizza {
	public: PepperoniPizza() {
		name = "Pepperoni Pizza";
		dough = "Crust";
		sauce = "Marinara sauce";
		toppings.push_back("Sliced Pepperoni");
		toppings.push_back("Sliced Onion");
		toppings.push_back("Grated parmesan cheese");

	}
};

} // namespace Simple
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif