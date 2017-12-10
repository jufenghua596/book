#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_CHICAGO_CLAM_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_CHICAGO_CLAM_PIZZA_HPP_

#include "Pizzafm.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Method {

class ChicagoStyleClamPizza : public Pizza {
	public: ChicagoStyleClamPizza() {
		name = "Chicago Style Clam Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
 
		toppings.push_back("Shredded Mozzarella Cheese");
		toppings.push_back("Frozen Clams from Chesapeake Bay");
	}
	public: virtual void cut() {
		std::cout << "Cutting the pizza into square slices" << std::endl;
	}
};

} // namespace Method
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif