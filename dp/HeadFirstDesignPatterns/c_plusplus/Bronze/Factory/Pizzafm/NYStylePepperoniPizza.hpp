#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_NY_PEPPERONI_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_NY_PEPPERONI_PIZZA_HPP_

#include "Pizzafm.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Method {

class NYStylePepperoniPizza : public Pizza {
	public: NYStylePepperoniPizza() {
		name = "NY Style Pepperoni Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		toppings.push_back("Grated Reggiano Cheese");
		toppings.push_back("Sliced Pepperoni");
		toppings.push_back("Garlic");
		toppings.push_back("Onion");
		toppings.push_back("Mushrooms");
		toppings.push_back("Red Pepper");
	}
};

} // namespace Method
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif