#include "DinerMergerI.hpp"

using namespace HeadFirstDesignPatterns::Iterator::DinerMergerI;

int main(int argc, char* argv[]) {
		PancakeHouseMenu* pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu* dinerMenu = new DinerMenu();
		Waitress* waitress = new Waitress(pancakeHouseMenu, dinerMenu);
		waitress->printMenu();
		waitress->printVegetarianMenu();

		std::cout << "\nCustomer asks, is the Hotdog vegetarian?" << std::endl;
		std::cout << "Waitress says: ";
		if (waitress->isItemVegetarian("Hotdog")) {
			std::cout << "Yes" << std::endl;
		} else {
			std::cout << "No" << std::endl;
		}
		std::cout << "\nCustomer asks, are the Waffles vegetarian?" << std::endl;
		std::cout << "Waitress says: ";
		if (waitress->isItemVegetarian("Waffles")) {
			std::cout << "Yes" << std::endl;
		} else {
			std::cout << "No" << std::endl;
		}

	return 0;
}