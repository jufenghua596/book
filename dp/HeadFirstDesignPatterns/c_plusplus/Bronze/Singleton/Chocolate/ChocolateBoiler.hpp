#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_SINGLETON_CHOCOLATE_BOILER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_SINGLETON_CHOCOLATE_BOILER_HPP_

#include "Chocolate.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Singleton {

class ChocolateBoiler {
	private: bool empty;
	private: bool boiled;
	private: static ChocolateBoiler* uniqueInstance;
  
	private: ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
  	public: static ChocolateBoiler* getInstance() {
		if (uniqueInstance == 0) {
			std::cout << "Creating unique instance of Chocolate Boiler" << std::endl;
			uniqueInstance = new ChocolateBoiler();
		}
		std::cout << "Returning instance of Chocolate Boiler"<< std::endl;
		return uniqueInstance;
	}
	public: virtual void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
			// fill the boiler with a milk/chocolate mixture
		}
	}
	public: virtual void drain() {
		if (!isEmpty() && isBoiled()) {
			// drain the boiled milk and chocolate
			empty = true;
		}
	}
	public: virtual void boil() {
		if (!isEmpty() && !isBoiled()) {
			// bring the contents to a boil
			boiled = true;
		}
	}
	public: virtual bool isEmpty() {
		return empty;
	} 
	public: virtual bool isBoiled() {
		return boiled;
	}
};

} // namespace Singleton
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif 
