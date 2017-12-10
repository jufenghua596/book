#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_ADAPTER_QUACKABLE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_ADAPTER_QUACKABLE_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Adapter {

class Quackable {
	public: virtual void quack() = 0;
};

} // namespace Adapter
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif