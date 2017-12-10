#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_GARLIC_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_GARLIC_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class Garlic : public Veggies {
	public: virtual std::string toString() {
		return ("Garlic");
	}
};

} // namespace Abstract
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif