#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_MARINARA_SAUCE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_MARINARA_SAUCE_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class MarinaraSauce : public Sauce {
	public: virtual std::string toString() {
		return "Marinara Sauce";
	}
};

} // namespace Abstract
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif