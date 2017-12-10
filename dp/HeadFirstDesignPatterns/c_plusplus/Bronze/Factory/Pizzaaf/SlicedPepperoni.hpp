#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_SLICED_PEPPERONI_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_SLICED_PEPPERONI_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class SlicedPepperoni : public Pepperoni {
	public: virtual std::string toString() {
		return "Sliced Pepperoni";
	}
};

} // namespace Abstract
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif