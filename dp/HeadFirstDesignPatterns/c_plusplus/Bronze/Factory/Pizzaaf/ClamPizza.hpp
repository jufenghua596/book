#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_CLAM_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_CLAM_PIZZA_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class ClamPizza : public Pizza {
	private: PizzaIngredientFactory* ingredientFactory;
 
	public: ClamPizza(PizzaIngredientFactory* ingredientFactory) {
		this->ingredientFactory = ingredientFactory;
	}
 	public: void virtual prepare() {
		std::cout << "Preparing " << getName().c_str() << std::endl;
		dough = ingredientFactory->createDough();
		sauce = ingredientFactory->createSauce();
		cheese = ingredientFactory->createCheese();
		clam = ingredientFactory->createClam();
	}
};

} // namespace Abstract
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif