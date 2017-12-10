#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_VEGGIE_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_VEGGIE_PIZZA_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class VeggiePizza : public Pizza {
	private: PizzaIngredientFactory* ingredientFactory;
 
	public: VeggiePizza(PizzaIngredientFactory* ingredientFactory) {
		this->ingredientFactory = ingredientFactory;
	}
	public: virtual void prepare() {
		std::cout << "Preparing " << getName().c_str() << std::endl;
		dough = ingredientFactory->createDough();
		sauce = ingredientFactory->createSauce();
		cheese = ingredientFactory->createCheese();
		veggies = ingredientFactory->createVeggies();
	}
};

} // namespace Abstract
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif