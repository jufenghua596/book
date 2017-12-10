#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_NYPIZZA_INGREDIENT_FACTORY_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_NYPIZZA_INGREDIENT_FACTORY_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class NYPizzaIngredientFactory : public PizzaIngredientFactory {
 
	public: virtual Dough* createDough() {
		return new ThinCrustDough();
	}
	public: virtual Sauce* createSauce() {
		return new MarinaraSauce();
	}
 	public: virtual Cheese* createCheese() {
		return new ReggianoCheese();
	}
 	public: virtual std::vector<Veggies*> createVeggies() {
		std::vector<Veggies*> veggies;
		veggies.push_back(new Garlic());
		veggies.push_back(new Onion());
		veggies.push_back(new Mushroom());
		veggies.push_back(new RedPepper());
		return veggies;
	}
 	public: virtual Pepperoni* createPepperoni() {
		return new SlicedPepperoni();
	}
	public: virtual Clams* createClam() {
		return new FreshClams();
	}
};

} // namespace Abstract
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif