#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_ADAPTER_DUCK_CALL_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_ADAPTER_DUCK_CALL_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Adapter {

class DuckCall : public Quackable {
	public: virtual void quack() {
		std::cout << "Kwak" << std::endl;
	}
};

} // namespace Adapter
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif