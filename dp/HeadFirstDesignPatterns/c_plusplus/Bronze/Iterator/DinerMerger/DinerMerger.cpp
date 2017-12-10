#include "DinerMerger.hpp"

using namespace HeadFirstDesignPatterns::Iterator::DinerMerger;

int main(int argc, char* argv[]) {

    PancakeHouseMenu* pancakeHouseMenu = new PancakeHouseMenu();
    DinerMenu* dinerMenu = new DinerMenu();

	Waitress* waitress = new Waitress(pancakeHouseMenu, dinerMenu);

	waitress->printMenu();

	return 0;
}