#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_TEMPLATE_BARISTA_TEA_WITH_HOOK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_TEMPLATE_BARISTA_TEA_WITH_HOOK_HPP_

#include "Barista.hpp"

namespace HeadFirstDesignPatterns {
namespace Template {
namespace Barista {

class TeaWithHook : public CaffeineBeverageWithHook {

 	public: virtual void brew() {
		std::cout << "Steeping the tea" << std::endl;
	}
 	public: virtual void addCondiments() {
		std::cout << "Adding Lemon" << std::endl;
	}
  	public: virtual bool customerWantsCondiments() {

		std::string answer = getUserInput();
	
		if (answer.find('y') != -1) {
			return true;
		} else {
			return false;
		}
	}
	private: std::string  getUserInput() {
		std::string answer;
		std::cout << "Would you like lemon with your tea (y/n)? " << std::endl;
		std::cin >> answer;

		return answer;
	}
};

} // namespace Barista
} // namespace Template
} // namespace HeadFirstDesignPatterns

#endif
