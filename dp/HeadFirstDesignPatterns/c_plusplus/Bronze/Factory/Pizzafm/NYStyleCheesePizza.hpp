#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_NY_CHEESE_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_NY_CHEESE_PIZZA_HPP_

#include "Pizzafm.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Method {

class NYStyleCheesePizza : public Pizza {
	public: NYStyleCheesePizza() {
		name = "NY Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		toppings.push_back("Grated Reggiano Cheese");
	}
};

} // namespace Method
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif