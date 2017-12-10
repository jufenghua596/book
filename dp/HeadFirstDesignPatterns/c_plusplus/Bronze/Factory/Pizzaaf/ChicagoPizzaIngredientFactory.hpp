#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_CHICAGO_INGREDIENT_FACTORY_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_CHICAGO_INGREDIENT_FACTORY_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class ChicagoPizzaIngredientFactory : public PizzaIngredientFactory {
	public: virtual Dough* createDough() {
		return new ThickCrustDough();
	}
 	public: virtual Sauce* createSauce() {
		return new PlumTomatoSauce();
	}
 	public: virtual Cheese* createCheese() {
		return new MozzarellaCheese();
	}
 	public: virtual std::vector<Veggies*> createVeggies() {
		std::vector<Veggies*> veggies;
		veggies.push_back(new BlackOlives());
		veggies.push_back(new Spinach());
		veggies.push_back(new Eggplant());
		return veggies;
	}
 	public: virtual Pepperoni* createPepperoni() {
		return new SlicedPepperoni();
	}
	public: virtual Clams* createClam() {
		return new FrozenClams();
	}
};

} // namespace Abstract
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif