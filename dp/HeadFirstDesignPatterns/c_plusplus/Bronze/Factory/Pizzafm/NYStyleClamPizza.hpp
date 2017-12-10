#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_NY_CLAM_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_NY_CLAM_PIZZA_HPP_

#include "Pizzafm.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Method {

class NYStyleClamPizza : public Pizza {
	public: NYStyleClamPizza() {
		name = "NY Style Clam Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		toppings.push_back("Grated Reggiano Cheese");
		toppings.push_back("Fresh Clams from Long Island Sound");
	}
};

} // namespace Method
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif