#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_PIZZA_INGREDIENT_FACTORY_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_PIZZA_INGREDIENT_FACTORY_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class PizzaIngredientFactory {
	public: virtual Dough* createDough() = 0;
	public: virtual Sauce* createSauce() = 0;
	public: virtual Cheese* createCheese() = 0;
	public: virtual std::vector<Veggies*> createVeggies() = 0;
	public: virtual Pepperoni* createPepperoni() = 0;
	public: virtual Clams* createClam() = 0;
};

} // namespace Abstract
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif