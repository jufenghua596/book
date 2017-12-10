#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_SIMPLE_FACTORY_VEGGIE_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_SIMPLE_FACTORY_VEGGIE_PIZZA_HPP_

#include "Pizzas.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Simple {

class VeggiePizza : public Pizza {
	public: VeggiePizza() {
		name = "Veggie Pizza";
		dough = "Crust";
		sauce = "Marinara Sauce";
		toppings.push_back("Fresh Mozzarella");
		toppings.push_back("Grated Parmesan");
		toppings.push_back("Diced onion");
		toppings.push_back("Sliced mushrooms");
		toppings.push_back("Sliced red pepper");
		toppings.push_back("Sliced black olives");
	}
};

} // namespace Simple
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif