#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_PANCAKE_HOUSE_MENU_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_PANCAKE_HOUSE_MENU_HPP_

namespace HeadFirstDesignPatterns {
namespace Iterator {
namespace DinerMerger {

class PancakeHouseMenu : public Menu {
	private: std::vector<MenuItem*> menuItems;
 
	public: PancakeHouseMenu() { 
		addItem("K&B's Pancake Breakfast", 
			"Pancakes with scrambled eggs, and toast", 
			true,
			2.99);
 
		addItem("Regular Pancake Breakfast", 
			"Pancakes with fried eggs, sausage", 
			false,
			2.99);
 
		addItem("Blueberry Pancakes",
			"Pancakes made with fresh blueberries",
			true,
			3.49);
 
		addItem("Waffles",
			"Waffles, with your choice of blueberries or strawberries",
			true,
			3.59);
	}
	public: virtual void addItem(std::string name, std::string description, bool vegetarian, double price) {
		MenuItem* menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.push_back(menuItem);
	}
	public: virtual std::vector<MenuItem*> getMenuItems() {
		return menuItems;
	}
	public: virtual Iterator<MenuItem>* createIterator() {
		return dynamic_cast<Iterator<MenuItem>*> (new PancakeHouseMenuIterator(menuItems));
	}
	public: virtual std::string toString() {
		return "Objectville Pancake House Menu";
	}

	// other menu methods here
};

} // namespace DinerMerger
} // namespace Iterator
} // namespace HeadFirstDesignPatterns

#endif
