#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOSITE_MENUS_WAITRESS_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOSITE_MENUS_WAITRESS_HPP_

namespace HeadFirstDesignPatterns {
namespace Composite	 {
namespace Menus {

class Waitress {
	private: MenuComponent* allMenus;
 
	public: Waitress(MenuComponent* allMenus) {
		this->allMenus = allMenus;
	}
 	public: virtual void printMenu() {
		allMenus->print();
	}
};

} // namespace Menus
} // namespace Composite
} // namespace HeadFirstDesignPatterns

#endif

