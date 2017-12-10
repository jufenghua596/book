#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_ADAPTER_DUCK_ADAPTER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_ADAPTER_DUCK_ADAPTER_HPP_

#include "Ducks.hpp"
#include <stdlib.h>
#include <process.h>

namespace HeadFirstDesignPatterns {
namespace Adapter {
namespace Ducks {

class DuckAdapter : public Turkey {
	private: Duck* duck;
	private: int random;

	public: DuckAdapter(Duck* duck) {
		this->duck = duck;
		srand(_getpid());
		random = rand() % 5;
		if (!random)
			random = 1;
	}
	public: virtual void gobble() {
		duck->quack();
	}
 	public: virtual void fly() {
		for(int i=0; i < random; i++) {
			duck->fly();
		}
	}
};

} // namespace Ducks
} // namespace Adapter
} // namespace HeadFirstDesignPatterns

#endif