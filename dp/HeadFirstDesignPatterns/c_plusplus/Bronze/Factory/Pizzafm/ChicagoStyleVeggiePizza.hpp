#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_CHICAGO_VEGGIE_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_CHICAGO_VEGGIE_PIZZA_HPP_

#include "Pizzafm.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Method {

class ChicagoStyleVeggiePizza : public Pizza {
	public: ChicagoStyleVeggiePizza() {
		name = "Chicago Deep Dish Veggie Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
 
		toppings.push_back("Shredded Mozzarella Cheese");
		toppings.push_back("Black Olives");
		toppings.push_back("Spinach");
		toppings.push_back("Eggplant");
	}
 	public: virtual void cut() {
		std::cout << "Cutting the pizza into square slices" << std::endl;
	}
};

} // namespace Method
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif