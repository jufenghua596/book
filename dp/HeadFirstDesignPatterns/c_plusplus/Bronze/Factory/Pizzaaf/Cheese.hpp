#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_CHEESE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_CHEESE_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class Cheese {
	public: virtual std::string toString() = 0;
};

} // namespace Abstract
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif