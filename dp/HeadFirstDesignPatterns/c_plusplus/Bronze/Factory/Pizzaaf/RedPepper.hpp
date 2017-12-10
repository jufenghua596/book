#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_REDPEPPER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_REDPEPPER_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class RedPepper : public Veggies {
	public: virtual std::string toString() {
		return ("Red Pepper");
	}
};

} // namespace Abstract
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif