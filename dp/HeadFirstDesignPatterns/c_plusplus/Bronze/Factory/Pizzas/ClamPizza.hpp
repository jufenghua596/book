#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_SIMPLE_FACTORY_CLAM_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_SIMPLE_FACTORY_CLAM_PIZZA_HPP_

#include "Pizzas.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Simple {

class ClamPizza : public Pizza {
	public: ClamPizza() {
		name = "Clam Pizza";
		dough = "Thin Crust";
		sauce = "White garlic Sauce";
		toppings.push_back("Grated parmesan cheese");
		toppings.push_back("Clams");
	}
};

} // namespace Simple
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif