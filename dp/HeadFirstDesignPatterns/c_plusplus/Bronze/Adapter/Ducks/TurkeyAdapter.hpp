#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_ADAPTER_TURKEY_ADAPTER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_ADAPTER_TURKEY_ADAPTER_HPP_

#include "Ducks.hpp"

namespace HeadFirstDesignPatterns {
namespace Adapter {
namespace Ducks {

class TurkeyAdapter : public Duck {
	private: Turkey* turkey;

	public: TurkeyAdapter(Turkey* turkey) {
		this->turkey = turkey;
	}
	public: virtual void quack() {
		turkey->gobble();
	}
 	public: virtual void fly() {
		for(int i=0; i < 5; i++) {
			turkey->fly();
		}
	}
};

} // namespace Ducks
} // namespace Adapter
} // namespace HeadFirstDesignPatterns

#endif