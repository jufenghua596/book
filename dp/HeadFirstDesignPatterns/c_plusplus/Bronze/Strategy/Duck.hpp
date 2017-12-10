#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_DUCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_STRATEGY_DUCK_HPP_

#include "MiniDuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Strategy {

class Duck {
	protected: FlyBehavior* flyBehavior;
	protected: QuackBehavior* quackBehavior;

	protected: Duck() : flyBehavior(0), quackBehavior(0) {
	}
	public:	virtual void setFlyBehavior(FlyBehavior* fb) {
		flyBehavior = fb;
	}
	public: virtual void setQuackBehavior(QuackBehavior* qb) {
		quackBehavior = qb;
	}
	public: virtual void performFly() {
		flyBehavior->fly();
	}
	public: virtual void performQuack() {
		quackBehavior->quack();
	}
	public: virtual void swim() {
		std::cout << "All ducks float, even decoys!" << std::endl;
	}
	public: virtual void display() = 0;
};

} // namespace Strategy
} // namespace HeadFirstDesignPatterns

#endif