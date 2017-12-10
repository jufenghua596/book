#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_DINER_MENU_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_ITERATOR_DINER_MERGER_DINER_MENU_HPP_

namespace HeadFirstDesignPatterns {
namespace Iterator {
namespace DinerMerger {

class DinerMenu : public Menu {
	private: static const int MAX_ITEMS = 6;
	private: int numberOfItems;
	private: MenuItem** menuItems;
  
	public: DinerMenu() : numberOfItems(0) {
		menuItems = new MenuItem*[MAX_ITEMS + 1];	// added one additional entry;
		for (int i = 0; i <= MAX_ITEMS; i++)		// to hold a null (0) value
			menuItems[i] = 0;						// so hasNext() will work
 
		addItem("Vegetarian BLT",
			"(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
		addItem("BLT",
			"Bacon with lettuce & tomato on whole wheat", false, 2.99);
		addItem("Soup of the day",
			"Soup of the day, with a side of potato salad", false, 3.29);
		addItem("Hotdog",
			"A hot dog, with saurkraut, relish, onions, topped with cheese",
			false, 3.05);
		addItem("Steamed Veggies and Brown Rice",
			"Steamed vegetables over brown rice", true, 3.99);
		addItem("Pasta",
			"Spaghetti with Marinara Sauce, and a slice of sourdough bread",
			true, 3.89);
	}
	public: virtual void addItem(std::string name, std::string description, bool vegetarian, double price) {
		MenuItem* menuItem = new MenuItem(name, description, vegetarian, price);
		if (numberOfItems >= MAX_ITEMS) {
			std::cerr << "Sorry, menu is full!  Can't add item to menu" << std::endl;
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}
	public: virtual MenuItem** getMenuItems() {
		return menuItems;
	}
	public: virtual Iterator<MenuItem>* createIterator() {
		return dynamic_cast<Iterator<MenuItem>*>(new DinerMenuIterator(menuItems));
	}
	// other menu methods here
};

} // namespace DinerMerger
} // namespace Iterator
} // namespace HeadFirstDesignPatterns

#endif
