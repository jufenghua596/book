#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_QUACKOLOGIST_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_QUACKOLOGIST_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Observer {

class Quackologist : public Observer {
 
	public: virtual void update(QuackObservable* duck) {
		std::cout << "Quackologist: " << dynamic_cast<Quackable*>(duck)->toString() << " just quacked." << std::endl;
	}
	public: virtual std::string toString() {
		return "Quackologist";
	}
};

} // namespace Observer
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif
