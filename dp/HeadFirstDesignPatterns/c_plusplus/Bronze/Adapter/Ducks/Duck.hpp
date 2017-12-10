#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_ADAPTER_DUCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_ADAPTER_DUCK_HPP_

#include "Ducks.hpp"

namespace HeadFirstDesignPatterns {
namespace Adapter {
namespace Ducks {

class Duck {
	public: virtual void quack() = 0;
 	public: virtual void fly() = 0;
};

} // namespace Ducks
} // namespace Adapter
} // namespace HeadFirstDesignPatterns

#endif