#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_COMPOSITE_FLOCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_COMPOSITE_FLOCK_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Composite {

class Flock : public Quackable {
	private: std::vector<Quackable*> quackers;

	public: virtual void add (Quackable* quacker) {
		quackers.push_back(quacker);
	}
	public: virtual void quack() {
		for (std::vector<Quackable*>::iterator it = quackers.begin(); quackers.end() != it; ++it) {
			Quackable* quacker = *it;
			quacker->quack();
		}
	}
	public: virtual std::string toString() {
		return "Flock of Quackers";
	}
};

} // namespace Composite
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif

