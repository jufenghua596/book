#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_FACTORY_GOOSE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_FACTORY_GOOSE_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Factory {

class Goose {
	public: virtual void honk() {
		std::cout << "Honk" << std::endl;
	}
	public: virtual std::string toString() {
		return "Goose";
	}
};

} // namespace Factory
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif