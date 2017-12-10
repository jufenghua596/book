#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_SPINACH_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_SPINACH_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class Spinach : public Veggies {
	public: virtual std::string toString() {
		return ("Spinach");
	}
};

} // namespace Abstract
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif