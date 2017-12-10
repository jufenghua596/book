#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_COMPOSITE_QUACK_COUNTER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_COMPOSITE_QUACK_COUNTER_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Composite {

class QuackCounter : public Quackable {
	private: Quackable* duck;
	private: static int numberOfQuacks;
  
	public: QuackCounter (Quackable* duck) {
		this->duck = duck;
	}
	public: virtual void quack() {
		duck->quack();
		numberOfQuacks++;
	}
	public: static int getQuacks() {
		return numberOfQuacks;
	}
	public: virtual std::string toString() {
		return duck->toString();
	}
};

} // namespace Composite
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif
