#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_ADAPTER_GOOSE_ADAPTER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_ADAPTER_GOOSE_ADAPTER_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Adapter {

class GooseAdapter : public Quackable {
	Goose* goose;
 
	public: GooseAdapter(Goose* goose) {
		this->goose = goose;
	}
	public: virtual void quack() {
		goose->honk();
	}
	public: virtual std::string toString() {
		return "Goose pretending to be a Duck";
	}
};

} // namespace Adapter
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif