#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_CHICAGO_CHEESE_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_CHICAGO_CHEESE_PIZZA_HPP_

#include "Pizzafm.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Method {

class ChicagoStyleCheesePizza : public Pizza {
	public: ChicagoStyleCheesePizza() {
		name = "Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		toppings.push_back("Shredded Mozzarella Cheese");
	}
	public: virtual void cut() {
		std::cout << "Cutting the pizza into square slices" << std::endl;
	}
};

} // namespace Method
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif