#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_WAITRESS_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_WAITRESS_HPP_

namespace HeadFirstDesignPatterns {
namespace Iterator {
namespace DinerMerger {

class Waitress {
	PancakeHouseMenu* pancakeHouseMenu;
	DinerMenu* dinerMenu;
 
	public: Waitress(PancakeHouseMenu* pancakeHouseMenu, DinerMenu* dinerMenu) {
		this->pancakeHouseMenu = pancakeHouseMenu;
		this->dinerMenu = dinerMenu;
	}
	public: virtual void printMenu() {
		Iterator<MenuItem>* pancakeIterator = pancakeHouseMenu->createIterator();
		Iterator<MenuItem>* dinerIterator = dinerMenu->createIterator();

		std::cout << "MENU\n----\nBREAKFAST" << std::endl;
		printMenu(pancakeIterator);
		std::cout << "\nLUNCH" << std::endl;
		printMenu(dinerIterator);
	}
	private: virtual void printMenu(Iterator<MenuItem>* iterator) {
		while (iterator->hasNext()) {
			MenuItem* menuItem = dynamic_cast<MenuItem*>(iterator->next());
			std::cout << menuItem->getName() << ", ";
			std::cout << menuItem->getPrice() << " -- ";
			std::cout << menuItem->getDescription() << std::endl;
		}
	}
	public: virtual void printVegetarianMenu() {
		printVegetarianMenu(pancakeHouseMenu->createIterator());
		printVegetarianMenu(dinerMenu->createIterator());
	} 
	public: virtual bool isItemVegetarian(std::string name) {
		Iterator<MenuItem>* breakfastIterator = pancakeHouseMenu->createIterator();
		if (isVegetarian(name, breakfastIterator)) {
			return true;
		}
		Iterator<MenuItem>* dinnerIterator = dinerMenu->createIterator();
		if (isVegetarian(name, dinnerIterator)) {
			return true;
		}
		return false;
	}
	private: void printVegetarianMenu(Iterator<MenuItem>* iterator) {
		while (iterator->hasNext()) {
			MenuItem* menuItem = dynamic_cast<MenuItem*>(iterator->next());
			if (menuItem->isVegetarian()) {
				std::cout << menuItem->getName();
				std::cout << "\t\t" << menuItem->getPrice();
				std::cout << "\t" << menuItem->getDescription() << std::endl;
			}
		}
	}
	private: bool isVegetarian(std::string name, Iterator<MenuItem>* iterator) {
		while (iterator->hasNext()) {
			MenuItem* menuItem = dynamic_cast<MenuItem*>(iterator->next());
			if (menuItem->getName().compare(name) == 0) {
				if (menuItem->isVegetarian()) {
					return true;
				}
			}
		}
		return false;
	}
};

} // namespace DinerMerger
} // namespace Iterator
} // namespace HeadFirstDesignPatterns

#endif

