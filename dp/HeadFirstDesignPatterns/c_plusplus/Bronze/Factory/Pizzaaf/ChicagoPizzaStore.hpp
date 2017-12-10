#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_CHICAGO_STORE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_CHICAGO_STORE_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class ChicagoPizzaStore : public PizzaStore {
 	public: virtual Pizza* createPizza(std::string item) {
		Pizza* pizza = 0;
		PizzaIngredientFactory* ingredientFactory = 
			new NYPizzaIngredientFactory();
 
		if (item.compare("cheese") == 0) {
  
			pizza = new CheesePizza(ingredientFactory);
			pizza->setName("Chicago Style Cheese Pizza");
  
		} else if (item.compare("veggie") == 0) {
 
			pizza = new VeggiePizza(ingredientFactory);
			pizza->setName("Chicago Style Veggie Pizza");
 
		} else if (item.compare("clam") == 0) {
 
			pizza = new ClamPizza(ingredientFactory);
			pizza->setName("Chicago Style Clam Pizza");
 
		} else if (item.compare("pepperoni") == 0) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza->setName("Chicago Style Pepperoni Pizza");
 
		} 
		return pizza;
	}
};

} // namespace Abstract
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif