#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_ADAPTER_GOOSE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_ADAPTER_GOOSE_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Adapter {

class Goose {
	public: virtual void honk() {
		std::cout << "Honk" << std::endl;
	}
};

} // namespace Adapter
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif