#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOSITE_MENUS_MENU_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOSITE_MENUS_MENU_HPP_

namespace HeadFirstDesignPatterns {
namespace Composite {
namespace Menus {

class Menu : public MenuComponent {
	private: std::vector<MenuComponent*> menuComponents;
	private: std::string name;
	private: std::string description;
  
	public: Menu(std::string name, std::string description) {
		this->name = name;
		this->description = description;
	}
 	public: virtual void add(MenuComponent* menuComponent) {
		menuComponents.push_back(menuComponent);
	}
 	public: virtual void remove(MenuComponent* menuComponent) {
		std::remove(menuComponents.begin(), menuComponents.end(), menuComponent);
	}
 	public: virtual MenuComponent* getChild(int i) {
		return menuComponents[i];
	}
 	public: virtual std::string getName() {
		return name;
	}
 	public: virtual std::string getDescription() {
		return description;
	}
	public: virtual void print() {
		std::cout << std::endl << getName().c_str();
		std::cout << ", " << getDescription().c_str() << std::endl;
		std::cout << "---------------------" << std::endl;
  
		std::vector<MenuComponent*>::iterator itr = menuComponents.begin();
		while (itr != menuComponents.end()) {
			MenuComponent* menuComponent = *itr++;
			menuComponent->print();
		}
	}
};

} // namespace Menus
} // namespace Composite
} // namespace HeadFirstDesignPatterns

#endif
