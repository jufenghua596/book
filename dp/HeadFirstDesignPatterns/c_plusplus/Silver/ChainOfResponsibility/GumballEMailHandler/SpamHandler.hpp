#ifndef	_HFDP_CPP_CHAIN_OF_RESPONSIBILITY_SPAM_HANDLER_HPP_
#define _HFDP_CPP_CHAIN_OF_RESPONSIBILITY_SPAM_HANDLER_HPP_

namespace HeadFirstDesignPatterns {
namespace ChainOfResponsibility {
namespace GumballEMailHandler {

class SpamHandler : public Handler {
	public: explicit SpamHandler( const Handler* successor = 0 ) :
		Handler( successor ) {
	}
	public: void handleRequest( std::string request ) const {
		std::transform( request.begin(), request.end(), request.begin(), tolower );

		if( canHandleRequest( request ) == true ) {
			Handler::canHandleRequest( request );
		} else {
			Handler::handleRequest( request );
		}
	}
	public: bool canHandleRequest( const std::string& request ) const {
		bool value = false;

		if( std::string::npos != request.find( "bread" ) ) {
			value = true;
		} else if( std::string::npos != request.find( "buzzin" ) ) {
			value = true;
		} else if( std::string::npos != request.find( "cuzzin" ) ) {
			value = true;
		} else if( std::string::npos != request.find( "eyeball" ) ) {
			value = true;
		}
		return value;
	}
	public: void print() const {
		std::cout << std::endl << "Spam mail, send to shredder:";
		Handler::print();
	}
};

} // namespace GumballEMailHandler
} // namespace ChainOfResponsibility
} // namespace HeadFirstDesignPatterns

#endif
