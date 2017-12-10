#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_CHICAGO_PEPPERONI_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_CHICAGO_PEPPERONI_PIZZA_HPP_

#include "Pizzafm.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Method {

class ChicagoStylePepperoniPizza : public Pizza {
	public: ChicagoStylePepperoniPizza() {
		name = "Chicago Style Pepperoni Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
 
		toppings.push_back("Shredded Mozzarella Cheese");
		toppings.push_back("Black Olives");
		toppings.push_back("Spinach");
		toppings.push_back("Eggplant");
		toppings.push_back("Sliced Pepperoni");
	}
	public: virtual void cut() {
		std::cout << "Cutting the pizza into square slices" << std::endl;
	}
};

} // namespace Method
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif